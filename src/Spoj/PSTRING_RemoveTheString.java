package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PSTRING_RemoveTheString {
	static int inf = 1000000;
	static char[] X, Y;
	static int dp[][] = new int[10005][1005];
	static int trans[][] = new int[1005][26];
	static int f[] = new int[1005];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = bf.readLine()) != null && line.length() > 0) {
			char[] tmp = line.toCharArray();
			int xlen = tmp.length + 1;
			X = new char[xlen];
			for (int i = 0; i < tmp.length; i++) {
				X[i + 1] = tmp[i];
			}
			tmp = bf.readLine().toCharArray();
			int ylen = tmp.length;
			Y = new char[ylen + 1];
			for (int i = 0; i < tmp.length; i++) {
				Y[i + 1] = tmp[i];
			}
			int i, j, k, nxt;
			f[0] = f[1] = k = 0;
			for (i = 2; i <= ylen; i++) {
				while (k > 0 && Y[i] != Y[k + 1])
					k = f[k];
				if (Y[i] == Y[k + 1])
					k++;
				f[i] = k;
			}
			// Compute trans table
			for (i = 0; i < ylen; i++)
				for (char c = 'a'; c <= 'z'; c++) {
					k = i;
					while (k > 0 && Y[k + 1] != c)
						k = f[k];
					if (Y[k + 1] == c)
						k++;
					trans[i][c - 'a'] = k;
				}

			for (i = 0; i <= xlen; i++)
				dp[i][ylen] = inf;
			for (j = 0; j < ylen; j++)
				dp[xlen][j] = 0;

			for (i = xlen - 1; i > 0; i--)
				for (j = ylen - 1; j >= 0; j--) {
					dp[i][j] = 1 + dp[i + 1][j];
					nxt = dp[i + 1][trans[j][X[i] - 'a']];
					if (dp[i][j] > nxt)
						dp[i][j] = nxt;
				}
			System.out.println(dp[1][0]);
		}
	}
}
