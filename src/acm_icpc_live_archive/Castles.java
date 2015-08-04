package acm_icpc_live_archive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Castles {
	static LinkedList<Integer>[] graph = new LinkedList[100];
	static int[][] info = new int[2][100];
	static int ans, n;

	static class Child implements Comparable<Child> {
		int total, left;

		Child(int t, int l) {
			total = t;
			left = l;
		}

		@Override
		public int compareTo(Child e) {
			if (left > e.left)
				return -1;
			if (left < e.left)
				return 1;
			if (total > e.total)
				return 1;
			if (total < e.total)
				return -1;
			return 0;
		}

		public String toString() {
			return "" + total;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		int a, b, count = 0;
		while (true) {
			n = Integer.parseInt(bf.readLine().split(" ")[0]);
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				l = bf.readLine().split(" ");
				a = Integer.parseInt(l[0]);
				b = Integer.parseInt(l[1]) + Integer.parseInt(l[2]);
				info[0][i] = Math.max(a, b);
				info[1][i] = b;
				graph[i] = new LinkedList<>();
			}
			for (int i = 0; i < n - 1; i++) {
				l = bf.readLine().split(" ");
				a = Integer.parseInt(l[0]) - 1;
				b = Integer.parseInt(l[1]) - 1;
				graph[a].add(b);
				graph[b].add(a);
			}

			ans = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				ans = Math.min(ans, dfs(i, -1).total);
			}
			System.out.printf("Case %d: %d\n", ++count, ans);
		}
	}

	private static Child dfs(int i, int prev) {
		LinkedList<Child> childs = new LinkedList<>();
		for (int x : graph[i]) {
			if (x != prev) {
				childs.add(dfs(x, i));
			}
		}
		Collections.sort(childs);
		int total = info[0][i];
		int left = info[0][i] - info[1][i];
		for (Child x : childs) {
			if (left > x.total) {
				left -= x.total - x.left;
			} else {
				total += x.total - left;
				left = x.left;
			}
		}
		return new Child(total, left);
	}
}
