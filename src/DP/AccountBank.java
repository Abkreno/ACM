package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AccountBank {
	static int n, f;
	static int[] nums;
	static int posNeg[][];
	static int DP[][] = new int[40 + 5][80000 + 5];
	static int c = 40000;

	static boolean getMax(int curr, int sum) {
		if (curr >= n) {
			return sum == f;
		}
		boolean flag = false;
		if (DP[curr][sum + c] != -1)
			return DP[curr][sum + c] > 0;
		DP[curr][sum + c] = 0;
		if (getMax(curr + 1, sum - nums[curr])) {
			posNeg[curr][0]++;
			flag = true;
			DP[curr][sum + c]++;
		}
		if (getMax(curr + 1, sum + nums[curr])) {
			posNeg[curr][1]++;
			flag = true;
			DP[curr][sum + c]++;
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			f = Integer.parseInt(l[1]);
			if (n == 0 && f == 0)
				break;
			nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(bf.readLine());
			}
			posNeg = new int[n][2];
			for (int i = 0; i < n; i++) {
				Arrays.fill(DP[i], -1);
			}
			getMax(0, 0);
			boolean sol = true;
			for (int i = 0; i < n; i++) {
				if (posNeg[i][0] + posNeg[i][1] == 0) {
					sol = false;
					break;
				}
			}
			if (sol)
				for (int i = 0; i < n; i++) {
					boolean pos = false;
					boolean neg = false;
					if (posNeg[i][0] > 0)
						neg = true;
					if (posNeg[i][1] > 0)
						pos = true;
					if (pos && neg) {
						System.out.print("?");
					} else if (pos) {
						System.out.print("+");
					} else if (neg) {
						System.out.print("-");
					}
				}
			else
				System.out.print("*");
			System.out.println();
		}
	}

}