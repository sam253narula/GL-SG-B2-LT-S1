package com.i.concurrentcollection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentAccessSolution {

	public static void main(String[] args) {
		List<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for (Integer integer : list) {
			list.add(5);
			System.out.println(integer);
		}
		
		System.out.println("new output");
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
