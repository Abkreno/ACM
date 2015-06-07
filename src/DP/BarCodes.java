package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BarCodes {
	static int N, K, M;
	static long DP[][][] = new long[51][51][51];

	static long count(int i, int k, int m) {
		if (k > K || m > M)
			return 0;
		if (i == N)
			return k == K ? 1 : 0;
		if (DP[i][k][m] != -1)
			return DP[i][k][m];
		return DP[i][k][m] = count(i + 1, k, m + 1) + count(i + 1, k + 1, 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = bf.readLine()) != null && line.length() > 0) {
			String l[] = line.split(" ");
			N = Integer.parseInt(l[0]);
			K = Integer.parseInt(l[1]);
			M = Integer.parseInt(l[2]);
			if (N == K && K == M && K == 0)
				break;
			for (int i = 0; i < DP.length; i++) {
				for (int j = 0; j < DP[i].length; j++) {
					Arrays.fill(DP[i][j], -1);
				}
			}
			System.out.println(count(1, 1, 1));
		}
	}
}
