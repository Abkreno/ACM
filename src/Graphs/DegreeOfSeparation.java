package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class DegreeOfSeparation {
	static int[][] p = new int[100][100];
	static int INF = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		int n, m, edges, a, b, ind, c = 1;
		HashMap<String, Integer> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		while (true) {
			l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			m = Integer.parseInt(l[1]);
			if (n + m == 0)
				break;
			for (int i = 0; i < p.length; i++) {
				Arrays.fill(p[i], INF);
				p[i][i] = 0;
			}
			edges = ind = 0;
			while (edges < m) {
				l = bf.readLine().split(" ");
				for (int i = 0; i < l.length; i++) {
					if (!map.containsKey(l[i]))
						map.put(l[i], ind++);
					a = map.get(l[i]);
					if (!map.containsKey(l[i + 1]))
						map.put(l[i + 1], ind++);
					b = map.get(l[i + 1]);
					p[a][b] = p[b][a] = 1;
					i++;
					edges++;
				}
			}
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (p[i][j] > p[i][k] + p[k][j]) {
							p[i][j] = p[i][k] + p[k][j];
						}
					}
				}
			}
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, p[i][j]);
				}
			}
			if (max >= INF)
				sb.append("Network " + c + ": DISCONNECTED\n\n");
			else
				sb.append("Network " + c + ": " + max + "\n\n");
			c++;
			map.clear();
		}
		System.out.print(sb);
	}
}
