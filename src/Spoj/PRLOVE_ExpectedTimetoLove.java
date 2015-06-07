package Spoj;

import java.util.Scanner;

public class PRLOVE_ExpectedTimetoLove {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] p, time;
		while (t-- > 0) {
			int n = sc.nextInt();
			time = new int[n][n];
			p = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					p[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					time[i][j] = sc.nextInt();
				}
			}
			double ex = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i; j < n; j++) {
					ex += (p[i][j] * 1.0 / 100.0) * time[i][j];
				}
			}
			System.out.printf("%.6f\n", ex);
		}
	}
}
