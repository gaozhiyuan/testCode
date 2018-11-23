package com.vw.test2.utils;

import java.util.concurrent.Semaphore;

public class PC3 {

	private static Semaphore semaphore = new Semaphore(5);
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i ++) {
			new Thread(() -> {
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				semaphore.release();
			}).start();
		}
	}
	
}
