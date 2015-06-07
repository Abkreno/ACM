package MathAndUsefullAlgorthims;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SummingDiagonals {
	static int n;
	static long arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new long[n][n];
		String[] l;
		for (int i = 0; i < arr.length; i++) {
			l = bf.readLine().split(" ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(l[j]);
			}
		}
		long[][] primaryDigSums = new long[n][n];
		long[][] secondaryDigSums = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				primaryDigSums[i][j] = arr[i][j];
				secondaryDigSums[i][j] = arr[i][(n - 1) - j];
			}
		}
		long maxOdd = -1;
		int x1 = 0;
		int y1 = 0;
		long maxEven = -1;
		int x2 = 0;
		int y2 = 1;

		sumPrimaryDiagonals(primaryDigSums);
		sumPrimaryDiagonals(secondaryDigSums);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = primaryDigSums[i][j]
						+ secondaryDigSums[i][(n - 1) - j] - arr[i][j];
				if ((i + j) % 2 == 0) {
					if (arr[i][j] > maxEven) {
						maxEven = arr[i][j];
						x1 = i + 1;
						y1 = j + 1;
					}
				} else {
					if (arr[i][j] > maxOdd) {
						maxOdd = arr[i][j];
						x2 = i + 1;
						y2 = j + 1;
					}
				}
			}
		}
		System.out.println(maxEven + maxOdd);
		System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
	}

	/**
	 * Sums all the primary diagonals (result in res)
	 * 
	 * @param arr
	 * @param res
	 */
	static void sumPrimaryDiagonals(long[][] res) {
		for (int j = 0; j < n; j++) {
			int y = 1;
			int x = j + 1;
			for (; x < n; x++, y++) {
				res[y][x] += res[y - 1][x - 1];
				if (j != 0)
					res[x][y] += res[x - 1][y - 1];
			}
			long sum = res[y - 1][x - 1];
			long sum2 = res[x - 1][y - 1];
			y = y - 2;
			for (x = x - 2; x >= 0 && y >= 0; x--, y--) {
				res[y][x] = sum;
				if (j != 0)
					res[x][y] = sum2;
			}

		}
	}

}
