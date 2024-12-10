package com.whs.javacode.leetcode;

import java.util.HashSet;

/**
 * Fonte: https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutiveSequence(nums));
	}

	private static int longestConsecutiveSequence(int[] nums) {
		HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < nums.length; ++i)
            S.add(nums[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < nums.length; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(nums[i] - 1)) {
                // Then check for next elements
                // in the sequence
                int j = nums[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - nums[i])
                    ans = j - nums[i];
            }
        }
        return ans;
	}
}
