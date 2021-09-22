package com.example.executorservice.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		// Create a fixed thread pool with maximum 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		// Shut down the executor
		executor.shutdown();
	}
}
