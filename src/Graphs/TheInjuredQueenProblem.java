package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheInjuredQueenProblem {
	static int N;
	static char[] board;
	static long DP[][] = new long[20][20];

	static long rec(int prev, int curr) {
		if (curr >= N)
			return 1;
		if (prev >= 0 && DP[prev][curr] != -1)
			return DP[prev][curr];
		long res = 0;
		if (board[curr] == '?') {
			for (int i = 0; i < board.length; i++) {
				if (Math.abs(i - prev) > 1)
					res += rec(i, curr + 1);
			}
		} else {
			int c = board[curr] - '0' - 1;
			if (Math.abs(c - prev) > 1)
				res += rec(c, curr + 1);
		}
		if (prev >= 0)
			DP[prev][curr] = res;
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l;
		while ((l = bf.readLine()) != null && l.length() > 0) {
			for (int i = 0; i < DP.length; i++) {
				Arrays.fill(DP[i], -1);
			}
			board = l.toCharArray();
			N = board.length;
			System.out.println(rec(-2, 0));
		}
	}
}
