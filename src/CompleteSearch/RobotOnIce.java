package CompleteSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotOnIce {
	static boolean covered[][];
	static int numOfCovered, n, m, ans, size;
	static int checkSteps[];
	static int checkPoints[][];

	static void move(int r, int c, int direction, int level) {
		if (covered[r][c])
			return;
		if (r == 0 && c == 1) {
			if (numOfCovered == size)
				ans++;
			return;
		}
		if (level < 3) {
			if (numOfCovered == checkSteps[level]) {
				if (r != checkPoints[level][0] || c != checkPoints[level][1])
					return;
				level++;
			} else if (numOfCovered > checkSteps[level])
				return;
		}
		covered[r][c] = true;
		numOfCovered++;
		// 0 = Up / 1 = Left / 2 = Right / 3 = Down
		if (direction == 0) {
			if (r + 1 < m)
				move(r + 1, c, 0, level);
			if (c - 1 >= 0)
				move(r, c - 1, 1, level);
			if (c + 1 < n)
				move(r, c + 1, 2, level);
		} else if (direction == 1) {
			if (r + 1 < m)
				move(r + 1, c, 0, level);
			if (c - 1 >= 0)
				move(r, c - 1, 1, level);
			if (r - 1 >= 0)
				move(r - 1, c, 3, level);
		} else if (direction == 2) {
			if (r + 1 < m)
				move(r + 1, c, 0, level);
			if (r - 1 >= 0)
				move(r - 1, c, 3, level);
			if (c + 1 < n)
				move(r, c + 1, 2, level);
		} else {
			if (r - 1 >= 0)
				move(r - 1, c, 3, level);
			if (c + 1 < n)
				move(r, c + 1, 2, level);
			if (c - 1 >= 0)
				move(r, c - 1, 1, level);
		}
		covered[r][c] = false;
		numOfCovered--;
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = 1;
		while (true) {
			String l[] = bf.readLine().split(" ");
			m = Integer.parseInt(l[0]);
			n = Integer.parseInt(l[1]);
			size = m * n;
			if (m == 0 && n == 0)
				break;
			ans = 0;
			checkSteps = new int[3];
			checkPoints = new int[3][2];
			covered = new boolean[m][n];
			for (int i = 1; i <= 3; i++) {
				checkSteps[i - 1] = i * m * n / 4;
			}
			numOfCovered = 1;
			l = bf.readLine().split(" ");
			checkPoints[0][0] = Integer.parseInt(l[0]);
			checkPoints[0][1] = Integer.parseInt(l[1]);
			checkPoints[1][0] = Integer.parseInt(l[2]);
			checkPoints[1][1] = Integer.parseInt(l[3]);
			checkPoints[2][0] = Integer.parseInt(l[4]);
			checkPoints[2][1] = Integer.parseInt(l[5]);
			move(0, 0, 0, 0);
			System.out.println("Case " + count + ": " + ans);
			count++;
		}
	}
}
