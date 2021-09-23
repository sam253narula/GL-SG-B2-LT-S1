package com.b.example.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Create a fixed thread pool with maximum 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//Creates Threads as needed and deletes the inactive threads after 60 seconds of inactivity
		//ExecutorService executor = Executors.newCachedThreadPool();
		
		//Executes only one thread
	//	ExecutorService executor = Executors.newSingleThreadExecutor(); 
		 
		//Internally manages thread pool of 10 threads to run scheduled tasks
	//	ExecutorService executor = Executors.newScheduledThreadPool(10); 
//		ScheduledExecutorService executor =
//		        Executors.newScheduledThreadPool(5);
//
//		ScheduledFuture scheduledFuture =
//				executor.schedule(new Callable() {
//		        public Object call() throws Exception {
//		        	System.out.println();
//		            System.out.println("Executed!");
//		            return "Called!";
//		        }
//		    },
//		    5,
//		    TimeUnit.SECONDS);
//		
//		while(scheduledFuture.isDone()) {
//			System.out.println(scheduledFuture.get());
//		}
		
		// Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		// Shut down the executor
		executor.shutdown();
	}
}
