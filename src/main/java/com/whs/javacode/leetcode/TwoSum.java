package com.whs.javacode.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Fonte: https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {11, 7, 15, 2};
		//nums = new int[] {2,7,11,15};
		int target = 9;
		int[] ret = twoSumBestIndex(nums, target);
		if( ret != null && ret.length == 2 ) {
			System.out.println("Best Index: "+ret[0]+"::"+ret[1] );	
		}
		ret = twoSumBest(nums, target);
		if( ret != null && ret.length == 2 ) {
			System.out.println("Best Value: "+ret[0]+"::"+ret[1] );	
		}
		ret = twoSumBruteForce(nums, target);
		if( ret != null && ret.length == 2 ) {
			System.out.println("Brute Force: "+ret[0]+"::"+ret[1] );	
		}
		ret = twoSumSort(nums, target);
		if( ret != null && ret.length == 2 ) {
			System.out.println("Sorted: "+ret[0]+"::"+ret[1] );	
		}
	}
	
	private static int[] twoSumSort ( int[] nums, int target ) {
		Arrays.sort(nums);
		int ini = 0;
		int end = nums.length - 1;
		while( ini <= end ) {
			if( (nums[ini] + nums[end]) > target ) {
				end--;
			} else if( (nums[ini] + nums[end]) < target ) {
				ini++;
			} else {
				return new int[] {nums[ini],nums[end]};
			}
		}
		return new int[]{};
	}

	private static int[] twoSumBest ( int[] nums, int target ) {
		Map<Integer, Integer> map = new HashMap();
		for( int i = 0; i < nums.length; i++ ) {
			if( map.containsKey(target - nums[i]) ) {
				return new int[] {target - nums[i],nums[i]};
			}
			//map.put(nums[i],i);
			map.put(target - nums[i],i);
		}
		return new int[]{};
	}
	
	private static int[] twoSumBruteForce ( int[] nums, int target ) {
		for( int i = 0; i < nums.length; i++ ) {
			for( int j = i+1; j < nums.length; j++ ) {
				if( nums[i] + nums[j] == target ) {
					return new int[] {nums[i],nums[j]};
				}
			}
		}
		return new int[]{};
	}

	private static int[] twoSumBestIndex(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
	
}
