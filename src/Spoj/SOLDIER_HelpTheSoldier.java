package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SOLDIER_HelpTheSoldier {
	static int N, T, count[] = new int[6], nums[][][] = new int[2][6][210];
	static int DP[][][] = new int[6][1005][1005];

	static int getMax(int currType, int currMax, int currPrice) {
		if (currPrice < 0)
			return 0;
		if (currType > 5)
			return currMax;
		if (DP[currType][currMax][currPrice] != -1) {
			return DP[currType][currMax][currPrice];
		}
		int max = 0;
		for (int i = 0; i < count[currType]; i++) {
			max = Math.max(
					max,
					getMax(currType + 1,
							Math.min(currMax, nums[1][currType][i]), currPrice
									- nums[0][currType][i]));
		}
		return DP[currType][currMax][currPrice] = max;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 1005; j++) {
				Arrays.fill(DP[i][j], -1);
			}
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		N = Integer.parseInt(l[0]);
		T = Integer.parseInt(l[1]);
		Arrays.fill(count, 0);
		int t, p, q, ans;
		for (int i = 0; i < N; i++) {
			l = bf.readLine().split(" ");
			t = Integer.parseInt(l[0]) - 1;
			p = Integer.parseInt(l[1]);
			q = Integer.parseInt(l[2]);
			if (t > 5 || t < 0)
				continue;
			nums[0][t][count[t]] = p;
			nums[1][t][count[t]++] = q;
		}
		ans = getMax(0, 1004, T);
		System.out.println(ans);
	}
}
