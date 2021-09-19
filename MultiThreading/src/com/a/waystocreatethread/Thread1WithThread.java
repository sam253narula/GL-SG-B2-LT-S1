package com.a.waystocreatethread;

public class Thread1WithThread extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("Thread1 is running");
		} catch (Exception e) {
				System.out.println("Exception raised in thread1"+ e);
		}
	}

}
