package com.e.forkjoinpool.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/*A RecursiveAction is a task which does not return any value. It just does some work, e.g. writing data to disk, and then exits.

A RecursiveAction may still need to break up its work into smaller chunks which can be executed by independent threads or CPUs.*/

public class MyRecursiveActionDemo extends RecursiveAction {

	private long workLoad = 0;

	public MyRecursiveActionDemo(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			List<MyRecursiveActionDemo> subtasks = new ArrayList<MyRecursiveActionDemo>();

			subtasks.addAll(createSubtasks());

			for (RecursiveAction subtask : subtasks) {
				subtask.fork();
			}

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
		}
	}

	private List<MyRecursiveActionDemo> createSubtasks() {
		List<MyRecursiveActionDemo> subtasks = new ArrayList<MyRecursiveActionDemo>();

		MyRecursiveActionDemo subtask1 = new MyRecursiveActionDemo(this.workLoad / 2);
		MyRecursiveActionDemo subtask2 = new MyRecursiveActionDemo(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}

}

class Test {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		System.out.println("Number of available core in the processor : " + Runtime.getRuntime().availableProcessors());
		System.out.println("Number of active thread before invoking: " + forkJoinPool.getActiveThreadCount());
		MyRecursiveActionDemo myRecursiveAction = new MyRecursiveActionDemo(36);

		forkJoinPool.invoke(myRecursiveAction);
		System.out.println("Number of active thread after invoking: " + forkJoinPool.getActiveThreadCount());
		System.out.println("Common Pool Size is: " + forkJoinPool.getPoolSize());
	}
}