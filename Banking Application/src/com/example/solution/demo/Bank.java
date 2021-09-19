package com.example.solution.demo;

public class Bank {

	public static final int MAX_ACCOUNT = 10;
	public static final int MAX_AMOUNT = 10;
	public static final int INITIAL_BALANCE = 100;

	private Account[] accounts = new Account[MAX_ACCOUNT];

	public Bank() {
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(INITIAL_BALANCE);
		}
	}

	public synchronized void transfer(int fromAccount, int toAccount, int amount) {
		if (amount <= accounts[fromAccount].getBalance()) {
			accounts[fromAccount].withdraw(amount);
			accounts[toAccount].deposit(amount);
			String message = "%s transfered %d from %s to %s. Total balance: %d\n";
			System.out.printf(message, Thread.currentThread().getName(), amount, fromAccount, toAccount,
					getTotalBalance());
		}
	}

	public synchronized int getTotalBalance() {
		int total = 0;

		for (int i = 0; i < accounts.length; i++) {
			total += accounts[i].getBalance();
		}

		return total;
	}
}
