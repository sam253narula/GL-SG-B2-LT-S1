package com.example;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/*The conditions can be used to enable communications
among threads: a thread can specify what to do under a
certain condition.
*  Conditions are objects created by invoking the new Condition()
method on a Lock object.
*  Once a condition is created, you can use its await(), signal(),
and signalAll() methods for thread communications. This is similar to wait, notify and notifyAll methods of Object class
*  The await() method causes the current thread to wait until the condition
is signaled.
*  The signal() method wakes up one waiting thread.Similar to notify
*  The signalAll() method wakes all waiting threads.SImilar to NotifyAll 
*  
*  */

public class SingleAccountDemo {
	private static Account account = new Account();

	public static void main(String[] args) {
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("Thread 1\t\tThread 2\t\tBalance");
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
	}

	private static class Account {
		// Create a new lock
		private static Lock lock = new ReentrantLock();
		// Create a condition
		private static Condition newDeposit = lock.newCondition();
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public void withdraw(int amount) {
			lock.lock(); // Acquire the lock
			try {
				while (balance < amount) {
					System.out.println("\t\t\tWait for a deposit");
					newDeposit.await();
				}
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock(); // Release the lock
			}
		}

		public void deposit(int amount) {
			lock.lock(); // Acquire the lock
			try {
				balance += amount;
				System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
				// Signal thread waiting on the condition
				newDeposit.signalAll();
			} finally {
				lock.unlock(); // Release the lock
			}
		}
	}

	// The below task adds the amount to the account
	public static class DepositTask implements Runnable {
		public void run() {
			try {
				// Purposely delay it to let the withdraw method proceed
				while (true) {
					account.deposit((int) (Math.random() * 10) + 1);
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	// The below task subtracts the amount from the account
	public static class WithdrawTask implements Runnable {
		public void run() {
			while (true) {
				account.withdraw((int) (Math.random() * 10) + 1);
			}
		}
	}
}
