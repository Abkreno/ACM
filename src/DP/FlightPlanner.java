package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlightPlanner {
	static int[][] fuel;
	static int len;
	static int INF = 1000000000;
	static int DP[][] = new int[10][1005];

	static int minFuel(int i, int j) {
		if (j == len)
			return i == 9 ? 0 : INF;
		if (DP[i][j] != -1)
			return DP[i][j];
		int min = 30 + (-1 * fuel[i][j]) + minFuel(i, j + 1);
		if (i + 1 < 10)
			min = Math.min(min, 60 + (-1 * fuel[i][j]) + minFuel(i + 1, j + 1));
		if (i - 1 >= 0)
			min = Math.min(min, 20 + (-1 * fuel[i][j]) + minFuel(i - 1, j + 1));
		return DP[i][j] = min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			bf.readLine();
			int X = Integer.parseInt(bf.readLine());
			len = X / 100;
			for (int i = 0; i < DP.length; i++) {
				Arrays.fill(DP[i], -1);
			}
			fuel = new int[10][len];
			String[] l;
			for (int i = 0; i < 10; i++) {
				l = bf.readLine().split(" ");
				for (int j = 0; j < len; j++) {
					fuel[i][j] = Integer.parseInt(l[j]);
				}
			}
			System.out.println(minFuel(9, 0));
		}
	}
}
