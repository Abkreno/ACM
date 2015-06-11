package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FILRTEST_FileRecoverTesting {
	static int m;
	static int z[];
	static char s[];

	static void ZAlgo() {
		int l = 0, r = 0, n = m;
		z[0] = n;
		for (int i = 1; i < n; i++) {
			if (i <= r)
				z[i] = Math.min(r - i + 1, z[i - l]);
			while (i + z[i] < n && s[z[i]] == s[i + z[i]])
				z[i]++;
			if (i + z[i] - 1 > r) {
				l = i;
				r = i + z[i] - 1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] l = bf.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			if (n == -1)
				break;
			s = l[1].toCharArray();
			m = s.length;
			int res = 0;
			z = new int[m];
			ZAlgo();
			for (int i = 1; i < m; i++) {
				if (i + z[i] == m)
					res = Math.max(res, z[i]);
			}
			System.out.println((n - res) / (m - res) < 0 ? 0 : (n - res)
					/ (m - res));
		}
	}
}
