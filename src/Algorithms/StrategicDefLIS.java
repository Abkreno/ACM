package Algorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StrategicDefLIS {
	public static int[] lis(int[] a) {
		int n = a.length;
		int[] tail = new int[n];
		int[] prev = new int[n];

		int len = 0;
		for (int i = 0; i < n; i++) {
			int pos = lower_bound(a, tail, len, a[i]);
			if (pos == len) {
				++len;
			}
			prev[i] = pos > 0 ? tail[pos - 1] : -1;
			tail[pos] = i;
		}

		int[] res = new int[len];
		for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
			res[--len] = a[i];
		}
		return res;
	}

	static int lower_bound(int[] a, int[] tail, int len, int key) {
		int lo = -1;
		int hi = len;
		while (hi - lo > 1) {
			int mid = (lo + hi) >>> 1;
			if (a[tail[mid]] < key) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return hi;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (t-- > 0) {
			String line;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			while ((line = bf.readLine()) != null && (!line.isEmpty())) {
				arr.add(Integer.parseInt(line));
			}
			int a[] = new int[arr.size()];
			int c = 0;
			for (int i : arr) {
				a[c++] = i;
			}
			a = lis(a);
			out.println("Max hits: " + a.length);
			for (int i = 0; i < a.length; i++) {
				out.println(a[i]);
			}
			if (t > 0)
				out.println();
		}
		out.close();
	}
}
