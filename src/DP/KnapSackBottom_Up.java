package DP;

import java.util.Scanner;

public class KnapSackBottom_Up {
	static int i, w, T, N, G, MW, ans, MAX_N = 1010, MAX_W = 40;
	static int[] V = new int[MAX_N];
	static int[] W = new int[MAX_N];
	static int[][] C = new int[MAX_N][MAX_W];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();
			for (i = 1; i <= N; i++) {
				V[i] = sc.nextInt();
				W[i] = sc.nextInt();
			}
			ans = 0;
			G = sc.nextInt();
			while (G-- > 0) {
				MW = sc.nextInt();
				for (i = 0; i <= N; i++)
					C[i][0] = 0;
				for (w = 0; w <= MW; w++)
					C[0][w] = 0;

				for (i = 1; i <= N; i++)
					for (w = 1; w <= MW; w++) {
						if (W[i] > w)
							C[i][w] = C[i - 1][w];
						else
							C[i][w] = Math.max(C[i - 1][w], V[i]
									+ C[i - 1][w - W[i]]);
					}
				ans += C[N][MW];
			}
			System.out.printf("%d\n", ans);
		}
		sc.close();
	}
}
