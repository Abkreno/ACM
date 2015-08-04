package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NOTATRI_NotATrangle {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n, lo, hi, mid, currSum, nums[];
		String[] l;
		long res;
		while (true) {
			n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			nums = new int[n];
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(l[i]);
			}
			Arrays.sort(nums);
			res = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					currSum = nums[i] + nums[j];
					lo = 0;
					hi = n;
					while (lo + 1 < hi) {
						mid = (lo + hi) >> 1;
						if (nums[mid] > currSum) {
							hi = mid;
						} else {
							lo = mid;
						}
					}
					res += n - hi;
				}
			}
			System.out.println(res);
		}
	}
}
