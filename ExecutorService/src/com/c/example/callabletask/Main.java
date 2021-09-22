package com.c.example.callabletask;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) throws ExecutionException {
		
		//Callable task : Print character a 100 times
		Callable<String> printCharA100TImescallableTask = () -> {

			for (int i = 0; i < 100; i++) {
				System.out.print('a');
			}
			System.out.println();
			return "Done priting character a 100 times at Current time :: " + LocalDateTime.now();
		};
		//Callable task : Print character b 100 times
		Callable<String> printCharB100TImescallableTask = () -> {

			for (int i = 0; i < 100; i++) {
				System.out.print('b');
			}
			System.out.println();
			return "Done priting character b 100 times at Current time :: " + LocalDateTime.now();
		};
		//Callable task : Print character c 100 times
		Callable<String> printCharC100TImescallableTask = () -> {

			for (int i = 0; i < 100; i++) {
				System.out.print('c');
			}
			System.out.println();
			return "Done priting character c 100 times at Current time :: " + LocalDateTime.now();
		};
		// Instantiate Executor Service 
		ExecutorService executor = Executors.newFixedThreadPool(3);

		List<Callable<String>> tasksList = Arrays.asList(printCharA100TImescallableTask, printCharB100TImescallableTask,
				printCharC100TImescallableTask);

		// 1.How to execute tasks list using invokeAll() method
		try {
			List<Future<String>> results = executor.invokeAll(tasksList);

			for (Future<String> result : results) {
				System.out.println(result.get());
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		// 2. How to execute individual tasks using submit() method
		Future<String> result = executor.submit(printCharA100TImescallableTask);

		while (result.isDone() == false) {
			try {
				System.out.println("The method return value : " + result.get());
				break;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

			// Sleep for 1 second then again check if the result is done
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Shut down the executor service
		executor.shutdownNow();
	}
}