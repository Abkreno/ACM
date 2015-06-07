package CompleteSearch;

import java.util.Scanner;

public class bToNQueens_bitmasks {
	static int mask, ans;
	static int tmp[];

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int count = 1;
		tmp = new int[18];
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				tmp[i] = (1 << n) - 1;
				char line[] = sc.next().toCharArray();
				int c = 0;
				for (char j : line) {
					if (j == '*')
						tmp[i] ^= 1 << c;
					c++;
				}
			}
			mask = (1 << n) - 1;
			ans = 0;
			solve(0, 0, 0, 0);
			System.out.println("Case " + count + ": " + ans);
			count++;
		}
	}

	static void solve(int level, int x, int m1, int m2) {
		if (x == mask) {
			ans++;
			return;
		}
		int pos = mask & ~(x | m1 | m2) & tmp[level];
		while (pos != 0) {
			int p = pos & (-pos);
			pos -= p;
			solve(level + 1, x + p, (m1 + p) << 1, (m2 + p) >> 1);
		}
	}
}
