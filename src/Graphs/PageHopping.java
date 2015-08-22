package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PageHopping {
	static int INF = 1000000;

	static long nC2(long n) {
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		long k = 2;
		return n * (n - k + 1) / k;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		int n = 10;
		int a, b, numOfNodes;
		int[][] fw = new int[n][n];
		boolean[] nodes = new boolean[n];
		while (true) {
			l = bf.readLine().split(" ");
			if (Integer.parseInt(l[0] + Integer.parseInt(l[1])) == 0)
				return;
			for (int i = 0; i < fw.length; i++) {
				Arrays.fill(fw[i], INF);
				fw[i][i] = 0;
			}
			Arrays.fill(nodes, false);
			numOfNodes = 0;
			for (int i = 0; i < (l.length - 1) / 2; i++) {
				a = Integer.parseInt(l[i * 2]);
				b = Integer.parseInt(l[i * 2 + 1]);
				fw[a][b] = 1;
				if (!nodes[a]) {
					nodes[a] = true;
					numOfNodes++;
				}
				if (!nodes[b]) {
					nodes[b] = true;
					numOfNodes++;
				}

			}
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						fw[i][j] = Math.min(fw[i][j], fw[i][k] + fw[k][j]);
					}
				}
			}
			double sum = 0;
			double ways = nC2(numOfNodes) * 2;

			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (fw[i][j] != INF)
						sum += fw[i][j];
				}
			}
			System.out.println(String.format("%.3f", sum / ways));
		}

	}
}
