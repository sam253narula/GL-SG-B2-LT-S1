package com.f.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<Integer>(5);
		
		Thread producerThread = new Thread(new ProducerThread(blockingQueue));
		Thread consumerThread =  new Thread(new ConsumerThread(blockingQueue));
		
		producerThread.start();
		consumerThread.start();
		
	//	producerThread.join();
	//	consumerThread.join();
	}
}
