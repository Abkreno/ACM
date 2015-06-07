package DP;

import java.util.Arrays;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			for (int i = 0; i < 105; i++) {
				Arrays.fill(memo[0][i], -1);
				Arrays.fill(memo[1][i], -1);
			}
			money = sc.nextInt();
			n = sc.nextInt();
			clothes = new int[n][2];
			for (int i = 0; i < n; i++) {
				clothes[i][0] = sc.nextInt();
				clothes[i][1] = sc.nextInt();
			}
			System.out.println(getMax(0, 0, false));
		}
		sc.close();
	}
}
