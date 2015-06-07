package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JillRidesAgain {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int b = Integer.parseInt(bf.readLine());
		int c = 1;
		while (b-- > 0) {
			int r = Integer.parseInt(bf.readLine());
			int[] nums = new int[r - 1];
			for (int i = 0; i < r - 1; i++) {
				String[] l = bf.readLine().split(" ");
				for (int j = 0; j < l.length; j++) {
					if (l[j].length() > 0) {
						nums[i] = Integer.parseInt(l[j]);
						break;
					}
				}
			}
			int start = 0;
			int end = 0;
			int max = Integer.MIN_VALUE;
			int sumSoFar = 0;
			int currentBeg = 0;
			for (int i = 0; i < nums.length; i++) {
				sumSoFar += nums[i];
				if (sumSoFar > max) {
					max = sumSoFar;
					start = currentBeg;
					end = i;
				}
				if (sumSoFar == max) {
					if (i - currentBeg > end - start) {
						start = currentBeg;
						end = i;
					}
				}
				if (sumSoFar < 0) {
					sumSoFar = 0;
					currentBeg = i + 1;
				}
			}
			if (max < 0)
				System.out.println("Route " + c + " has no nice parts");
			else
				System.out.println("The nicest part of route " + c
						+ " is between stops " + (start + 1) + " and "
						+ (end + 2));
			c++;
		}

	}
}