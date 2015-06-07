package CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TurnOffTheLights {
	static int size = 10, INF = 100;
	static int[] grid;

	static int check() {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i] > 0)
				return INF;
		}
		return 0;
	}

	static boolean checkBack(int row) {
		for (int i = 0; i < row - 1; i++) {
			if (grid[i] != 0)
				return true;
		}
		return false;
	}

	static int minMoves(int row, int i, int movesSoFar) {
		if (movesSoFar >= 100)
			return INF;
		if (row == size) {
			return check();
		}
		if (checkBack(row))
			return INF;
		boolean f = (i == size - 1);
		int min = minMoves(f ? row + 1 : row, f ? 0 : i + 1, movesSoFar);
		if (row == 0 || (grid[row - 1] & (1 << i)) > 0) {
			if ((grid[row] & (1 << i)) > 0) {
				grid[row] &= ~(1 << i);
				changeState(row, i);
				min = Math.min(
						1 + minMoves(f ? row + 1 : row, f ? 0 : i + 1,
								movesSoFar + 1), min);
				grid[row] ^= (1 << i);
				changeState(row, i);
			} else {
				grid[row] ^= (1 << i);
				changeState(row, i);
				min = Math.min(
						1 + minMoves(f ? row + 1 : row, f ? 0 : i + 1,
								movesSoFar + 1), min);
				grid[row] &= ~(1 << i);
				changeState(row, i);
			}
		}
		return min;
	}

	static void changeState(int row, int i) {
		if (row != 0) {
			if ((grid[row - 1] & (1 << i)) > 0) {
				grid[row - 1] &= ~(1 << i);
			} else {
				grid[row - 1] ^= (1 << i);
			}
		}
		if (row + 1 < size) {
			if ((grid[row + 1] & (1 << i)) > 0) {
				grid[row + 1] &= ~(1 << i);
			} else {
				grid[row + 1] ^= (1 << i);
			}

		}
		if (i != 0) {
			if ((grid[row] & (1 << (i - 1))) > 0) {
				grid[row] &= ~(1 << (i - 1));
			} else {
				grid[row] ^= (1 << (i - 1));
			}
		}
		if (i + 1 < size) {
			if ((grid[row] & (1 << (i + 1))) > 0) {
				grid[row] &= ~(1 << (i + 1));
			} else {
				grid[row] ^= (1 << (i + 1));
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder st = new StringBuilder();
		grid = new int[size];
		while (true) {
			line = bf.readLine();
			if (line.equals("end"))
				break;
			Arrays.fill(grid, 0);
			st.append(line + " ");
			for (int i = 0; i < size; i++) {
				line = bf.readLine();
				int c = size - 1;
				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) == 'O')
						grid[i] = ((grid[i]) ^ (1 << c));
					c--;
				}
			}
			int res = minMoves(0, 0, 0);
			if (res > 100)
				res = -1;
			st.append(res);
			st.append('\n');
		}
		System.out.print(st);
	}
}
