package com.a.waystocreatethread;

import java.util.Iterator;

public class ThreadingDemo {
	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i < n; i++) {
			Thread t1 = new Thread1WithThread();
			t1.start();
			Thread t2 = new Thread(new Thread2WithRunnable());
			t2.start();
		}
	}
}
