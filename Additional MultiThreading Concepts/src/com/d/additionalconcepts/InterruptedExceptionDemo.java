package com.d.additionalconcepts;

public class InterruptedExceptionDemo {

	public static void main(String[] args) {
		Thread unstoppableThreadWhichCanBeStoppedBeczOfInterruptedFunctionality = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {

					if (Thread.interrupted()) {
						System.out.println("I was Interrupted");
						break;
					}

					System.out.println("While I am not interrupted");

				}
			}
		});
		unstoppableThreadWhichCanBeStoppedBeczOfInterruptedFunctionality.start();
		unstoppableThreadWhichCanBeStoppedBeczOfInterruptedFunctionality.interrupt();

	}
}
