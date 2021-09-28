package com.c.concurrentcollection;

import java.util.concurrent.ConcurrentHashMap;

// In this program we have 2 writer threads and 5 reader threads
public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
// One map is shared by 7 threads in total, 2 threads are writing value to it and 5 threads are reading value from it
		new WriterThread(map, "Writer-1", 1).start();
		new WriterThread(map, "Writer-2", 2).start();

		for (int i = 1; i <= 5; i++) {
			new ReaderThread(map, "Reader-" + i).start();
		}
	}
}
