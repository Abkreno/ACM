package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestRunOnSnowBoard {
	static int xDir[] = new int[] { -1, 1, 0, 0 };
	static int yDir[] = new int[] { 0, 0, -1, 1 };
	static int n, m;
	static int g[][] = new int[105][105];
	static int DP[][] = new int[105][105];

	static boolean inBounds(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}

	static int getMax(int i, int j) {
		int best = 0;
		if (DP[i][j] != -1)
			return DP[i][j];
		for (int k = 0; k < 4; k++) {
			if (inBounds(i + xDir[k], j + yDir[k])
					&& g[i][j] > g[i + xDir[k]][j + yDir[k]]) {
				best = Math.max(best, 1 + getMax(i + xDir[k], j + yDir[k]));
			}
		}
		return DP[i][j] = best;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int max, t = Integer.parseInt(bf.readLine());
		String[] l;
		String word;
		while (t-- > 0) {
			for (int i = 0; i < DP.length; i++) {
				Arrays.fill(DP[i], -1);
			}
			l = bf.readLine().split(" ");
			word = l[0];
			n = Integer.parseInt(l[1]);
			m = Integer.parseInt(l[2]);
			for (int i = 0; i < n; i++) {
				l = bf.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					g[i][j] = Integer.parseInt(l[j]);
				}
			}
			max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					max = Math.max(max, 1 + getMax(i, j));
				}
			}
			System.out.println(word + ": " + max);
		}
	}
}
