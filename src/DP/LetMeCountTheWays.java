package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LetMeCountTheWays {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l;
		long DP[] = new long[30001];
		int w[] = { 1, 5, 10, 25, 50 };
		DP[0] = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = w[i]; j <= 30000; j++) {
				DP[j] += DP[j - w[i]];
			}
		}
		while ((l = bf.readLine()) != null && l.length() > 0) {
			int n = Integer.parseInt(l);
			System.out.println(DP[n] == 1 ? "There is only 1 way to produce "
					+ n + " cents change." : "There are " + DP[n]
					+ " ways to produce " + n + " cents change.");
		}
	}
}
