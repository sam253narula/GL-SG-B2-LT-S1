package com.d.additionalconcepts;

public class ThreadDeathDemo {
    public static void main(String[] args) throws InterruptedException {
           Thread thread1 = new Thread("thread-1") {
                  public void run() {
                        try {
                               System.out.println(Thread.currentThread().getName()
                                             + " has started");
                               //calling stop method throws ThreadDeath error.
                               stop();

                        } catch (ThreadDeath e) {
                               System.out.println(Thread.currentThread().getName()
                                             + " has died");
                        }
                  }
           };
           thread1.start();
 
    }
}
