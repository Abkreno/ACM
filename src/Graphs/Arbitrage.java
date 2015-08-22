package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Arbitrage {
	static double[][][] grid = new double[25][25][25];
	static int[][][] parent = new int[25][25][25];;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String curr, l[];
		int n, c, i, j, k, steps, p;
		double tmp;
		StringBuilder ans;
		while ((curr = bf.readLine()) != null && curr.length() > 0) {
			n = Integer.parseInt(curr);
			for (i = 0; i < n; i++)
				for (j = 0; j < n; j++)
					for (steps = 0; steps < n; steps++) {
						grid[i][j][steps] = 0.0;
					}
			for (i = 0; i < n; i++) {
				l = bf.readLine().split(" ");
				c = 0;
				for (j = 0; j < n; j++) {
					if (j == i)
						grid[i][j][0] = 1.0;
					else
						grid[i][j][0] = Double.parseDouble(l[c++]);

					parent[i][j][0] = i;
				}
			}

			for (k = 0; k < n; k++) {
				for (i = 0; i < n; i++) {
					for (j = 0; j < n; j++) {
						for (steps = 1; steps < n; steps++) {
							tmp = grid[i][k][steps - 1] * grid[k][j][0];
							if (tmp > grid[i][j][steps]) {
								grid[i][j][steps] = tmp;
								parent[i][j][steps] = k;
							}
						}
					}
				}
			}
			LinkedList<Integer> way = new LinkedList<>();
			for (i = 0; i < n; i++) {
				for (steps = 1; steps < n; steps++) {
					if (grid[i][i][steps] > 1.01) {
						p = i;
						way.addLast(i + 1);
						for (k = steps; k >= 0; k--) {
							way.addLast(parent[i][p][k] + 1);
							p = parent[i][p][k];
						}
						ans = new StringBuilder();
						ans.append(p + 1);
						way.removeLast();
						while (!way.isEmpty())
							ans.append(" " + way.removeLast());
						System.out.println(ans);
						return;
					}
				}

			}
			System.out.println("no arbitrage sequence exists");

		}
	}
}
