package com.vw.test2.utils;

public class Test11 {

	public int bSearch1(int[] a, int v) {
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		while(low <= high) {
			mid = low + ((high - low) >> 1);
			if(a[mid] > v)
				high = mid - 1;
			else if(a[mid] < v)
				low = mid + 1;
			else
				return mid;		
		}
		
		return -1;
	}
	
	public int bSearch2(int[] a, int v) {
		int low = 0;
		int high = a.length -1;
		int mid = 0;
		
		while(low <= high) {
			mid = low + ((high - low) >> 1);
			if(a[mid] > v)
				high = mid - 1;
			else if(a[mid] < v)
				low = mid + 1;
			else {
				if(mid == 0 || a[mid - 1] < v)
					return mid;
				else
					high = mid -1;
			}
		}
		
		return -1;
	}
	
	public int bSearch3(int[] a, int v) {
		
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = low + ((high - low) >> 1);
			if(a[mid] > v)
				high = mid - 1;
			else if(a[mid] < v)
				low = mid + 1;
			else {
				if(mid == a.length - 1 || a[mid + 1] > v)
					return mid;
				else
					low = mid + 1;
			}
		}
		
		return -1;
	}
	
	public int bSearch4(int[] a, int v) {
		
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = low + ((high - low) >> 1);
			if(a[mid] >= v) {
				if(mid == 0 || a[mid - 1] < v)
					return mid;
				else
					high = mid - 1;
			} else
				low = mid + 1;
		}
		
		return -1;
	}
	
	public int bSearch5(int[] a, int v) {
		
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = low + ((high - low) >> 1);
			if(a[mid] > v)
				high = mid - 1;
			else {
				if(mid == a.length - 1 || a[mid + 1] > v)
					return mid;
				else
					low = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Test11 t = new Test11();
		int[] a = new int[] {1, 2, 3, 4, 8, 10, 12, 14, 20, 25, 28, 29, 31};
		int position = t.bSearch1(a, 8);
		System.out.println("position: " + position);
		
		a = new int[] {1, 2, 3, 4, 5, 10, 12, 14, 20, 25, 28, 29, 31};
		position = t.bSearch2(a, 5);
		System.out.println("position: " + position);
		
		a = new int[] {1, 2, 3, 4, 5, 10, 12, 14, 20, 24, 25, 26, 30};
		position = t.bSearch3(a, 25);
		System.out.println("position: " + position);
		
		a = new int[] {1, 2, 6, 6, 6, 10, 12, 14, 20, 24, 25, 26, 30};
		position = t.bSearch4(a, 4);
		System.out.println("position: " + position);
		
		a = new int[] {1, 2, 6, 6, 6, 10, 12, 14, 20, 24, 28, 28, 28};
		position = t.bSearch5(a, 30);
		System.out.println("position: " + position);
		
		
	}
}
