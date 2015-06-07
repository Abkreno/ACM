package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DropingBalls {
	static boolean Tree[];

	static int go(int curr) {
		if (curr * 2 + 1 > Tree.length || curr * 2 > Tree.length)
			return curr;
		if (Tree[curr]) {
			Tree[curr] = false;
			return go(curr * 2 + 1);
		} else {
			Tree[curr] = true;
			return go(curr * 2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			String l[] = bf.readLine().split(" ");
			int D = Integer.parseInt(l[0]);
			int I = Integer.parseInt(l[1]);
			Tree = new boolean[(int) Math.pow(2, D)];
			int res = 0;
			for (int j = 1; j <= I; j++) {
				res = go(1);
			}
			System.out.println(res);
		}
		bf.readLine();
	}
}
