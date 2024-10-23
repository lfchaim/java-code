package com.whs.javacode.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Prison_excape {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int present = s.nextInt() - 1;
		int to_num = s.nextInt();
		int to[] = new int[to_num];
		for (int i = 0; i < to_num; i++) {
			to[i] = s.nextInt() - 1;
		}
		int m = s.nextInt();
		int[][] data = new int[m][3];
	
		for (int i = 0; i < m; i++) {
			data[i][0] = s.nextInt() - 1;
			data[i][1] = s.nextInt() - 1;
			data[i][2] = 1;
		}

		int first_present = present;

		int[] ans = new int[n];
		int[] visit = new int[n];

		for (int i = 0; i < n; i++) {
			ans[i] = 100000;
		}
		
		visit[present] = 1; //// 1 visited
		ans[present] = 0;
		int total_visited = 0;
		// int present =1;
		int check = 0;
		while (check == 0) {

			for (int i = 0; i < m; i++) {
				if (data[i][0] == present) {
					ans[data[i][1]] = Math.min(ans[data[i][1]], ans[present] + data[i][2]);
					// System.out.println("1" );
				}
				if (data[i][1] == present) {
					ans[data[i][0]] = Math.min(ans[data[i][0]], ans[present] + data[i][2]);
					// System.out.println("2");
				}

			}
			int min = 1000000;
			int previous_present = present;
			for (int i = 0; i < n; i++) {
				if (visit[i] == 0) {
					if (ans[i] <= min) {
						present = i;
						min = ans[i];
					}
				}

			}
			visit[present] = 1;

			if (previous_present == present)
				check = 1;

			total_visited++;

			// System.out.println(" ");
		}
		int final_ans = -1;
		for (int i = 0; i < to_num; i++) {
			// if(i!=first_present)
			// {
			if (ans[to[i]] == 100000) {
				final_ans = -1;
				break;
			} else {
				if (ans[i] > final_ans) {
					final_ans = ans[i];
				}
			}
			// }
		}

		System.out.println(final_ans);

	}

}