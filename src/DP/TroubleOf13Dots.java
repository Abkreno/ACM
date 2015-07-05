package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TroubleOf13Dots {
	static int money, n;
	static int clothes[][];
	static int[][][] memo = new int[2][105][10005];

	static int getMax(int curr, int m, boolean done) {
		if (curr == n)
			return 0;
		if (money - m < 0)
			return 0;
		if (memo[done ? 1 : 0][curr][money - m] != -1)
			return memo[done ? 1 : 0][curr][money - m];
		if (!done && m + clothes[curr][0] > 2000 && m + 200 <= money) {
			m -= 200;
			done = true;
		}
		int val = getMax(curr + 1, m, done);
		if (money - m >= clothes[curr][0])
			val = Math.max(
					val,
					clothes[curr][1]
							+ getMax(curr + 1, m + clothes[curr][0], done));
		return memo[done ? 1 : 0][curr][money - m] = val;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l;
		while ((l = bf.readLine()) != null && l.length() > 0) {
			for (int i = 0; i < 105; i++) {
				Arrays.fill(memo[0][i], -1);
				Arrays.fill(memo[1][i], -1);
			}
			String line[] = l.split(" ");
			money = Integer.parseInt(line[0]);
			n = Integer.parseInt(line[1]);
			clothes = new int[n][2];
			for (int i = 0; i < n; i++) {
				line = bf.readLine().split(" ");
				clothes[i][0] = Integer.parseInt(line[0]);
				clothes[i][1] = Integer.parseInt(line[1]);
			}
			System.out.println(getMax(0, 0, false));
		}
	}
}
