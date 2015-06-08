package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GSS1_CanYouAnswerTheseQueriesI {
	static class Node {
		int max, prefix, suffix, sum;
	}

	static Node[] segTree = new Node[50000 * 4 + 1];

	static void insert_update(int ind, int st, int ed, int pos, int val) {
		if (st == pos && st == ed) {
			if (segTree[ind] == null)
				segTree[ind] = new Node();
			segTree[ind].max = segTree[ind].prefix = segTree[ind].suffix = segTree[ind].sum = val;
			return;
		}
		int l = ind << 1;
		int r = l + 1;
		int mid = (st + ed) / 2;
		if (mid < pos) {
			insert_update(r, mid + 1, ed, pos, val);
		} else {
			insert_update(l, st, mid, pos, val);
		}
		segTree[ind] = merge(segTree[l], segTree[r]);
	}

	static Node merge(Node a, Node b) {
		if (a == null)
			a = new Node();
		if (b == null)
			b = new Node();
		Node res = new Node();
		res.sum = a.sum + b.sum;
		res.prefix = Math.max(a.prefix, a.sum + b.prefix);
		res.suffix = Math.max(b.suffix, b.sum + a.suffix);
		res.max = Math.max(a.max, b.max);
		res.max = Math.max(res.max, a.suffix + b.prefix);
		return res;
	}

	static Node query(int ind, int st, int ed, int i, int j) {
		if (st == i && ed == j)
			return segTree[ind];
		int l = ind << 1;
		int r = l + 1;
		int mid = (st + ed) / 2;
		if (i > mid) {
			return query(r, mid + 1, ed, i, j);
		} else if (j <= mid) {
			return query(l, st, mid, i, j);
		} else {
			return merge(query(l, st, mid, i, mid),
					query(r, mid + 1, ed, mid + 1, j));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().split(" ")[0]);
		String[] l = bf.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			int val = Integer.parseInt(l[i - 1]);
			insert_update(1, 1, n, i, val);
		}
		int m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			System.out.println(query(1, 1, n, Integer.parseInt(l[0]),
					Integer.parseInt(l[1])).max);
		}
	}
}
