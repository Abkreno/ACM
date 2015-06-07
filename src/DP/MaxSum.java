package DP;

import java.util.Scanner;

public class MaxSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[][] = new int[n][n];
		int max = -1000;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j] = sc.nextInt();
				max = Math.max(max, nums[i][j]);
			}
		}
		if (max > 0)
			for (int i = 0; i < n; i++) {
				int sum[] = new int[n];
				for (int j = i; j < n; j++) {
					int sumSoFar = 0;
					for (int k = 0; k < n; k++) {
						sum[k] += nums[j][k];
						sumSoFar += sum[k];
						if (sumSoFar < 0)
							sumSoFar = 0;
						max = Math.max(max, sumSoFar);
					}
				}
			}
		System.out.println(max);
		sc.close();
	}
}
