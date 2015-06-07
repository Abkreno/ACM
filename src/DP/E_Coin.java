package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E_Coin {
	static int m, s;
	static int coins[][] = new int[2][40];
	static int DP[][][] = new int[40][300][300];
	static int INF = 1000000000;

	static int Min(int curr, int x, int y) {
		if (x * x + y * y == s * s)
			return 0;
		if (x * x + y * y > s * s || curr >= m)
			return INF;
		return DP[curr][x][y] = Math.min(Min(curr + 1, x, y),
				1 + Min(curr, x + coins[0][curr], y + coins[1][curr]));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			String l[] = bf.readLine().split(" ");
			m = Integer.parseInt(l[0]);
			s = Integer.parseInt(l[1]);
			for (int i = 0; i < m; i++) {
				l = bf.readLine().split(" ");
				coins[0][i] = Integer.parseInt(l[0]);
				coins[1][i] = Integer.parseInt(l[1]);
			}
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 300; j++) {
					Arrays.fill(DP[i][j], -1);
				}
			}
			int min = Min(0, 0, 0);
			if (min >= INF)
				System.out.println("not possible");
			else
				System.out.println(min);
			bf.readLine();
		}
	}
}
