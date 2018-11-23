package com.vw.test2.utils;

public class Test8 {

	public void quickSort(int[] a, int left, int right) {
		if(left >= right)
			return;
		
		int i = left;
		int j = right;
		int key = a[left];
		while(i < j) {
			while(i < j && a[j] >= key)
				j --;
			while(i < j && a[i] <= key)
				i ++;
			if(i != j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			} else {
				a[left] = a[i];
				a[i] = key;
			}
		}
		
		quickSort(a, left, i - 1);
		quickSort(a, i + 1, right);
	}
	
	public void quickSort2(int[] a, int left, int right) {
		if(left >= right)
			return;
		
		int i = left + 1;
		int j = left + 1;
		int key = a[left];
		for(; j <= right; j ++) {
			if(a[j] < key) {
				if(i != j) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
				i++;
			}
		}
		
		a[left] = a[i - 1];
		a[i-1] = key;
		
		quickSort2(a, left, i -2);
		quickSort2(a, i , right);
	}
	
	public void quickSort3(int[] a, int left, int right) {
		if(left >= right)
			return;
		
		int i = right;
		int j = right;
		int key = a[left];
		for(; j >= left; j --) {
			if(a[j] > key) {
				if(i != j) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
				i--;
			}
		}
		
		a[left] = a[i];
		a[i] = key;
		
		quickSort3(a, left, i -1);
		quickSort3(a, i+1 , right);
	}
	
	public static void main(String[] args) {
		Test8 t = new Test8();
		
		int[] a = new int[] {4, 1, 7, 6, 9, 2, 8, 0, 3, 5};
		t.quickSort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i ++)
			System.out.print(a[i] + ", ");
		
		System.out.println();
		
		int[] a2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};	
		t.quickSort2(a2, 0, a2.length - 1);
		for(int i = 0; i < a2.length; i ++)
			System.out.print(a2[i] + ", ");
		
		System.out.println();
		
		int[] a3 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		t.quickSort3(a3, 0, a3.length - 1);
		for(int i = 0; i < a3.length; i ++)
			System.out.print(a3[i] + ", ");
	}
}
