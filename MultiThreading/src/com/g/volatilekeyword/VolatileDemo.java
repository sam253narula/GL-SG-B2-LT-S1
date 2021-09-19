package com.g.volatilekeyword;

//Show Students how to debug the code in multi-threaded environment

public class VolatileDemo {

	static volatile int SHARED_INT_VALUE = 0;
	
	public static void main(String[] args) {
		new ObserverThread().start();
		new ActorThread().start();
	}
}
