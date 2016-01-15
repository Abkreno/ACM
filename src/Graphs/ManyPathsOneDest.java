package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ManyPathsOneDest {
	static LinkedList<Integer> graph[] = new LinkedList[10000];
	static int DP[] = new int[10000];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n, c;
		String[] l;
		while (true) {
			n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				graph[i] = new LinkedList<>();
				DP[i] = -1;
			}
			for (int i = 0; i < n; i++) {
				l = bf.readLine().split(" ");
				c = Integer.parseInt(l[0]);
				for (int j = 0; j < c; j++) {
					graph[i].add(Integer.parseInt(l[j + 1]));
				}
			}
			System.out.println(count(0));
		}
	}

	static int count(int curr) {
		if (graph[curr].size() == 0)
			return 1;
		if (DP[curr] != -1)
			return DP[curr];
		int ans = 0;
		for (int x : graph[curr]) {
			ans += count(x);
		}
		return DP[curr] = ans;
	}
}
