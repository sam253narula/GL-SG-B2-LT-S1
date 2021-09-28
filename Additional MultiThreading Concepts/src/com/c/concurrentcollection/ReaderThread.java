package com.c.concurrentcollection;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ReaderThread extends Thread {
    private ConcurrentHashMap<Integer, String> map;
    private String name;
 
    public ReaderThread(ConcurrentHashMap<Integer, String> map, String threadName) {
        this.map = map;
        this.name = threadName;
    }
 
    public void run() {
        while (true) {
            ConcurrentHashMap.KeySetView<Integer, String> keySetView = map.keySet();
            Iterator<Integer> iterator = keySetView.iterator();
 
            LocalDateTime time = LocalDateTime.now();
            String output = time + ": " + name + ": ";
 
            while (iterator.hasNext()) {
                Integer key = iterator.next();
                String value = map.get(key);
                output += key + "=>" + value + "; ";
            }
 
            System.out.println(output);
 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}