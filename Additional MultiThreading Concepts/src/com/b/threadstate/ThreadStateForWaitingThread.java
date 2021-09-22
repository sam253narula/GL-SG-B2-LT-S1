package com.b.threadstate;

/* When you search on Google "Java Thread States", you get
The java thread states are as follows:
New.
Runnable.
Running.
Non-Runnable (Blocked) : A thread that is blocked waiting for a monitor lock is in this state.
Terminated.
Waiting : A thread that is waiting indefinitely for another thread to perform a particular action is in this state
A thread that is waiting indefinitely for another thread to perform a particular action is in this state
Qin to Students: What is the Thread state when it is waiting with Thread.sleep(10000) method ?
*/
public class ThreadStateForWaitingThread {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        t.start();
        Thread.sleep(100); // make sure the other thread has started, this Thread.sleep(100) is suspending the main thread
        System.out.println(t.getState());
    }
}