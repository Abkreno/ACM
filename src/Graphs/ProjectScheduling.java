package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class ProjectScheduling {
	static LinkedList<Edge> edges[] = new LinkedList[100];

	static class Edge implements Comparable<Edge> {
		int v, w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}

	static int dp[] = new int[100];

	static int dfs(int v) {
		if (edges[v].size() == 0)
			return 0;
		if (dp[v] != -1)
			return dp[v];
		int ans = 0;
		for (Edge e : edges[v]) {
			ans = Math.max(ans, e.w + dfs(e.v));
		}
		return dp[v] = ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		String line;
		int n, m, t, a, b, w, start,startW;
		t = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (t-- > 0) {
			for (int i = 0; i < edges.length; i++) {
				edges[i] = new LinkedList<>();
			}
			Arrays.fill(dp, -1);
			start = 0;
			startW = 0;
			while ((line = bf.readLine()) != null && line.length() > 0) {
				l = line.split(" ");
				a = l[0].charAt(0) - 'A';
				w = Integer.parseInt(l[1]);
				if (l.length > 2) {
					for (int i = 0; i < l[2].length(); i++) {
						b = l[2].charAt(i) - 'A';
						edges[b].add(new Edge(a, w));
					}
				} else {
					start = a;
					startW = w;
				}

			}
			System.out.println(startW + dfs(start));
			if(t!=0)System.out.println();
		}
	}
}
