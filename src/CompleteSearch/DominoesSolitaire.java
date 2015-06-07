package CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DominoesSolitaire {
	static Domino dominos[];

	static class Domino {
		int left, right;

		Domino(int l, int r) {
			left = l;
			right = r;
		}

		public String toString() {
			return this.left + " " + this.right;
		}
	}

	static int m, n, r;

	static boolean f(int left, int spaces, int mask) {
		if (spaces == n) {
			return left == r;
		}
		if (mask == (1 << m) - 1) {
			return false;
		}
		boolean call = false;
		for (int i = 0; i < dominos.length; i++) {
			if (((1 << i) & mask) == 0) {
				if (dominos[i].right == left || dominos[i].left == left) {
					call = f(dominos[i].left == left ? dominos[i].right
							: dominos[i].left, spaces + 1, mask ^ (1 << i));
					if (call)
						break;
				}
			}
		}
		return call;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			n = Integer.parseInt(bf.readLine().split(" ")[0]);
			if (n == 0)
				break;
			m = Integer.parseInt(bf.readLine().split(" ")[0]);
			dominos = new Domino[m];
			String ss[] = bf.readLine().split(" ");
			int l = Integer.parseInt(ss[1]);
			ss = bf.readLine().split(" ");
			r = Integer.parseInt(ss[0]);
			for (int i = 0; i < m; i++) {
				ss = bf.readLine().split(" ");
				dominos[i] = new Domino(Integer.parseInt(ss[0]),
						Integer.parseInt(ss[1]));
			}
			if (f(l, 0, 0))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
