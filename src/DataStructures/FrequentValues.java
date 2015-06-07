package DataStructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FrequentValues {
	static int segTree[];
	static int count[];
	static int values[];
	static int startIndex[];

	static int mid(int s, int e) {
		return s + ((e - s) / 2);
	}

	static void buildSegTree(int vertex, int start, int end) {
		if (start == end)
			segTree[vertex] = count[values[start]];
		else {
			int mid = mid(start, end);
			buildSegTree(vertex * 2 + 1, start, mid);
			buildSegTree(vertex * 2 + 2, mid + 1, end);
			segTree[vertex] = Math.max(segTree[vertex * 2 + 1],
					segTree[vertex * 2 + 2]);
		}
	}

	static int maxQ(int vertex, int start, int end, int i, int j) {
		if (j < start || i > end)
			return -1;
		if (i >= start && j <= end)
			return segTree[vertex];
		int v1 = maxQ(vertex * 2 + 1, start, mid(start, end), i, j);
		int v2 = maxQ(vertex * 2 + 2, mid(start, end) + 1, end, i, j);
		return Math.max(v1, v2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		startIndex = new int[200005];
		count = new int[200005];
		segTree = new int[1000000];
		while (true) {
			String[] l = bf.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			if (n == 0)
				break;
			values = new int[n];
			Arrays.fill(segTree, 0);
			Arrays.fill(count, 0);
			Arrays.fill(startIndex, -1);
			int q = Integer.parseInt(l[1]);
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				values[i] = Integer.parseInt(l[i]);
				values[i] += 100000;
				count[values[i]]++;
				if (count[values[i]] == 1)
					startIndex[values[i]] = i;
			}
			buildSegTree(0, 0, n - 1);
			while (q-- > 0) {
				l = bf.readLine().split(" ");
				int a = Integer.parseInt(l[0]) - 1;
				int b = Integer.parseInt(l[1]) - 1;
				int res = 0;
				if (values[a] == values[b]) {
					res = b - a + 1;
				} else {
					res = startIndex[values[a]] + count[values[a]] - a;
					int v = b - startIndex[values[b]] + 1;
					int right = startIndex[values[a]] + count[values[a]];
					int left = startIndex[values[b]] - 1;
					if (v > res)
						res = v;
					v = maxQ(0, 0, n - 1, right, left);
					if (v > res)
						res = v;
				}
				System.out.println(res);
			}
		}
	}
}
