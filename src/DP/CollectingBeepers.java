package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CollectingBeepers {
	static int n, m, xS, yS, s, mask;
	static int[] x, y;

	static int minCost(int i, int j, int m) {
		if (m == mask)
			return Math.abs(i - xS) + Math.abs(j - yS);
		int ret = Integer.MAX_VALUE;
		for (int k = 0; k < s; k++) {
			if (((1 << k) & m) == 0) {
				ret = Math.min(ret, Math.abs(i - x[k]) + Math.abs(j - y[k])
						+ minCost(x[k], y[k], m | (1 << k)));
			}
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			String[] l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			m = Integer.parseInt(l[1]);
			x = new int[n];
			y = new int[m];
			l = bf.readLine().split(" ");
			xS = Integer.parseInt(l[0]);
			yS = Integer.parseInt(l[1]);
			s = Integer.parseInt(bf.readLine());
			mask = (1 << s) - 1;
			for (int i = 0; i < s; i++) {
				l = bf.readLine().split(" ");
				x[i] = Integer.parseInt(l[0]);
				y[i] = Integer.parseInt(l[1]);
			}
			System.out.println("The shortest path has length "
					+ minCost(xS, yS, 0));
		}
	}
}
