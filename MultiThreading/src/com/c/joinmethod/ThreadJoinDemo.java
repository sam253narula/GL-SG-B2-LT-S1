package com.c.joinmethod;

public class ThreadJoinDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread(), "t1");
		Thread t2 = new Thread(new MyThread(), "t2");
		Thread t3 = new Thread(new MyThread(), "t3");
		t1.start();

		try {
			t1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		t2.start();

		try {
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		t3.start();

		try {
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("All the user threads have finsihed execution");
	}
}
