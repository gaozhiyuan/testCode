package com.vw.test2.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class PC {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();
		int max = 5;
		Object lock = new Object();

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				while (true) {
					synchronized (PC.class) {
						while (queue.size() >= max) {
							try {
								PC.class.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						Random r = new Random();
						queue.add(r.nextInt(10));
						System.out.println("Producer: " + Thread.currentThread().getId() + ": "
								+ Thread.currentThread().getName() + ", " + "queue.size: " + queue.size());
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
						PC.class.notify();
					}
				}
			}).start();

			new Thread(() -> {
				while (true) {
					synchronized (PC.class) {
						while (queue.size() == 0) {
							try {
								PC.class.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						int v = queue.poll();
						System.out.println("Consumer: " + Thread.currentThread().getId() + ": "
								+ Thread.currentThread().getName() + " v: " + v);
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
						PC.class.notify();
					}
				}
			}).start();
		}

		List<String> list = Arrays.asList(new String[] { "a", "b", "c" });
		list.forEach(System.out::println);
	}
}
