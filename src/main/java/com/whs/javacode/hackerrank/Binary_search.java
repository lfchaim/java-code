/**
 *  author - Umesh Reddy
 *	Contact me @ urgd4@mst.edu
 */
package com.whs.javacode.hackerrank;

import java.util.Scanner;

/**

 */
public class Binary_search
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String tem = s.nextLine();
		tem = tem.substring(1, tem.length()-1);
		String tem1 [] = tem.split(",");
		int data [] = new int [tem1.length];
		for(int i =0;i<data.length;i++)
		{
			data[i]= Integer.parseInt(tem1[i]);
		}
		int k = Integer.parseInt(s.nextLine());
		System.out.println(bin_search(data, k));
		
	}

	public static int bin_search(int[] data, int k)
	{
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == k)
				return i;
		}
		return -1;
	}

}
