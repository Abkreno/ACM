package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class GatheringFood {
	static int n, curr, INF = 20000000, SP;
	static char[][] grid = new char[10][];
	static int dirI[] = new int[] { 0, 1, 0, -1 };
	static int dirJ[] = new int[] { 1, 0, -1, 0 };
	static String direction[] = new String[] { "DOWN", "UP", "RIGHT", "LEFT" };
	static int MOD = 20437;
	static int dist[][] = new int[10][10];
	static int ways[][] = new int[10][10];
	static int totalSP;
	static long total;
	static Point ini;

	static boolean inB(int i, int j) {
		return i >= 0 && j >= 0 && j < n && i < n;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void getSP() {

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int max,i, j, cnt = 1;
		while (true) {
			n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			max = 0;
			for (i = 0; i < n; i++) {
				grid[i] = bf.readLine().toCharArray();
				for (j = 0; j < n; j++) {
					if (grid[i][j] >= 'A' && grid[i][j] <= 'Z') {
						if (grid[i][j] == 'A')
							ini = new Point(i, j);
						max++;
					}
				}
			}
			totalSP = 0;
			total = 1;
			int nx, ny, nc, x, y;
			for (curr = 1; curr < max; curr++) {
				for (int k = 0; k < 10; k++) {
					Arrays.fill(dist[k], INF);
					Arrays.fill(ways[k], 0);
				}
				dist[ini.x][ini.y] = 0;
				ways[ini.x][ini.y] = 1;
				LinkedList<Point> q = new LinkedList<>();
				q.add(ini);
				grid[ini.x][ini.y] = '.';
				while (!q.isEmpty()) {
					x = q.peek().x;
					y = q.peek().y;
					if (grid[x][y] - 'A' == curr) {
						totalSP += dist[x][y];
						total *= (long) ways[x][y] % MOD;
						total = total % MOD;
						ini = new Point(x, y);
						break;
					}
					q.pop();
					for (int k = 0; k < 4; k++) {
						nx = x + dirI[k];
						ny = y + dirJ[k];
						nc = 1 + dist[x][y];
						if (nx < 0
								|| nx >= n
								|| ny < 0
								|| ny >= n
								|| (grid[nx][ny] != '.' && grid[nx][ny] != 'A' + curr)
								|| nc > dist[nx][ny])
							continue;
						ways[nx][ny] += ways[x][y];
						ways[nx][ny] %= MOD;
						if (nc < dist[nx][ny]) {
							dist[nx][ny] = dist[x][y] + 1;
							q.addLast(new Point(nx, ny));
						}
					}
				}
				if (q.isEmpty()) {
					totalSP = INF;
					break;
				}
			}
			total = total % MOD;
			System.out.printf("Case %d: ", cnt++);
			if (totalSP >= INF)
				System.out.println("Impossible");
			else {
				System.out.println(totalSP + " " + total);
			}
		}
	}
}
