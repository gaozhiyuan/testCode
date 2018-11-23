package com.vw.test2.utils;

public class TestT1 {

	public static void main(String[] args) {
		char[] c = new char[7];
		c[1] = 'A';
		c[2] = 'B';
		c[3] = 'C';
		c[4] = 'D';
		c[5] = 'E';
		c[6] = 'F';
		
		preOrder(c, 1);
	}
	
	public static void preOrder(char[] c, int index) {
		if(c == null) {
			return;
		}
		if(index >= c.length) {
			return;
		}
		System.out.print(c[index]);
		preOrder(c, 2*index);
		preOrder(c, 2*index + 1);
	}
}
