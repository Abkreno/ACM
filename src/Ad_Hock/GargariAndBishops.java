package Ad_Hock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GargariAndBishops {
	static long[][] values, nums;
	static long[][][] DP;
	static int n;

	static long getRight(int x, int y, long l) {
		if (x >= n || y >= n)
			return l;
		return DP[x][y][0] = getRight(x + 1, y + 1, l + nums[x][y]);
	}

	static long getLeft(int y, int x, long l) {
		if (x >= n || y < 0)
			return l;
		return DP[y][x][1] = getLeft(y - 1, x + 1, l + nums[x][y]);
	}

	public static void main(String[] args) throws IOException {
		input.init(System.in);
		n = input.nextInt();
		nums = new long[n][n];
		values = new long[n][n];
		DP = new long[n + 10][n + 10][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j] = input.nextLong();
			}
		}
		for (int i = 0; i < n; i++) {
			getRight(i, 0, 0);
			getRight(0, i, 0);
			getLeft(i, 0, 0);
			getLeft(n - 1, i, 0);
		}
		long max1 = -1, max2 = 0;
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				values[i][j] = DP[i][j][0] + DP[i][j][1] - nums[i][j];
				if (values[i][j] > max1) {
					max1 = values[i][j];
					x1 = i;
					y1 = j;
				}
			}
			// System.out.println();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (values[i][j] > max2) {
					int x = Math.abs(x1 - i);
					int y = Math.abs(y1 - j);
					if (x == y)
						continue;
					if (!(i == x1 && j == y1)) {
						if (values[i][j] > max2) {
							max2 = values[i][j];
							x2 = i + 1;
							y2 = j + 1;
						}
					}
				}
			}
		}
		x1++;
		y1++;
		System.out.println(max1 + max2);
		System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
	}

	public static class input {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		/** call this method to initialize reader for InputStream */
		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		/** get next word */
		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				// TODO add check for eof if necessary
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		static long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}