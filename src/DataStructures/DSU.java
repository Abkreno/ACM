package DataStructures;

public class DSU {
	int parent[];

	DSU(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	int find(int x) {
		int root = x;
		while (parent[root] >= 0)
			root = parent[root];
		while (x != root) {
			int old = x;
			x = parent[x];
			parent[old] = root;
		}
		return root;
	}

	boolean merge(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		if (parent[x] > parent[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		parent[x] += parent[y];
		parent[y] = x;
		return true;
	}
}
