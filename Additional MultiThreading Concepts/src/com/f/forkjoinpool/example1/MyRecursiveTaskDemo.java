package com.f.forkjoinpool.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*A RecursiveTask is a task that returns a result.
It may split its work up into smaller tasks, and merge the result of these smaller tasks into a collective result.
The splitting and merging may take place on several levels*/

public class MyRecursiveTaskDemo extends RecursiveTask<Long> {

	private long workLoad = 0;

	public MyRecursiveTaskDemo(long workLoad) {
		this.workLoad = workLoad;
	}

	protected Long compute() {

		// if workLoad is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			List<MyRecursiveTaskDemo> subtasks = new ArrayList<MyRecursiveTaskDemo>();
			subtasks.addAll(createSubtasks());

			for (MyRecursiveTaskDemo subtask : subtasks) {
				subtask.fork();
			}

			long result = 0;
			for (MyRecursiveTaskDemo subtask : subtasks) {
				result += subtask.join();
			}
			return result;

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
			return workLoad * 3;
		}
	}

	private List<MyRecursiveTaskDemo> createSubtasks() {
		List<MyRecursiveTaskDemo> subtasks = new ArrayList<MyRecursiveTaskDemo>();

		MyRecursiveTaskDemo subtask1 = new MyRecursiveTaskDemo(this.workLoad / 2);
		MyRecursiveTaskDemo subtask2 = new MyRecursiveTaskDemo(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}
}

class Test {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		MyRecursiveTaskDemo myRecursiveTask = new MyRecursiveTaskDemo(36);

		Long result = forkJoinPool.invoke(myRecursiveTask);
		
		System.out.println("Result : "+ result);
	}
}
