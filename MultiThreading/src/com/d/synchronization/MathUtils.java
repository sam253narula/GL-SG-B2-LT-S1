package com.d.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MathUtils {

	 Lock locker = new ReentrantLock();
	//synchronized
	void getMultiples(int n) {
		System.out.println("Started 1");
		System.out.println("Started 2");
		System.out.println("Started 3");
	//	synchronized (this) {
			try {
				 locker.lock();
				for (int i = 1; i <= 5; i++) {
					System.out.println(n * i);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} finally {
				 locker.unlock();
			}
	//	}

		System.out.println("Ended 1");
		System.out.println("Ended 2");
		System.out.println("Ended 3");

		}
	}
