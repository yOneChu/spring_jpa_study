package org.kyhslam.thread;

public class ThreadTest2 implements Runnable {

	@Override
	public void run() {
		
		for(int i=1000; i < 1500; i++) {
			System.out.println("@@@@ " + i);
		
		}
	}
	
}
