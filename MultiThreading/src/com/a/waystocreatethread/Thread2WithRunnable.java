package com.a.waystocreatethread;

public class Thread2WithRunnable implements Runnable {

	@Override
	public void run() {

		try {
			System.out.println("Thread 2 is running");
		} catch (Exception e) {
			System.out.println("Exception raised in thread 2"+ e);
		}
	}

}
