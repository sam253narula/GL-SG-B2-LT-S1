package com.i.concurrentcollection;

import java.util.ArrayList;
import java.util.List;
/* Normal collection classes cannot handle two different kind of operation(like in below case read and write)
in same thread(This program runs in main thread. */
public class ConcurrentAccessProblem {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list  =  new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
//		for (Integer integer : list) {
//			list.add(5);
//			System.out.println(integer);
//		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.add(5);
			System.out.println(list.get(i));
		}
	}
}
