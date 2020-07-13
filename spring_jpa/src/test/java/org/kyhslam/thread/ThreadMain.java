package org.kyhslam.thread;

public class ThreadMain {

	public static void main(String[] args) {
		
		//ThreadTest1 aa = new ThreadTest1();
		ThreadTest2 bb = new ThreadTest2();
		
		//Thread t1 = new Thread(aa, "company");
		Thread t2 = new Thread(bb, "account");
		
		//t1.start();
		t2.start();
		
		Thread.currentThread().getName();
		
		
		
	}

}
