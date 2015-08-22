package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LABYR1_Labyrinth {
	static boolean visited[][] = new boolean[1001][1001];
	static char[][] grid = new char[1001][];
	static int n, m;
	static int[] nI = new int[] { -1, 1, 0, 0 };
	static int[] nJ = new int[] { 0, 0, -1, 1 };

	static boolean inBounds(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		StringBuffer sb = new StringBuffer();
		int max;
		while (t-- > 0) {
			l = bf.readLine().split(" ");
			n = Integer.parseInt(l[1]);
			m = Integer.parseInt(l[0]);
			for (int i = 0; i < n; i++) {
				grid[i] = bf.readLine().toCharArray();
				Arrays.fill(visited[i], false);
			}
			max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (grid[i][j] == '.' && !visited[i][j])
						max = Math.max(max, dfs(i, j));
				}
			}
			sb.append("Maximum rope length is " + max + ".\n");
		}
		System.out.print(sb);

	}

	private static int dfs(int i, int j) {
		visited[i][j] = true;
		int ni, nj;
		int max = 0;
		for (int k = 0; k < 4; k++) {
			ni = i + nI[k];
			nj = j + nJ[k];
			if (inBounds(ni, nj) && grid[ni][nj] == '.' && !visited[ni][nj]) {
				max = Math.max(max, 1 + dfs(ni, nj));
			}
		}
		return max;
	}
}
