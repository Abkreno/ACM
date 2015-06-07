package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewLawInPheopana {
	static int seive[];
	static long nCk[];

	static void preprocess(int n) {
		boolean checked[] = new boolean[n + 1];
		int c = 0;
		seive = new int[78498];
		for (int i = 2; i <= n; i++) {
			if (!checked[i]) {
				seive[c++] = i;
				for (int j = i; j <= n; j += i) {
					checked[j] = true;
				}
			}
		}
		nCk = new long[n+1];
		nCk[2] = 1;
		nCk[3] = 3;
		nCk[4] = 6;
		for (int i = 5; i <= n; i++) {
			nCk[i] = i * (i - 1) / 2;
		}
	}

	public static void main(String[] args) throws IOException {
		preprocess(1000000);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while (true) {
			int n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			if (n < 3) {
				System.out.println("Case " + c + ": " + 0);
				c++;
				continue;
			}
			int lo = 0;
			int hi = 78497;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (seive[mid] >= n) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}

			long res = 0;
			while (lo > 1) {
				lo--;
				if (seive[lo - 1] + seive[lo] <= n) {
					res += nCk[lo + 1];
					break;
				} else {
					int start = 0;
					int end = lo - 2;
					while (start <= end) {
						int mid = (start + end) / 2;
						if (seive[mid] + seive[lo] <= n) {
							start = mid + 1;
						} else {
							end = mid - 1;
						}
					}
					res += start;
				}
			}
			System.out.println("Case " + c + ": " + res);
			c++;

		}
	}
}
