package com.vw.test2.utils;

public class Test10 {

	public void mergeSort(int[] a, int l, int r) {
		if(l >= r) {
			return;
		}
		
		int mid = l + ((r - l) >> 1) ;
		mergeSort(a, l, mid);
		mergeSort(a, mid + 1, r);
		merge(a, l, mid, r);
	}
	
	public void merge(int[] a, int l, int mid, int r) {
		int[] tmp = new int[r - l + 1];
		int i = l;
		int j = mid + 1;
		int index = 0;
		while(i <= mid && j <= r) {
			if(a[i] <= a[j]) {
				tmp[index++] = a[i];
				i ++;
			} else {
				tmp[index++] = a[j];
				j ++;
			}			
		}
		int start = i; 
		int end = mid;
		if(i == mid + 1) {
			start = j;
			end = r;
		}
		
		while(start <= end) {
			tmp[index ++] = a[start];
			start ++;
		}
		
		index = 0;
		for(i = l; i <= r; i ++) {
			a[i] = tmp[index ++];
		}
 	}
	
	public static void main(String[] args) {
		Test10 t = new Test10();
		
		int[] a = new int[] {5, 8, 4, 2, 6, 3, 9, 7, 1};
		
		t.mergeSort(a, 0, a.length - 1);
		
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + ", ");
		}
	}
}
