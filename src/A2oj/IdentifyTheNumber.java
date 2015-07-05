package A2oj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IdentifyTheNumber {
	static int N, R, Q;
	static char[] num;
	static int nINF = -1000000;
	static int[][] DP = new int[1010][1010];
	static StringBuffer st;
	
	static int identify(int i, int rem, boolean s) {
		if (i >= N)
			return rem == R && s ? 0 : nINF;
		if (DP[i][rem] != -1)
			return DP[i][rem];
		int c2 = nINF;
		if ((s || num[i] != '0'))
			c2 = identify(i + 1, (rem * 10 + (num[i] - '0')) % Q, true);
		if (c2 != nINF) {
			c2++;
		}
		int c1 = identify(i + 1, rem, s);
		return DP[i][rem] = Math.max(c1, c2);
	}

	static void print(int i, int rem) {
		if (i >= N)
			return;
		int c1 = identify(i + 1, rem, true);
		int c2 = identify(i + 1, (rem * 10 + (num[i] - '0')) % Q, true);
		if (c1 == DP[i][rem]) {
			print(i + 1, rem);
		} else {
			if (!(st.length() == 0 && num[i] == '0'))
				st.append(num[i]);
			print(i + 1, (rem * 10 + (num[i] - '0')) % Q);
		}
	}

	static void print2(int i, int rem, int len) {
		if (i >= N || len == 0)
			return;
		int bestStart = 0;
		int bestChar = -1;
		for (int j = i; j < N; j++) {
			int c2 = identify(j + 1, (rem * 10 + (num[j] - '0')) % Q, true);
			if (c2 + 1 == DP[i][rem]) {
				if (num[j] > bestChar) {
					bestChar = num[j];
					bestStart = j;
				}
			}
		}
		st.append(num[bestStart]);
		print2(bestStart + 1, (rem * 10 + (num[bestStart] - '0')) % Q, len - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			for (int i = 0; i < DP.length; i++) {
				Arrays.fill(DP[i], -1);
			}
			st = new StringBuffer();
			String l[] = bf.readLine().split(" ");
			num = l[0].toCharArray();
			N = num.length;
			R = Integer.parseInt(l[1]);
			Q = Integer.parseInt(l[2]);
			int ans = identify(0, 0, false);

			if (ans == nINF) {
				boolean zero = false;
				if (R == 0) {
					zero = num.toString().contains("0");
				}
				System.out.println(zero?0:"Not found");
			} else {
				print2(0, 0, ans);
				System.out.println(st.length() > 0 ? st : 0);
			}

		}
	}
}
