package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DynamicFrog {
	static int[] rocks;
	static boolean[] big;
	static int len, n;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int c = 1;
		while (t-- > 0) {
			String[] l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]) + 2;
			len = Integer.parseInt(l[1]);
			rocks = new int[n];
			rocks[n - 1] = len;
			big = new boolean[n];
			big[0] = true;
			big[n - 1] = true;
			l = bf.readLine().split(" ");
			for (int i = 0; i < l.length; i++) {
				rocks[i + 1] = Integer.parseInt(l[i].substring(2));
				if (l[i].charAt(0) == 'B')
					big[i + 1] = true;
			}
			int maxHop = Integer.MIN_VALUE;
			for (int start = 0; start < n; start++) {
				if (big[start]) {
					int currMax = Integer.MIN_VALUE;
					for (int i = start + 1; i < n; i++) {
						if (big[i]) {
							currMax = f2(start, i);
							break;
						}
					}
					if (currMax > maxHop) {
						maxHop = currMax;
					}
				}
			}
			System.out.println("Case " + (c++) + ": " + maxHop);
		}
	}

	private static int f2(int i, int j) {
		int max = Math.max(rocks[i + 1] - rocks[i], rocks[j] - rocks[j - 1]);
		for (int k = i; k <= j - 2; k++) {
			max = Math.max(max, rocks[k + 2] - rocks[k]);
		}
		return max;
	}

}
