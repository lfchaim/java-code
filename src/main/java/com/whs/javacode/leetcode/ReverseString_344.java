package com.whs.javacode.leetcode;

public class ReverseString_344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		char[] a = new char[26];
		int intA = (int)'A';
		for( int i = 0; i < 26; i++ )
			a[i] = (char)intA++;
		s.reverseString(a);
		for( int i = 0; i < a.length; i++ )
			System.out.print(a[i]);
	}

}
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length; i++, j--) {
			if (i < j) {
				char temp = s[i];
				s[i] = s[j];
				s[j] = temp;
			}
		}
    }
}