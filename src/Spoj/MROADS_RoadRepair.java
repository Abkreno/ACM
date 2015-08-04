package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class MROADS_RoadRepair {
	static class Edge {
		int to, time, min;
		int vertex;

		Edge(int v, int t, int c, int m) {
			vertex = v;
			to = t;
			time = c;
			min = m;
		}

		public String toString() {
			return vertex + "--> " + to;
		}
	}

	static class Road {
		int cost, dec;

		Road(int c, int d) {
			cost = c;
			dec = d;
		}

		public String toString() {
			return cost + " " + dec;
		}
	}

	static LinkedList<Edge>[] graph;
	static int currK, mid, dec[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int i, a, b, c, d;
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		graph = new LinkedList[n];
		for (i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		int lo = -1, hi = 100001;
		for (i = 0; i < n - 1; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			c = Integer.parseInt(l[2]);
			d = Integer.parseInt(l[3]);
			lo = Math.max(lo, d);
			graph[a].add(new Edge(a, b, c, d));
			graph[b].add(new Edge(b, a, c, d));
		}
		dec = new int[n];
		lo--;
		hi++;
		while (lo + 1 < hi) {
			mid = (lo + hi) >> 1;
			currK = k;
			dfs(0, 0, 0, 0);
			if (currK >= 0) {
				hi = mid;
			} else {
				lo = mid;
			}
			Arrays.fill(dec, 0);
		}
		System.out.println(hi);
	}

	static void dfs(int curr, int dad, int timeSoFar, int decrease) {
		if (currK < 0)
			return;
		int currTime, currDec, tmp;
		for (Edge e : graph[curr]) {
			if (e.to == dad)
				continue;
			if (e.min > mid) {
				currK = -1;
				return;
			}
			currDec = (e.time - e.min);
			if (e.time > mid) {
				currK -= (e.time - mid);
				currDec -= (e.time - mid);
			}
			currTime = Math.min(mid, e.time);
			if (currTime + timeSoFar > mid) {
				tmp = (currTime + timeSoFar) - mid;
				currK -= tmp;
				if (decrease >= tmp) {
					decrease -= tmp;
					dec[dad] += tmp; // for the parent
					timeSoFar -= tmp;
				} else {
					tmp -= decrease;
					dec[dad] += decrease;
					timeSoFar -= decrease;
					decrease = 0;
					if (currDec >= tmp) {
						currDec -= tmp;
						currTime -= tmp;
					} else {
						currK = -1;
						return;
					}
				}
			}
			dfs(e.to, curr, Math.min(timeSoFar + currTime, mid), decrease
					+ currDec);
			if (decrease >= dec[curr]) {
				dec[dad] += dec[curr];
				decrease -= dec[curr];
				timeSoFar -= dec[curr];
				dec[curr] = 0;
			} else {
				dec[dad] += decrease;
				dec[curr] -= decrease;
				timeSoFar -= decrease;
				decrease = 0;
				if (currDec < dec[curr]) {
					currK = -1;
					return;
				}
				currDec -= dec[curr];
				currTime -= dec[curr];
				dec[curr] = 0;
			}
		}
	}
}
