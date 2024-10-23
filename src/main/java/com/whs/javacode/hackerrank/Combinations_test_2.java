package com.whs.javacode.hackerrank;

import java.util.ArrayList;

public class Combinations_test_2
{

	public static void main(String[] args)
	{
		int [] data = {1,2,3,4,5};
		int total_number = (int)( Math.pow(2, data.length));
//		System.out.println(total_number);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(); 
		for(int i=1;i<total_number;i++)
		{
//			System.out.print(Integer.toBinaryString(i)+":");
			ArrayList<Integer> temp = new ArrayList<Integer>();
			String binary_string = Integer.toBinaryString(i);
			
			for(int j=binary_string.length()-1;j>=0;j--)
			{
				if(binary_string.charAt(j)=='1')
				{
//					System.out.print(j+" ");
					temp.add(data[binary_string.length()-1-j]);
				}
			}
			
			ans.add(temp);
//			System.out.println(" ");
		}
		
		System.out.println(ans);
		
		
		
	}

}
