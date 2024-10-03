package com.whs.javacode.codesignal;

public class MultipleCode {

	public static void main(String[] args) {
		MultipleCode mc = new MultipleCode();
		String strReverse = "This is it";
		System.out.println("Reverse: "+mc.reverseString(strReverse));
	}
	
	public String reverseString(String input) {
	    StringBuilder reversed = new StringBuilder(input);
	    return reversed.reverse().toString();
	}
}
