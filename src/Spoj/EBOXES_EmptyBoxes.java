package Spoj;

import java.util.Scanner;

public class EBOXES_EmptyBoxes {
	public static void main(String[] args) {
		long f, n, t, k, level, currN, boxes;
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		while (c-- > 0) {
			n = sc.nextLong();
			k = sc.nextLong();
			t = sc.nextLong();
			f = sc.nextLong();

			level = 0;
			boxes = n;
			currN = 0;
			while (level++ < t) {
				currN = n;
				for (int i = 0; i < currN && n < f; i++) {
					n += k - 1;
					boxes += k;
				}
			}
			for (int i = 0; i < currN && n < f; i++) {
				n += k - 1;
				boxes += k;
			}
			System.out.println(boxes);
		}
	}
}
