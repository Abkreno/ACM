package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class PT07X_VertexCover {
	static LinkedList<Integer> graph[] = new LinkedList[100001];
	static int DP[][] = new int[2][100001];

	static int findMin(int curr, int parent, boolean pTaken) {
		if (DP[pTaken ? 1 : 0][curr] != -1)
			return DP[pTaken ? 1 : 0][curr];
		int r = 1;
		for (int i : graph[curr]) {
			if (i != parent)
				r += findMin(i, curr, true);
		}
		if (pTaken) {
			int c = 0;
			for (int i : graph[curr]) {
				if (i != parent)
					c += findMin(i, curr, false);
			}
			r = Math.min(r, c);
		}
		return DP[pTaken ? 1 : 0][curr] = r;
	}

	public static void main(String[] args) throws Exception {
		Arrays.fill(DP[0], -1);
		Arrays.fill(DP[1], -1);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a, b, n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		String[] l;
		for (int i = 0; i < n - 1; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		System.out.println(findMin(0, 0, true));
	}
}
