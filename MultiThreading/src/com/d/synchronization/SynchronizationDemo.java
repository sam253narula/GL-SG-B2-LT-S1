package com.d.synchronization;

public class SynchronizationDemo {
	public static void main(String[] args) {
			MathUtils math =  new MathUtils();
			Thread t1 = new Thread1(math);
			Thread t2  = new Thread(new Thread2(math));
			t1.start();
			t2.start();
	}
}
