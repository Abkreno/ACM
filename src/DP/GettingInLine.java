package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GettingInLine {
	static int n;
	static int computers[][];
	static int bestPath[];
	static double min;

	static void min(int mask, int prev, double sum, int step, int[] currPath) {
		if (mask == (1 << n) - 1) {
			if (sum < min) {
				min = sum;
				bestPath = currPath.clone();
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (((1 << i) & mask) == 0) {
				currPath[step] = i;
				min(((1 << i) | mask), i, calcDist(i, prev) + sum, step + 1,
						currPath.clone());
			}
		}
	}

	private static double calcDist(int i, int prev) {
		double a = computers[0][i] - computers[0][prev];
		double b = computers[1][i] - computers[1][prev];
		return 16.0 + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while (true) {
			n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			System.out
					.println("**********************************************************");
			System.out.println("Network #" + c);
			c++;
			computers = new int[2][n];
			for (int i = 0; i < n; i++) {
				String[] l = bf.readLine().split(" ");
				computers[0][i] = Integer.parseInt(l[0]);
				computers[1][i] = Integer.parseInt(l[1]);
			}
			min = Integer.MAX_VALUE;
			bestPath = new int[n];
			int[] path = new int[n];

			for (int i = 0; i < n; i++) {
				path[0] = i;
				min(1 << i, i, 0, 1, path.clone());
			}
			String totalDis = String.format("%.2f", min);
			for (int i = 0; i < n - 1; i++) {
				int curr = bestPath[i];
				int next = bestPath[i + 1];
				double dist = calcDist(curr, next);
				System.out
						.printf("Cable requirement to connect (%d,%d) to (%d,%d) is %.2f feet.\n",
								computers[0][curr], computers[1][curr],
								computers[0][next], computers[1][next], dist);
			}
			System.out.println("Number of feet of cable required is "
					+ totalDis + ".");
		}
	}
}
