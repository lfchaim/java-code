package com.whs.javacode.leetcode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Fonte: https://leetcode.com/problems/top-k-frequent-elements/description/
 * https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int qtde = 100;
		int arr[] = new int[qtde];
		for (int i = 0; i < qtde; i++) {
			arr[i] = ThreadLocalRandom.current().nextInt(1, 60 + 1);
			if( i > 0 )
				System.out.print("," );
			System.out.print(arr[i]);
		}
		System.out.println("");
		int N = arr.length;
		int K = 2;
		Calendar c1 = Calendar.getInstance();
		topKFrequent(arr, N, K);
		Calendar c2 = Calendar.getInstance();
		System.out.println("Time: " + (c2.getTimeInMillis() - c1.getTimeInMillis()));
		c1 = Calendar.getInstance();
		topKFrequentMaxHeap(arr, N, K);
		c2 = Calendar.getInstance();
		System.out.println("Time: " + (c2.getTimeInMillis() - c1.getTimeInMillis()));
		c1 = Calendar.getInstance();
		print_N_mostFrequentNumber(arr, N, K);
		c2 = Calendar.getInstance();
		System.out.println("Time: " + (c2.getTimeInMillis() - c1.getTimeInMillis()));
	}

	/**
	 * Using HashMap Time Complexity: O(N + D log D), where D is the count of
	 * distinct elements in the array Auxiliary Space: O(D), where D is the count of
	 * distinct elements in the array
	 * 
	 * @param arr
	 * @param N
	 * @param K
	 */
	static void topKFrequent(int[] arr, int N, int K) {

		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

		// Put count of all the
		// distinct elements in Map
		// with element as the key &
		// count as the value.
		for (int i = 0; i < N; i++) {
			// Get the count for the
			// element if already present in the
			// Map or get the default value which is 0.
			mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
		}

		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(mp.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (o1.getValue() == o2.getValue())
					return o2.getKey() - o1.getKey();
				else
					return o2.getValue() - o1.getValue();
			}
		});

		for (int i = 0; i < K; i++)
			System.out.print(list.get(i).getKey() + " ");
		System.out.println("topKFrequent");
	}

	/**
	 * Using Max Heap
	 * Time Complexity: O(N + K log D + D), where D is the count of distinct elements in the array. 
	 * @param arr
	 * @param N
	 * @param K
	 */
	static void topKFrequentMaxHeap(int[] arr, int N, int K) {
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

		// Put count of all the
		// distinct elements in Map
		// with element as the key &
		// count as the value.
		for (int i = 0; i < N; i++) {

			// Get the count for the
			// element if already
			// present in the Map or
			// get the default value
			// which is 0.
			mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
		}

		// Create a Priority Queue
		// to sort based on the
		// count or on the key if the
		// count is same
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
				(a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
						: Integer.compare(b.getValue(), a.getValue()));
	
		// Insert the data from the map
		// to the Priority Queue.
		for (Map.Entry<Integer, Integer> entry : mp.entrySet())
			queue.offer(entry);

		// Print the top k elements
		for (int i = 0; i < K; i++) {
			System.out.print(queue.poll().getKey() + " ");
		}
		System.out.println("topKFrequentMaxHeap");
	}

	/**
	 * Using Quick Select Time complexity: O(N + D^2). The QuickSelect algorithm
	 * takes O(D Log D) time on average and works faster than other O(D Log D)
	 * algorithms in practice Auxiliary Space: O(N)
	 * 
	 * @param nums
	 * @param k
	 * @param out
	 * @return
	 */
	static void print_N_mostFrequentNumber(int[] arr, int N, int K) {
		// Map for counting the number of occurrences
		Map<Integer, Integer> counts = new HashMap<>();

		// Put count of all the
		// distinct elements in Map
		// with element as the key &
		// count as the value.
		for (int i = 0; i < N; i++) {

			// Get the count for the
			// element if already
			// present in the Map or
			// get the default value
			// which is 0.
			counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
		}

		// Creating a list for storing the frequency
		List<Map.Entry<Integer, Integer>> freqs = new ArrayList<>(counts.entrySet());

		// Using the user-defined function Collections.sort
		// to sort by frequency
		Collections.sort(freqs, (a, b) -> b.getValue() - a.getValue());

		for (int i = 0; i < K; i++)
			System.out.print(freqs.get(i).getKey()+" ");

		System.out.println("print_N_mostFrequentNumber");
	}
}
