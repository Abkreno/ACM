package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShoppingTrip {
	static int n, m, s, MASK;
	static double INF = 1000000000;
	static double minDist[][];
	static int road[];
	static double cost[];
	static double DP[][] = new double[50 + 2][(1 << 12) + 2];

	static double minCost(int node, int mask) {
		if (mask == MASK)
			return minDist[node][0];
		if (DP[node][mask] != -1)
			return DP[node][mask];
		double cost = getCost(mask) + minDist[node][0];
		for (int i = 0; i < s; i++) {
			if (((1 << i) & mask) == 0) {
				cost = Math.min(
						cost,
						minDist[node][road[i]]
								+ minCost(road[i], mask | (1 << i)));
			}
		}
		return DP[node][mask] = cost;
	}

	private static double getCost(int mask) {
		double res = 0;
		for (int i = 0; i < s; i++) {
			if (((1 << i) & mask) == 0) {
				res += cost[i];
			}
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			for (int i = 0; i < DP.length; i++)
				Arrays.fill(DP[i], -1);
			bf.readLine();
			String[] l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]) + 1;
			m = Integer.parseInt(l[1]);
			minDist = new double[n][n];
			for (int i = 0; i < minDist.length; i++) {
				Arrays.fill(minDist[i], INF);
				minDist[i][i] = 0;
			}
			for (int i = 0; i < m; i++) {
				l = bf.readLine().split(" ");
				int x = Integer.parseInt(l[0]);
				int y = Integer.parseInt(l[1]);
				minDist[x][y] = minDist[y][x] = Math.min(minDist[x][y],
						Double.parseDouble(l[2]));
			}
			s = Integer.parseInt(bf.readLine());
			MASK = (1 << s) - 1;
			road = new int[s];
			cost = new double[s];
			for (int i = 0; i < s; i++) {
				l = bf.readLine().split(" ");
				road[i] = Integer.parseInt(l[0]);
				cost[i] = Double.parseDouble(l[1]);
			}

			// FLOYD WARSHELL
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (minDist[i][j] > minDist[i][k] + minDist[k][j]) {
							minDist[i][j] = minDist[i][k] + minDist[k][j];
						}
					}
				}
			}

			double diff = getCost(0);
			double minCost = minCost(0, 0);
			if (Math.abs(diff-minCost) > 1e-9 && diff-minCost > 0)
                System.out.printf("Daniel can save $%.2f\n", diff-minCost);
            else
                System.out.println("Don't leave the house");
		}
	}
}
