package com.kyhslam;

public class ThreadEx1 {

	
	public static void main(String[] args) {
		
		Tex a = new Tex();
		Tex2 b = new Tex2();
		
		a.start();
		b.start();
		
		
		//System.out.println("kkk");
		
		
	}
	
	
	
	

}
class Tex extends Thread {
	@Override
	public void run() {
		
		
		for(int i=10; i < 20; i++) {
			System.out.println("i == " + i);
		}
		
	}
}


class Tex2 extends Thread {
	@Override
	public void run() {
		
		for(int i=0; i < 9; i++) {
			System.out.println("i == " + i);
		}
		
	}
}