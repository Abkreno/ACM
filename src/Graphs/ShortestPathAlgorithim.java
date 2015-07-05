package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathAlgorithim {
	static int INF = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int c = 1;
		while (t-- > 0) {
			String l[] = bf.readLine().split(" ");

			int n = Integer.parseInt(l[0]);

			int m = Integer.parseInt(l[1]);

			List<Edge>[] graph = new List[n];

			for (int i = 0; i < n; i++)
				graph[i] = new ArrayList<Edge>();

			for (int i = 0; i < m; i++) {
				l = bf.readLine().split(" ");
				int v1 = Integer.parseInt(l[0]) - 1;
				int v2 = Integer.parseInt(l[1]) - 1;
				int w = Integer.parseInt(l[2]);
				graph[v1].add(new Edge(v2, w));
				graph[v2].add(new Edge(v1, w));
			}

			final long[] min = new long[n];
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(n,
					new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							if (min[o1] < min[o2]) {
								return -1;
							} else if (min[o1] > min[o2]) {
								return 1;
							}
							return 0;
						}

					});

			l = bf.readLine().split(" ");
			int u = Integer.parseInt(l[0]) - 1;
			int end = Integer.parseInt(l[1]) - 1;
			min[u] = 0;
			for (int i = 0; i < n; i++) {
				if (u != i)
					min[i] = INF;
				q.add(i);
			}

			while (!q.isEmpty()) {
				int v = q.poll();

				for (Edge edge : graph[v]) {
					int v1 = edge.v;
					long min1 = min[v] + edge.w;

					if (min1 < min[v1]) {
						min[v1] = min1;
						q.add(v1);
					}
				}
			}
			System.out.println("Case " + c + ": "
					+ (min[end] == INF ? -1 : min[end]));
			c++;
		}
	}

	static class Edge {
		int v;
		long w;

		Edge(int v, long w) {
			this.v = v;
			this.w = w;
		}
	}
}