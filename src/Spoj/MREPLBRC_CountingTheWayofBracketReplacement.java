package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MREPLBRC_CountingTheWayofBracketReplacement {
	static char[] brackets;
	static int n;
	static long DP[][] = new long[200][200];
	static long MOD = 100000;
	static boolean moduloUsed;

	static long ways(int i, int limit) {
		if (i >= limit)
			return 1;
		if (DP[i][limit] != -1)
			return DP[i][limit];
		long res = 0;
		if (brackets[i] == '?') {
			for (int j = i + 1; j <= limit; j += 2) {
				if (brackets[j] == '?') {
					res += 3 * ways(i + 1, j - 1) * ways(j + 1, limit);
				} else if (brackets[j] == ')' || brackets[j] == '}'
						|| brackets[j] == ']') {
					res += 1 * ways(i + 1, j - 1) * ways(j + 1, limit);
				}
				if (res > MOD) {
					moduloUsed = true;
					res %= MOD;
				}
			}
		} else if (brackets[i] == '(' || brackets[i] == '{'
				|| brackets[i] == '[') {
			for (int j = i + 1; j <= limit; j += 2) {
				if (brackets[j] == '?'
						|| (brackets[i] == '(' && brackets[j] == ')')
						|| (brackets[i] == '{' && brackets[j] == '}')
						|| (brackets[i] == '[' && brackets[j] == ']')) {
					res += 1 * ways(i + 1, j - 1) * ways(j + 1, limit);
					if (res > MOD) {
						moduloUsed = true;
						res %= MOD;
					}
				}
			}

		}
		return DP[i][limit] = res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l;
		while ((l = bf.readLine()) != null && l.length() > 0) {
			n = Integer.parseInt(l.split(" ")[0]);
			brackets = bf.readLine().toCharArray();
			for (int i = 0; i < 200; i++)
				Arrays.fill(DP[i], -1);
			moduloUsed = false;
			long x = ways(0, n - 1);
			if (!moduloUsed)
				System.out.println(x);
			else
				System.out.printf("%05d\n", x);
		}
	}
}
