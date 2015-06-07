package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MurciasSkyline {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int c = 1;
		PrintWriter out = new PrintWriter(System.out);
		while (t-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			int heights[] = new int[n];
			int weights[] = new int[n];
			String[] l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(l[i]);
			}
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(l[i]);
			}
			// LIS
			int lisW = 0;
			int lis_W[] = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				lis_W[i] = weights[i];
				for (int j = i + 1; j < n; j++) {
					if (heights[i] < heights[j]) {
						if (weights[i] + lis_W[j] > lis_W[i]) {
							lis_W[i] = weights[i] + lis_W[j];
						}
					}
				}
				if (lis_W[i] > lisW) {
					lisW = lis_W[i];
				}
			}
			int ldsW = 0;
			int lds_W[] = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				lds_W[i] = weights[i];
				for (int j = i + 1; j < n; j++) {
					if (heights[i] > heights[j]) {
						if (lds_W[j] + weights[i] > lds_W[i]) {
							lds_W[i] = weights[i] + lds_W[j];
						}
					}
				}
				if (lds_W[i] > ldsW) {
					ldsW = lds_W[i];
				}
			}
			if (lisW >= ldsW) {
				out.printf("Case %d. Increasing (%d). Decreasing (%d).", c++,
						lisW, ldsW);
			} else {
				out.printf("Case %d. Decreasing (%d). Increasing (%d).", c++,
						ldsW, lisW);
			}
			out.println();
		}
		out.close();
	}
}
