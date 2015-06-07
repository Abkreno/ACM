package Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class StringHashingCodeForce514C {
	static long p[] = new long[600001];
	static long mod = (long) (1e16 + 7);

	static long Hash(char[] s) {
		long ans = 0;
		for (int i = 0; i < s.length; i++) {
			ans += ((s[i] - 'a' + 1) * p[i]) % mod;

		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		p[0] = 1;
		for (int i = 1; i < p.length; i++) {
			p[i] = (p[i - 1] * 4) % mod;
		}
		HashSet<Long> hashVals = new HashSet<Long>();

		for (int i = 0; i < n; i++) {
			long val = Hash(bf.readLine().toCharArray());
			hashVals.add(val);
		}
		for (int i = 0; i < m; i++) {
			char[] curr = bf.readLine().toCharArray();
			long val = Hash(curr);
			boolean found = false;
			loop: for (int j = 0; j < curr.length; j++) {
				long tempVal = val - (((curr[j] - 'a' + 1) * p[j]) % mod);
				for (int k = 0; k < 3; k++) {
					if (curr[j] - 'a' != k) {
						if (hashVals.contains(tempVal + ((k + 1) * p[j]) % mod)) {
							found = true;
							break loop;
						}
					}
				}
			}
			System.out.println(found ? "YES" : "NO");
		}
	}
}
