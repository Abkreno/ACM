package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Trainsorting {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			int nums[] = new int[n];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(bf.readLine());
			}
			int lis[] = new int[n];
			int lds[] = new int[n];
			int ans = 0;
			for (int i = n - 1; i >= 0; i--) {
				lis[i] = 1;
				lds[i] = 1;
				for (int j = i + 1; j < n; j++) {
					if (nums[j] > nums[i])
						lis[i] = Math.max(lis[i], 1 + lis[j]);
					if (nums[j] < nums[i])
						lds[i] = Math.max(lds[i], 1 + lds[j]);

				}
				ans = Math.max(lis[i] + lds[i] - 1, ans);
			}
			System.out.println(ans);
		}

	}
}
