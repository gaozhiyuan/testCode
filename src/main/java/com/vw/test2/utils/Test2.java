package com.vw.test2.utils;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

	public long numberOfClimb(int n) {
		
		
		if(n == 1)
			return 1;
		if(n == 2) 
			return 2;
		
		return numberOfClimb(n-1) + numberOfClimb(n-2);
		
		
	}
	
	public long numberOfClimbTuned(int n, Map<Integer, Long> map) {
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		
		Long num = map.get(n);
		if(num != null)
			return num;
		
		num = numberOfClimbTuned(n -1, map) + numberOfClimbTuned(n-2, map);
		map.put(n, num);
		
		return num;
	}
	
	public long numberOfClimb2(int m, int n) {
		
		if(n == 1)
			return 1;
		
		if(n <= m)
			return 2 * n - 2;
		
		long number = 0;
		for(int i = 1; i <= m; i ++) {
			number += numberOfClimb2(m, n -i);
		}
			
		
		return number;
	}
	
	public long numberOfClimbWithoutRecussor(int n) {
		if(n == 1)
			return 1;
		if(n ==2)
			return 2;
		long pre = 2;
		long prepre = 1;
		long ret = 0;
		for(int i = 3; i <=n; i ++) {
			ret = pre + prepre;
			
			prepre = pre;
			pre = ret;
			
		}
		
		return ret;
	}
	
	public long numberOfClimbDP(int n, long[] nums) {
		if(n == 1) {
			nums[0] = 1;
			return 1;
		}
		if(n ==2) {
			nums[1] = 2;
			return 2;
		}
		if(nums[n -1] != -1)
			return nums[n - 1];
		
		nums[n -1] = numberOfClimbDP(n - 1, nums) + numberOfClimbDP(n -2, nums);
		
		return nums[n -1];
	}
	
	public long numberOfClimbDP2(int n) {
		long[] nums = new long[n];
		nums[0] = 1;
		nums[1] = 2;
		for(int i = 3; i <=n; i ++) {
			int index = i -1;
			nums[index] = nums[index - 1] + nums[index -2];
		}
		
		return nums[n-1];
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		
		long number;
		int n = 1000;
		
//		long number = t.numberOfClimb(50);
//		System.out.println(number);
		
//		Map<Integer, Long> map = new HashMap<>();
//		number = t.numberOfClimbTuned(1000, map);
		
		number = t.numberOfClimbWithoutRecussor(n);
		
		System.out.println(number);

//		System.out.println(t.numberOfClimb2(6, 35));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Long.MAX_VALUE);
		
		long[] nums = new long[n];
		for(int i = 0; i < n; i ++) {
			nums[i] = -1;
		}
		number = t.numberOfClimbDP(n, nums);
		System.out.println(number);
		
		number = t.numberOfClimbDP2(n);
		System.out.println(number);
		
		
	}
}
