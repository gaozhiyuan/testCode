package com.vw.test2.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PC2 {

	private Queue<Integer> queue = new LinkedList<>();
	private Lock locker = new ReentrantLock();
	private Condition notFull = locker.newCondition();
	private Condition notEmpty = locker.newCondition();
	private int max = 5;
	
	public Thread generateProducer() {
		return new Thread(() -> {
			while(true) {
				locker.lock();
				while(queue.size() == max) {
					System.out.println("queue is full!!!");
					try {
						notFull.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Random r = new Random();
				int v = r.nextInt(100);
				queue.add(v);
				System.out.println("Producer: " + Thread.currentThread().getName() + " put " + v + " to queue!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notEmpty.signalAll();
				locker.unlock();
			}
		});
	}
	
	public Thread generateCustomer() {
		return new Thread(() -> {
			while(true) {
				locker.lock();
				while(queue.isEmpty()) {
					System.out.println("queue is empty!!!");
					try {
						notEmpty.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
				System.out.println("Consumer: " + Thread.currentThread().getName() + " take " + queue.poll() + " from queue!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notFull.signalAll();
				locker.unlock();
			}
		});
	}
	
	public static void main(String[] args) {
		PC2 t = new PC2();
		
		for(int i = 0; i < 5; i ++) {
			t.generateProducer().start();
			t.generateCustomer().start();
		}
		
	}
}
