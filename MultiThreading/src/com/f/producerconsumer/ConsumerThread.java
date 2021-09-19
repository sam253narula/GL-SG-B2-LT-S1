package com.f.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable {

	private BlockingQueue blockingQueue;

	public ConsumerThread(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int value = (int) blockingQueue.take();
				System.out.println("Consumed " + value);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
