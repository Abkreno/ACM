package Spoj;

import java.util.Scanner;

public class GNYR09F_AdjBitCounts {
	static int c, n, k;

	static int rec(int consc, int s, int ones) {
		if (s == n)
			return consc == k ? 1 : 0;
		if (consc == k) {
			if (ones > 0)
				return rec(consc, s + 1, 0);
			return rec(consc, s + 1, 1) + rec(consc, s + 1, 0);
		} else {
			return rec(consc + (ones > 0 ? 1 : 0), s + 1, ones + 1)
					+ rec(consc, s + 1, 0);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			c = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			System.out.println(c + " " + (rec(0, 0, 0)));
		}
	}
}
