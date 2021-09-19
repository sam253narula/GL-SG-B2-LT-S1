package com.h.deadlock.solution;

public class Thread1 implements Runnable {
	
	private Class1 obj1;
	private Class2 obj2;

	public Thread1(Class1 obj1, Class2 obj2) {
		this.obj1 =obj1;
		this.obj2 =obj2;
	}

	@Override
	public void run() {
		synchronized (obj1) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread1 got lock on obj1, waiting to get lock on obj2");
			synchronized (obj2) {
				System.out.println("Thread1 got lock on obj2 also");
			}
		}

	}

}
