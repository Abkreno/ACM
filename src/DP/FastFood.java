package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FastFood {
	static int n, m, INF = Integer.MAX_VALUE;
	static int a[] = new int[205], res[] = new int[1005],
			dp[][] = new int[205][35], pre[][] = new int[205][35],
			sum[][] = new int[205][205];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int i, j, t, test = 0;
		while (true) {
			String l[] = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			m = Integer.parseInt(l[1]);
			if (n + m == 0)
				break;
			for (i = 1; i <= n; i++) {
				a[i] = Integer.parseInt(bf.readLine());
			}
			for (i = 1; i <= n; i++)
				sum[i][i] = 0;
			for (i = 1; i <= n; i++) {
				for (j = i + 1; j <= n; j++) {
					sum[i][j] = sum[i][j - 1] + a[j] - a[(i + j) >> 1];
				}
			}
			solve();
			System.out.printf("Chain %d\n", ++test);
			t = n;
			for (i = m; i >= 1; i--) {
				res[i] = t;
				t = pre[t][i];
			}
			res[0] = 0;
			for (i = 1; i <= m; i++) {
				if (res[i - 1] + 1 < res[i])
					System.out
							.printf("Depot %d at restaurant %d serves restaurants %d to %d\n",
									i, (res[i] + res[i - 1] + 1) >> 1,
									res[i - 1] + 1, res[i]);
				else
					System.out.printf(
							"Depot %d at restaurant %d serves restaurant %d\n",
							i, res[i], res[i]);
			}
			System.out.printf("Total distance sum = %d\n\n", dp[n][m]);
		}
	}

	static void solve() {
		int i, j;
		for (int k = 0; k < dp.length; k++) {
			Arrays.fill(dp[k], 0x3f);
		}
		for (i = 1; i <= n; i++)
			dp[i][1] = sum[1][i];
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= m && j <= i; j++) {
				for (int k = 1; k < i; k++) {
					if (dp[i][j] > dp[k][j - 1] + sum[k + 1][i]) {
						dp[i][j] = dp[k][j - 1] + sum[k + 1][i];
						pre[i][j] = k;
					}
				}
			}
		}
	}

}
