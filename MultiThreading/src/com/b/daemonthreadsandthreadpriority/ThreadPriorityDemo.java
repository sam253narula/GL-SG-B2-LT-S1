package com.b.daemonthreadsandthreadpriority;
/* Thread priority ranges from 1 to 10, if no priority is set the default priority is 5, 10 means highest priority, 1 means lowest
 * IMP Note: Getting a higher priority still doesn't guarantee the order of thread execution, it is 
 written on the documentation that when there is load on thread scheduler that time it will 
 choose threads according to the priority, even if you set the thread as daemon thread still the priority doesn't reduces but
 this threads now runs in background until any one other user thread is alive, in this case, daemon thread terminates last,even after main thread
 So sequence of termination of threads is first user threads -> main thread -> daemon thread -> then JVM shuts down :-P
 
 */

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new SampleThread("t1"));
		Thread t2 = new Thread(new SampleThread("t2"));
		Thread t3 = new Thread(new SampleThread("t3"));

		System.out.println("t1 priority : " + t1.getPriority());
		System.out.println("t2 priority : " + t2.getPriority());
		System.out.println("t3 priority : " + t3.getPriority());

		
		t1.setPriority(4);
		t2.setPriority(6);
		t3.setPriority(9);
		System.out.println("t1 new priority : " + t1.getPriority());
		System.out.println("t2 new priority : " + t2.getPriority());
		System.out.println("t3 new priority : " + t3.getPriority());
		t1.setDaemon(true);
	
		System.out.println("new t1 priority acter making it deamon : " + t1.getPriority());

		t1.start();
		t2.start();
		t3.start();
		System.out.println("Currently Running Thread : " + Thread.currentThread().getName());
		System.out.println("Main Thread Priority : " + Thread.currentThread().getPriority());
	}
}
