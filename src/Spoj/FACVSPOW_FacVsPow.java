package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FACVSPOW_FacVsPow {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine()), a, lo, hi, mid;
		double curr, log, sums[] = new double[2718275];
		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] + Math.log10(i);
		}

		while (t-- > 0) {
			a = Integer.parseInt(bf.readLine());
			log = Math.log10(a);
			lo = 3;
			hi = 2718274;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				curr = mid * log;
				if (sums[mid] > curr) {
					hi = mid;
				} else {
					lo = mid;
				}
			}
			System.out.println(hi);
		}
	}
}
