package com.automationtesting.javademo;

public class Javademo {
	public static void substraction() {
		int a=30;
		int b=10;
		int c=a-b;
		System.out.println(c);
	
	}
	
	public static void substraction_test(int a,int b) {
	int c=a-b;
	System.out.println(c);
	}
	public static void addition_test(int a,int b) {
		int c=a+b;
		System.out.println(c);
	}
	
	
    public static void main(String[] args) {
	substraction();
	substraction_test(3990,3110);
	addition_test(2110,2221);
	
	
}
}
