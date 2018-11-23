package com.vw.test2.utils;

public class Test14 {

	public void bubleSort(int[] a) {
		if(a == null || a.length == 0)
			return;
		
		for(int i = 0; i < a.length; i ++) {
			boolean exchangeFlag = false;
			for(int j = 0; j < a.length - i - 1; j ++) {
				if(a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					exchangeFlag = true;
				}
			}
			
			if(!exchangeFlag)
				return;
		}
	}
	
	public void insertSort(int[] a) {
		if(a == null || a.length == 0)
			return;
		for(int i = 1; i < a.length; i ++) {
			int j = i - 1;
			int key = a[i];
//			for(;j >= 0; j--) {
//				if(a[j] > key)
//					a[j+1] = a[j];
//				else
//					break;
//			}
			while(j >= 0) {
				if(a[j] > key)
					a[j+1] = a[j];
				else
					break;
				j--;
			}
			a[j+1] = key;
		}
	}
	
	public void selectSort(int[] a) {
		if(a == null || a.length == 0)
			return;
		for(int i = 0; i < a.length - 1; i ++) {
			int minIndex = i;
			for(int j = i + 1; j < a.length; j ++) {
				if(a[j] < a[minIndex])
					minIndex = j;
			}
			if(minIndex != i) {
				int tmp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = tmp;
			}
		}
	}
	
	public void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}
	
	public void mergeSort(int[] a, int start, int end) {
		if(start >= end)
			return;
		int mid = start + ((end - start) >> 2);
		mergeSort(a, start, mid);
		mergeSort(a, mid + 1, end);
		merge(a, start, end, mid);
	}
	
	public void merge(int[] a, int start, int end, int mid) {
		int[] tmp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= end) {
			if(a[i] <= a[j])
				tmp[k++] = a[i++];
			else
				tmp[k++] = a[j++];
		}
		int leftStart = i;
		int leftEnd = mid;
		if(i > mid) {
			leftStart = j;
			leftEnd = end;
		}
		
		while(leftStart <= leftEnd)
			tmp[k++] = a[leftStart++];
		
		for(int m = start; m <= end; m++)
			a[m] = tmp[m-start];
	}
	
	public static void main(String[] args) {
		Test14 t = new Test14();
		
		int[] a = new int[] {10, 4, 9, 8, 6, 5, 2, 3, 7, 1};
		Test13.printArray(a);
		t.bubleSort(a);
		Test13.printArray(a);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		a = new int[] {10, 4, 9, 8, 6, 5, 2, 3, 7, 1};
		t.insertSort(a);
		Test13.printArray(a);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		a = new int[] {10, 4, 9, 8, 6, 5, 2, 3, 7, 1};
		t.selectSort(a);
		Test13.printArray(a);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		a = new int[] {10, 4, 9, 8, 6, 5, 2, 3, 7, 1, 20, 15, 14};
		t.mergeSort(a);
		Test13.printArray(a);
	}
}
