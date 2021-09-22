package com.example.executorservice.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		// Create a fixed thread pool with maximum 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//Creates Threads as needed and deletes the inactive threads after 60 seconds of inactivity
		//ExecutorService executor = Executors.newCachedThreadPool();
		
		//Executes only one thread
	//	ExecutorService executor = Executors.newSingleThreadExecutor(); 
		 
		//Internally manages thread pool of 10 threads to run scheduled tasks
	//	ExecutorService executor = Executors.newScheduledThreadPool(10); 
		// Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		// Shut down the executor
		executor.shutdown();
	}
}
