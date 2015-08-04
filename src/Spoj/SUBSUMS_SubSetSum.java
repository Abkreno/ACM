package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SUBSUMS_SubSetSum {
	static int MASK;
	static boolean visited[] = new boolean[(1 << 17) + 10];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		long a = Long.parseLong(l[1]);
		long b = Long.parseLong(l[2]);
		long ans = 0;

		int n1 = n / 2;
		int n2 = n - n1;
		long nums1[] = new long[n1];
		for (int i = 0; i < n1; i++) {
			nums1[i] = Long.parseLong(bf.readLine());
		}
		long nums2[] = new long[n2];
		for (int i = 0; i < n2; i++) {
			nums2[i] = Long.parseLong(bf.readLine());
		}
		long sums1[] = new long[1 << n1];
		long sums2[] = new long[1 << n2];
		MASK = (1 << n1) - 1;
		fill(0, n1, nums1, 0, sums1);
		Arrays.fill(visited, false);
		MASK = (1 << n2) - 1;
		fill(0, n2, nums2, 0, sums2);
		Arrays.sort(sums2);
		int lo, hi, mid, tmp;
		for (int i = 0; i < sums1.length; i++) {
			lo = -1;
			hi = sums2.length - 1;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (sums2[mid] + sums1[i] >= a) {
					hi = mid;
				} else {
					lo = mid;
				}
			}
			tmp = hi;
			lo = 0;
			hi = sums2.length;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (sums2[mid] + sums1[i] <= b) {
					lo = mid;
				} else {
					hi = mid;
				}
			}

			if (sums2[lo] + sums1[i] <= b && sums2[tmp] + sums1[i] >= a)
				ans += ((long) (lo - tmp + 1));
		}
		System.out.println(ans);
	}

	static void fill(int i, int n, long[] nums, long sum, long[] sums) {
		if (i == MASK || visited[i])
			return;
		visited[i] = true;
		for (int j = 0; j < n; j++) {
			if (((1 << j) & i) == 0) {
				sums[(1 << j) | i] = sum + nums[j];
				fill((1 << j) | i, n, nums, sum + nums[j], sums);
			}
		}

	}
}
