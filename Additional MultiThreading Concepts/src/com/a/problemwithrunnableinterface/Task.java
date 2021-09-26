package com.a.problemwithrunnableinterface;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	@Override
	public String call() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			Thread.sleep(1000);
			System.out.println(i+" while I am not interrupted");
			Thread.interrupted();
		}

		return "All is Well";
	}

}
