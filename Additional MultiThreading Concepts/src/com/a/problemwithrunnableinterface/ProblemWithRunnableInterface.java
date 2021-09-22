package com.a.problemwithrunnableinterface;

// SHow problem that when using runnable we cannot throw any checked exception
public class ProblemWithRunnableInterface {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                	// Inside run method of runnable you cannot throw any Checked Exception
                //	throw new InterruptedException();
                    e.printStackTrace();
                }
            };
        };
        t.start();
        Thread.sleep(100); // make sure the other thread has started, this Thread.sleep(100) is suspending the main thread
        System.out.println(t.getState());
    }
}