package com.c.concurrentcollection;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class WriterThread extends Thread {
	private ConcurrentMap<Integer, String> map;
	private Random random;
	private String threadName;

	public WriterThread(ConcurrentMap<Integer, String> map, String threadName, long randomSeed) {
		this.map = map;
		this.random = new Random(randomSeed);
		this.threadName = threadName;
	}

	public void run() {
		while (true) {
			// Below random function will generate a value between 0 to 10 for me
			Integer key = random.nextInt(10);
			String value = threadName;

			// Adding the key and value if it is not present in map
			if (map.putIfAbsent(key, value) == null) {
				LocalDateTime time = LocalDateTime.now();
				String output = String.format("%s: %s has put [%d => %s]", time, threadName, key, value);
				System.out.println(output);
				// Alternate way of writing
//				System.out.printf("%s: %s has put [%d => %s] \n", time, threadName, key, value);
//				System.out.println();
			}

			// Now randomly a number between  0 to 10 which will be the key to be removed
			Integer keyToRemove = random.nextInt(10);
			
			// If the key is successfully removed then printing the date time when it was removed along with thread name that removed this key and the key and value which were removed
			if (map.remove(keyToRemove, value)) {
				LocalDateTime time = LocalDateTime.now();
				String output = String.format("%s: %s has removed [%d => %s]", time, threadName, keyToRemove, value);
				System.out.println(output);
			}
			// Now purposely adding some delay, so that the reader thread will read the values from the map
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}