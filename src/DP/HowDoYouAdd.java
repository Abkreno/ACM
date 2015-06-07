package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HowDoYouAdd {
	static int N, K;
	static int MOD = 1000000;
	static int DP[][] = new int[105][105];

	static int count(int i, int sumSoFar) {
		if (sumSoFar > N)
			return 0;
		if (i == K)
			return sumSoFar == N ? 1 : 0;
		if (DP[i][sumSoFar] != -1)
			return DP[i][sumSoFar];
		int res = 0;
		for (int x = 0; x <= N; x++) {
			res += count(i + 1, sumSoFar + x);
			res %= MOD;
		}
		return DP[i][sumSoFar] = res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		while (true) {
			l = bf.readLine().split(" ");
			N = Integer.parseInt(l[0]);
			K = Integer.parseInt(l[1]);
			if (N + K == 0)
				break;
			for (int i = 0; i < DP.length; i++) {
				Arrays.fill(DP[i], -1);
			}
			System.out.println(count(0, 0));
		}
	}
}
