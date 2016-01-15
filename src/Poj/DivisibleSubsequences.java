package Poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DivisibleSubsequences {
	static int vec[] = new int[50001];
	static int p, n;

	static long get_count(int k) {
		// Initialize count array.
		int[] cnt_mod = new int[k];
		cnt_mod[0] = 1;
		int pref_sum = 0;
		// Iterate over the input sequence.
		int elem;
		for (int i = 0; i < n; i++) {
			elem = vec[i];
			pref_sum += elem;
			pref_sum %= k;
			cnt_mod[pref_sum]++;
		}
		// Compute the answer.
		long res = 0;
		for (int mod = 0; mod < k; mod++)
			res += (long) cnt_mod[mod] * (cnt_mod[mod] - 1) / 2;
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		StringBuffer sb = new StringBuffer();
		while (t-- > 0) {
			l = bf.readLine().split(" ");
			p = Integer.parseInt(l[0]);
			n = Integer.parseInt(l[1]);
			l = bf.readLine().split(" ");
			for (int i = 0; i < l.length; i++) {
				vec[i] = Integer.parseInt(l[i]);
			}
			sb.append(get_count(p) + "\n");
		}
		System.out.print(sb);
	}
}
