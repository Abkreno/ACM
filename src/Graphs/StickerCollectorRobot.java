package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StickerCollectorRobot {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] l = bf.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			int m = Integer.parseInt(l[1]);
			int s = Integer.parseInt(l[2]);
			if (n + m + s == 0)
				break;
			char[][] grid = new char[n][m];
			int sI = 0;
			int sJ = 0;
			int currPos = 0;
			for (int i = 0; i < grid.length; i++) {
				grid[i] = bf.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (grid[i][j] == 'N') {
						sI = i;
						sJ = j;
						currPos = 0;
					} else if (grid[i][j] == 'S') {
						sI = i;
						sJ = j;
						currPos = 2;
					} else if (grid[i][j] == 'L') {
						sI = i;
						sJ = j;
						currPos = 1;
					} else if (grid[i][j] == 'O') {
						sI = i;
						sJ = j;
						currPos = 3;
					}
				}
			}
			int posX[] = new int[] { 0, 1, 0, -1 };
			int posY[] = new int[] { -1, 0, 1, 0 };
			char[] seq = bf.readLine().toCharArray();
			int res = 0;
			for (int i = 0; i < seq.length; i++) {
				// print(sI, sJ, currPos);
				if (seq[i] == 'D') {
					currPos = (currPos + 1) % 4;
				} else if (seq[i] == 'E') {
					if (currPos == 0)
						currPos = 3;
					else
						currPos--;
				} else {
					int nI = sI + posY[currPos];
					int nJ = sJ + posX[currPos];
					if (nI >= n || nI < 0 || nJ >= m || nJ < 0
							|| grid[nI][nJ] == '#')
						continue;
					if (grid[nI][nJ] == '*') {
						res++;
						grid[nI][nJ] = '.';
					}
					sI = nI;
					sJ = nJ;
				}
			}
			System.out.println(res);
		}
	}

}
