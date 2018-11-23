package com.vw.test2.utils;

import java.util.Stack;

public class Test13 {

	public void qSort(int[] a) {
		if(a==null || a.length == 0)
			return;
		qSort(a, 0, a.length - 1);
		
	}
	
	public void qSort(int[] a, int start, int end) {
		if(start >= end)
			return;
		int p = partition2(a, start, end);
		qSort(a, start, p - 1);
		qSort(a, p + 1, end);
		
	}
	
	public int partition(int[] a, int start, int end) {
		if(start >= end)
			return -1;
		int i = start;
		int j = start;
		int key = a[end];
		for(; j < end; j ++) {
			if(a[j] < key) {
				if(i != j) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
				i ++;
			}
		}
		a[end] = a[i];
		a[i] = key;
		
		return i;
	}
	
	public void qSort2(int[] a, int start, int end) {
		if(start >= end)
			return;
		Stack<Integer> stack = new Stack<>();
		int p = partition(a, start, end);
		stack.push(end);
		stack.push(p+1);
		stack.push(p-1);
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int s = stack.pop();
			int e = stack.pop();
			p = partition(a, s, e);
			if(p != -1) {
				stack.push(e);
				stack.push(p+1);
				stack.push(p-1);
				stack.push(s);
			}
		}
	}
	
	public int partition2(int[] a, int start, int end) {
		int i = end;
		int j = end;
		int key = a[start];
		for(;j > start; j--) {
			if(a[j] > key) {
				if(i != j) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
				i--;
			}
		}
		a[start] = a[i];
		a[i] = key;
		
		return i;
	}
	
	public static void printArray(int[] a) {
		for(int i : a) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Test13 t = new Test13();
		int[] a = new int[] {20, 14, 11, 29, 48, 32, 1, 5, 8, 2, 12, 6};
		printArray(a);
		t.qSort(a);
		printArray(a);
		
		a = new int[] {20, 14, 11, 29, 48, 32, 1, 5, 8, 2, 12, 6};
		printArray(a);
		t.qSort2(a, 0, a.length - 1);
		printArray(a);
		
	}
}
