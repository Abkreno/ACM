package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SUMFOUR_ValuesWhosSumIsZero {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[];
		int i, j, nums[][] = new int[4][n],c =0;
		long sums[][] = new long[2][n * n];
		for (i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			for (j = 0; j < 4; j++) {
				nums[j][i] = Integer.parseInt(l[j]);
			}
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				sums[0][c++] = ((long) nums[0][i])
						+ ((long) nums[1][j]);
			}
		}
		c=0;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				sums[1][c++] = ((long) nums[2][i])
						+ ((long) nums[3][j]);
			}
		}
		Arrays.sort(sums[1]);
		int lo, hi, mid, tmp;
		n *= n;
		long ans = 0;
		for (i = 0; i < n; i++) {
			lo = -1;
			hi = n - 1;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (sums[1][mid] + sums[0][i] >= 0) {
					hi = mid;
				} else {
					lo = mid;
				}
			}
			tmp = hi;
			lo = 0;
			hi = n;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (sums[1][mid] + sums[0][i] <= 0) {
					lo = mid;
				} else {
					hi = mid;
				}
			}
			if (sums[1][lo] + sums[0][i] == 0 && sums[1][tmp] + sums[0][i] == 0)
				ans += ((long) lo - tmp + 1);
		}
		System.out.println(ans);
	}
}
