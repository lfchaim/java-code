package com.whs.javacode.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Akatsuki_vs_Leaf
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int data1[] = new int [n];
		int data2[] = new int [n];
		int data[] = new int [n];
		for(int i =0;i<n;i++)
		{
			data1[i]= s.nextInt();
		}
		for(int i =0;i<n;i++)
		{
			data1[i]= s.nextInt();
			data[i]= i+1;
		}
		int ans [][] = new int [n][n];
		for(int i =0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
//				ans[i][j]= Math.abs(a)
			}
		}
		ArrayList<ArrayList<Integer>> all_perm = permuteUnique(data);
		
	}
	
	
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num)
	{
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++)
		{
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (ArrayList<Integer> l : returnList)
			{
				for (int j = 0; j < l.size() + 1; j++)
				{
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}

		return returnList;
	}

}
