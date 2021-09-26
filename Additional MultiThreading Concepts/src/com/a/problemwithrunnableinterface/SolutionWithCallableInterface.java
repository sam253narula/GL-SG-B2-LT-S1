package com.a.problemwithrunnableinterface;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SolutionWithCallableInterface {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// FutureTask is a concrete class that implements both Runnable and Future
		FutureTask[] randomNumberTasks = new FutureTask[1];
		Callable callable = new Task();

		// Create the FutureTask with Callable
		randomNumberTasks[0] = new FutureTask(callable);

		// As it implements Runnable, create Thread with FutureTask
		Thread t = new Thread(randomNumberTasks[0]);
		t.start();
		t.sleep(5000);
		t.interrupt();

		// As it implements Future, we can call get()
		while(randomNumberTasks[0].isDone()){
		System.out.println(randomNumberTasks[0].get());
		}

		// This method blocks till the result is obtained
		// The get method can throw checked exceptions
		// like when it is interrupted. This is the reason
		// for adding the throws clause to main
	}

}
