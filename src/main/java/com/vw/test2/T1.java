package com.vw.test2;

public class T1 {

	public static class A {
		public static int a = 10;
		
		public static void print() {
			System.out.println("this is A");
		}
	}
	
	public static class B extends A {
		public static void print() {
			System.out.println("this is B");
		}
	}
	
	public static void main(String[] args) {
		B.print();
		B b = new B();
		b.print();
		
		System.out.println("B.a" + B.a);
	}
}
