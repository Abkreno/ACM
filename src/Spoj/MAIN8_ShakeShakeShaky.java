package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MAIN8_ShakeShakeShaky {
	static long nums[];
	static long k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[];
		int t, n;
		long lo, hi, mid;
		t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			k = Long.parseLong(l[1]);
			nums = new long[n];
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				nums[i] = Long.parseLong(l[i]);
			}
			lo = 0;
			hi = 100000000000L;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (can(mid)) {
					lo = mid;
				} else {
					hi = mid;
				}
			}
			System.out.println(lo);
		}
	}

	private static boolean can(long mid) {
		long curr = k;
		for (int i = 0; i < nums.length; i++) {
			curr -= (nums[i] / mid);
			if (curr <= 0)
				return true;
		}
		return curr <= 0;
	}
}
