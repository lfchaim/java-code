package com.whs.javacode.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'reverseArray' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY a as parameter.
	 */

	public static List<Integer> reverseArray(List<Integer> a) {
		// Write your code here
		for (int i = 0, j = a.size() - 1; i < a.size(); i++, j--) {
			if (i < j) {
				int temp = a.get(i);
				a.set(i, a.get(j));
				a.set(j, temp);
			}
		}
		return a;
	}

}

public class Arrays_DS {
	public static void main(String[] args) throws IOException {
		int chA = (int)'A';
		List<Integer> list = new ArrayList<>();
		for( int i = 0; i < 27; i++ ) {
			list.add(chA++);
		}
		Result res = new Result();
		Calendar c1 = Calendar.getInstance();
		List<Integer> revList = res.reverseArray(list);
		Calendar c2 = Calendar.getInstance();
		//revList.forEach(System.out::print);
		for( int i = 0; i < revList.size(); i++ )
			System.out.print(revList.get(i)+"-");
		System.out.println("Time: "+(c2.getTimeInMillis()-c1.getTimeInMillis())+" ms");
	}
}
