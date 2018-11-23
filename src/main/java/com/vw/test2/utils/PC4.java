package com.vw.test2.utils;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PC4 {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		BlockingQueue<Integer> q = new LinkedBlockingQueue<>(5);
		
		for(int i = 0; i < 5; i ++) {
			new Thread(() -> {
				while(true) {
					int v = new Random().nextInt(10);
					try {
						Thread.sleep(2000);
						queue.put(v);
						System.out.println("Producer: " + Thread.currentThread().getName() + " put " + v + " into the queue!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			new Thread(() -> {
				while(true) {
					try {
						Thread.sleep(1000);
						System.out.println("Consumer: " + Thread.currentThread().getName() + " take " + queue.take() + " from the queue");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
