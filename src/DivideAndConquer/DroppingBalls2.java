package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DroppingBalls2 {
	static boolean Tree[] = new boolean[(int) Math.pow(2, 20)];
	static int patteren[][] = new int[20][];
	static int size;

	static int go(int curr) {
		if (curr * 2 + 1 > size || curr * 2 > size)
			return curr;
		if (Tree[curr]) {
			Tree[curr] = false;
			return go(curr * 2 + 1);
		} else {
			Tree[curr] = true;
			return go(curr * 2);
		}
	}

	static void fill() {
		for (int i = 0; i < patteren.length; i++) {
			patteren[i] = new int[(int) Math.pow(2, i)];
			size = (int) Math.pow(2, i + 1);
			for (int j = 0; j < patteren[i].length; j++) {
				patteren[i][j] = go(1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		fill();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			String l[] = bf.readLine().split(" ");
			int D = Integer.parseInt(l[0]);
			int I = Integer.parseInt(l[1]);
			int leafs = (int) Math.pow(2, D - 1);
			int index = (I % leafs) - 1;
			if (index < 0)
				index = leafs - 1;
			System.out.println(patteren[D - 1][index]);
		}
	}
}
