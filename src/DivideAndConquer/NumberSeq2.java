package DivideAndConquer;

import java.util.Scanner;

public class NumberSeq2 {
	public static void main(String[] args) {
		long[] len = new long[40001];
		long count = 0;
		long last = 0;
		StringBuilder b = new StringBuilder();
		for (int i = 1; i < 40000; i++) {
			last = (i + "").length();
			count += last;
			len[i] = count + len[i - 1];
			b.append(i);
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int j = 0; j < n; j++) {
			int pos = in.nextInt();
			int lo = 1, hi = 40000;
			for (int i = 0; i < 20; i++) {
				int mid = (lo + hi) / 2;
				if (len[mid] == pos) {
					lo = mid;
					break;
				} else if (len[mid] < pos) {
					lo = mid;
				} else
					hi = mid;
			}
			if (pos > len[lo])
				System.out.println(b.charAt((int) (pos - len[lo]) - 1));
			else
				System.out.println(lo);
		}
		in.close();
	}
}
