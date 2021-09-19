package com.e.waitnotify;

public class WaitingThread implements Runnable {

	private Integer value;

	public WaitingThread(Integer value) {
		this.value = value;
	}

	@Override
	public void run() {
		synchronized (value) {
			System.out.println("waiting to get the lock");
			try {
				value.wait();
				System.out.println("waiting thread recieved notification by notifier thread");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

}
