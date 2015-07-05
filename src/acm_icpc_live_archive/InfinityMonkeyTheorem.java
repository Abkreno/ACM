package acm_icpc_live_archive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InfinityMonkeyTheorem {
	static double pCurr[];
	static double propE;
	static int m, N;
	static double dp[] = new double[1000 + 5];

	static double prob(int curr) {
		if (curr >= m - N)
			return 1;
		if (dp[curr] != -1)
			return dp[curr];
		double res = 0;
		for (int i = 0; i < pCurr.length; i++) {
			res += pCurr[i] * prob(curr + 1);
		}
		return dp[curr] = res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			Arrays.fill(dp, -1);
			String[] l = bf.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			m = Integer.parseInt(l[1]);
			if (n + m == 0)
				break;
			double p[] = new double[26];
			pCurr = new double[n];
			for (int i = 0; i < n; i++) {
				l = bf.readLine().split(" ");
				int pos = l[0].charAt(0) - 'a';
				p[pos] = Double.parseDouble(l[1]);
				pCurr[i] = p[pos];
			}
			char[] word = bf.readLine().split(" ")[0].toCharArray();
			N = word.length;
			propE = 1.0;
			for (int i = 0; i < word.length; i++) {
				propE *= p[word[i] - 'a'];
			}
			System.out.println(100 * prob(0) * propE * (m - N + 1));
		}
	}
}
