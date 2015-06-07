package Spoj;

import java.util.Scanner;

public class IITKWPCN_PlayingWithBalls {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int w = sc.nextInt();
			int b = sc.nextInt();
			if (b % 2 == 0) {
				System.out.println(String.format("%.6f", 0.0));
			} else {
				System.out.println(String.format("%.6f", 1.0));
			}
		}
	}
}
