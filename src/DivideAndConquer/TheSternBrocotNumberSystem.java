package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheSternBrocotNumberSystem {
	static class node {
		int m, n;
		node left, right;

		node(int m, int n) {
			this.m = m;
			this.n = n;
		}

		public String toString() {
			return m + "/" + n;
		}
	}

	static int M, N;

	static void search(node curr, node left, node right, int i) {
		if (curr.m == M && curr.n == N) {
			return;
		}
		if (M * curr.n < N * curr.m) {
			System.out.print("L");
			node goLeft = new node(curr.m + left.m, curr.n + left.n);
			search(goLeft, left, curr, i + 1);
		} else {
			System.out.print("R");
			node goRight = new node(curr.m + right.m, curr.n + right.n);
			search(goRight, curr, right, i + 1);
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = bf.readLine()) != null && line.length() > 0) {
			String l[] = line.split(" ");
			M = Integer.parseInt(l[0]);
			N = Integer.parseInt(l[1]);
			if (M == 1 && N == 1)
				break;
			search(new node(1, 1), new node(0, 1), new node(1, 0), 0);
			System.out.println();
		}
	}
}
