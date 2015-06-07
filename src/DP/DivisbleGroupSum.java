package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DivisbleGroupSum {
	static int n, m;
	static long d;
	static long[] nums;
	static long[][][] DP;

	static long mod(long a, long b) {
		return (a < 0) ? (b - (Math.abs(a) % b)) % b : (a % b);

	}

	static long count(int curr, int len, long sumSoFar) {
		if (len == m) {
			return sumSoFar % d == 0 ? 1 : 0;
		}
		if (curr == n)
			return 0;
		if (DP[curr][len][(int) sumSoFar] != -1)
			return DP[curr][len][(int) sumSoFar];
		return DP[curr][len][(int) sumSoFar] = count(curr + 1, len, sumSoFar)
				+ count(curr + 1, len + 1, mod((sumSoFar + nums[curr]), d));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while (true) {
			String l[] = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			int q = Integer.parseInt(l[1]);
			if (n + q == 0)
				break;
			nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(bf.readLine());
			}
			DP = new long[n][20][25];
			System.out.println("SET " + c + ":");
			c++;
			for (int i = 0; i < q; i++) {
				l = bf.readLine().split(" ");
				d = Integer.parseInt(l[0]);
				m = Integer.parseInt(l[1]);
				for (int x = 0; x < n; x++)
					for (int y = 0; y < DP[x].length; y++)
						Arrays.fill(DP[x][y], -1);

				System.out.println("QUERY " + (i + 1) + ": " + count(0, 0, 0));
			}
		}
	}
}
