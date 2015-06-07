package CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GridGameUva {
	static int grid[][];
	static int n;
	static int Max_Val = 1000000;
	static int Min_Val = -1000000;
	static int[][][] DP;

	static int f(int row, int col, int last, boolean aliceTurn) {
		if (col == (1 << n) - 1 && row == (1 << n) - 1)
			return 0;
		if (DP[row][col][last] != -1)
			return DP[row][col][last];
		if (aliceTurn) {
			int max = Min_Val;
			for (int i = 0; i < n; i++) {
				int mask = 1 << i;
				if ((mask & row) == 0)
					max = Math.max(max, f(row ^ mask, col, i, false));
			}
			return DP[row][col][last] = max;
		} else {
			int min = Max_Val;
			for (int i = 0; i < n; i++) {
				int mask = 1 << i;
				if ((mask & col) == 0)
					min = Math.min(min,
							grid[last][i] + f(row, col ^ mask, i, true));
			}
			return DP[row][col][last] = min;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		DP = new int[1 << 8][1 << 8][8];
		grid = new int[8][8];
		while (t-- > 0) {
			n = Integer.parseInt(bf.readLine());
			for (int i = 0; i < DP.length; i++) {
				for (int j = 0; j < DP.length; j++) {
					Arrays.fill(DP[i][j], -1);
				}
			}
			for (int i = 0; i < n; i++) {
				String l[] = bf.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(l[j]);
				}
			}
			System.out.println(f(0, 0, 0, true));
		}
	}

}
