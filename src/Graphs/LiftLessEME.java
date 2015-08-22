package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LiftLessEME {
	static int graph[][] = new int[125 * 20][20];
	static int INF = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String curr, l[];
		int n, m, i, j, source, c, v, minDist;
		final int distances[] = new int[125 * 20];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						if (distances[o1] > distances[o2])
							return 1;
						if (distances[o1] < distances[o2])
							return -1;
						return 0;
					}
				});
		while ((curr = bf.readLine()) != null && curr.length() > 0) {
			l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			m = Integer.parseInt(l[1]);
			for (i = 0; i < m * (n - 1); i++) {
				l = bf.readLine().split(" ");
				for (j = 0; j < m; j++) {
					graph[i][j] = Integer.parseInt(l[j]) + 2;
				}
			}
			minDist = INF;
			for (source = 0; source < m; source++) {
				Arrays.fill(distances, INF);
				distances[source] = 0;
				q.add(source);
				while (!q.isEmpty()) {
					c = q.poll();
					for (j = 0; j < m; j++) {
						v = ((c / m) + 1) * m + j;
						if (v >= m * (n - 1) + m)
							break;
						if (distances[c] + graph[c][j] < distances[v]) {
							distances[v] = distances[c] + graph[c][j];
							q.add(v);
						}
					}
				}
				for (int k = m * (n - 1); k < m * (n - 1) + m; k++) {
					minDist = Math.min(minDist, distances[k]);
				}
			}
			System.out.println(Arrays.toString(distances));
			System.out.println(curr + "\n" + minDist);
		}
	}
}
