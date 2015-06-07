package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExcatChange {
	static int m, s, ans;
	static int nums[] = new int[100];
	static int INF = 1000000000;
	static int DP[][] = new int[100][10000];

	static int getMin(int i, int sum) {
		if (sum >= s)
			return sum;
		if (i >= m)
			return INF;
		if (DP[i][sum] != -1)
			return DP[i][sum];
		return DP[i][sum] = Math.min(getMin(i + 1, sum),
				getMin(i + 1, sum + nums[i]));
	}

	static int getMinC(int i, int sum) {
		if (sum == ans)
			return 0;
		if (i >= m || sum > ans)
			return INF;
		if (DP[i][sum] != -1)
			return DP[i][sum];
		return DP[i][sum] = Math.min(getMinC(i + 1, sum),
				1 + getMinC(i + 1, sum + nums[i]));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			s = Integer.parseInt(bf.readLine());
			m = Integer.parseInt(bf.readLine());
			nums = new int[m];
			for (int i = 0; i < m; i++) {
				nums[i] = Integer.parseInt(bf.readLine());
			}
			for (int i = 0; i < 100; i++)
				Arrays.fill(DP[i], -1);
			ans = getMin(0, 0);
			for (int i = 0; i < 100; i++)
				Arrays.fill(DP[i], -1);
			int coins = getMinC(0, 0);
			System.out.println(ans+" "+coins);
		}
	}
}
