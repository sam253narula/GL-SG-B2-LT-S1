package com.g.additionaldeadlock;

import java.util.concurrent.TimeUnit;
/**
 * @author Samarth Narula
 * 
 *  Problem Level : Difficult
 *  All Method to solve DeadLock
 *  1) Use Join and make threads sequential
 *  2) Maintain same sequence of locking of objects in all threads
 *  3) Use wait and NotifyAll or notify, depending on use-case
 *  Demo Method 2 : Solving the DeadLock problem with Wait and Notify and wait and notifyAll method
 */

public class DeadLockDemo {
	public static void main(String[] args) {

		Integer value1 = 10;
		Integer value2 = 20;

		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				synchronized (value1) {
					try {
						System.out.println(Thread.currentThread().getName() + " I have acquired lock on value1");
						TimeUnit.SECONDS.sleep(1);
						synchronized (value2) {
							System.out.println(Thread.currentThread().getName() + " I have acquired lock on value2 and I am releasing it now");
							// When there are 2 thread waiting to be notified, notify() will not solve the problem, becz it willl notify only one waiting thread
							//value2.notify();
							// When we have more than 1 waiting thread, then we should use notifyAll()
						//	value2.notifyAll();
							
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		// Demo use of NotidyAll wit use-case of 3 threads out of which 2 will be in waiting state on some object
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				synchronized (value2) {
					String task2ThreadName = Thread.currentThread().getName();
					System.out.println(task2ThreadName + " I have acquired lock on value2");
					//To solve the deadlock, use the below code
//					try {
//						System.out.println(task2ThreadName + " Now I will release lock from value2 and re-acquire lock once notfied");
//						value2.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					synchronized (value1) {
						System.out.println(Thread.currentThread().getName() + " I have acquired lock on value1");
					}
				}
			}
		};
		
		Runnable task3 = new Runnable() {
			@Override
			public void run() {
				synchronized (value2) {
					String task3ThreadName = Thread.currentThread().getName();
					System.out.println(task3ThreadName + " I have acquired lock on value2");
					//To solve the deadlock, use the below code
//					try {
//						System.out.println(task3ThreadName + " Now I will release lock from value2 and re-acquire lock once notfied");
//						value2.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					synchronized (value1) {
						System.out.println(Thread.currentThread().getName() + " I have acquired lock on value1");
					}
				}
			}
		};
		
		Thread task1Thread = new Thread(task1);
		task1Thread.start();
		Thread task2Thread = new Thread(task2);
		task2Thread.start();
//		Thread task3Thread = new Thread(task3);
//		task3Thread.start();

	}

}
