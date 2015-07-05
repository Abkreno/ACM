package A2oj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, R, Q;
	static char[] num;
	static int nINF = -1000000;
	static digit[][][] DP = new digit[2][1010][1010];

	static class digit {
		int s;
		int d;

		digit(int x, int c) {
			s = x;
			d = c;
		}

		public String toString() {
			return s + " " + d;
		}

		public boolean equals(digit e) {
			return e.d == d && e.s == s;
		}
	}

	static digit identify(boolean s, int i, int rem) {
		if (i >= N)
			return rem == R ? new digit(0, 0) : new digit(nINF, 0);
		if (DP[s ? 1 : 0][i][rem] != null)
			return DP[s ? 1 : 0][i][rem];
		digit c1 = identify(s, i + 1, rem);
		c1 = new digit(c1.s, c1.d);
		digit c2 = new digit(nINF, '0');
		if (s || num[i] != '0') {
			c2 = identify(true, i + 1, (rem * 10 + (num[i] - '0')) % Q);
			c2 = new digit(c2.s, c2.d);
		}
		if (c2.d != '0') {
			c2.s++;
			c2.d = num[i];
		}
		return DP[s ? 1 : 0][i][rem] = comp(c1, c2);
	}

	private static digit comp(digit c1, digit c2) {
		if (c1.s > c2.s || (c1.s == c2.s && c1.d > c2.d))
			return c1;
		return c2;
	}

	static void print(boolean s, int i, int rem) {
		if (i >= N)
			return;
		digit c1 = identify(s, i + 1, rem);
		digit c2 = new digit(nINF, 0);
		if (s || num[i] != '0') {
			c2 = identify(true, i + 1, (rem * 10 + (num[i] - '0')) % Q);
			c2 = new digit(c2.s, c2.d);
		}
		if (c2.d != ':') {
			c2.s++;
			c2.d = num[i];
		}
		if (c1.s > c2.s || (c1.s == c2.s && c1.d > c2.d)) {
			print(s, i + 1, rem);
			return;
		}
		st.append(num[i]);
		print(true, i + 1, (rem * 10 + (num[i] - '0')) % Q);
	}

	static StringBuffer st;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			st = new StringBuffer();
			String l[] = bf.readLine().split(" ");
			num = l[0].toCharArray();
			N = num.length;
			R = Integer.parseInt(l[1]);
			Q = Integer.parseInt(l[2]);
			digit ans = identify(false, 0, 0);
			if (ans.s > 0) {
				print(false, 0, 0);
				System.out.println(st);
			} else {
				System.out.println("Not found");
			}
			for (int i = 0; i < 1010; i++) {
				Arrays.fill(DP[0][i], null);
				Arrays.fill(DP[1][i], null);
			}
		}
	}
}