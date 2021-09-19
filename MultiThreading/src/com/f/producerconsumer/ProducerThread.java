package com.f.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable {

	private BlockingQueue blockingQueue;

	public ProducerThread(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			int value = 0;
			while (true) {
				blockingQueue.put(value);
				System.out.println("Produced " + value);
				value++;
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
