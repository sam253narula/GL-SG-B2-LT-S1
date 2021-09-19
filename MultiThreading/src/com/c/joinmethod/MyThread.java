package com.c.joinmethod;

public class MyThread implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("Thread running, name of the thread is:  "+ thread.getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();	
		}
		System.out.println("Thread ended, name of the thread is: "+ thread.getName());
		
	}

}
