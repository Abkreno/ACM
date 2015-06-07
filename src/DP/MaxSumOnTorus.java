package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumOnTorus {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			int nums[][] = new int[2 * n][2 * n];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				String[] l = bf.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					int curr = Integer.parseInt(l[j]);
					nums[i][j] = curr;
					nums[i][j + n] = curr;
					nums[i + n][j] = curr;
					nums[i + n][j + n] = curr;
					max = Math.max(max, curr);
				}
			}
			if (max > 0)
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						int sum[] = new int[2 * n];
						for (int k = i; k < n + i; k++) {
							int sumSoFar = 0;
							for (int l = j; l < n + j; l++) {
								sum[l] += nums[k][l];
								sumSoFar += sum[l];
								if (sumSoFar < 0)
									sumSoFar = 0;
								max = Math.max(max, sumSoFar);
							}
						}
					}
				}
			System.out.println(max);
		}
	}
}
