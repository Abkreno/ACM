package DP;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class LIS {
	static void reconstruct_print(int end, int[] a, int[] p) {
		int x = end;
		Stack<Integer> s = new Stack<Integer>();
		for (; p[x] >= 0; x = p[x])
			s.push(a[x]);
		System.out.printf("[%d", a[x]);
		for (; !s.isEmpty(); s.pop())
			System.out.printf(", %d", s.peek());
		System.out.printf("]\n");
	}

	public static void main(String[] args) {
		final int MAX_N = 20;

		int n = 11;
		int[] A = new int[] { -7, 10, 9, 2, 3, 8, 8, 1, 2, 3, 4 };
		int[] L_id = new int[MAX_N], P = new int[MAX_N];
		Vector<Integer> L = new Vector<Integer>();

		int lis = 0, lis_end = 0;
		for (int i = 0; i < n; ++i) {
			int pos = Collections.binarySearch(L, A[i]);
			if (pos < 0)
				pos = -(pos + 1); // some adjustments are needed
			if (pos >= L.size())
				L.add(A[i]);
			else
				L.set(pos, A[i]);
			L_id[pos] = i;
			P[i] = pos > 0 ? L_id[pos - 1] : -1;
			if (pos + 1 > lis) {
				lis = pos + 1;
				lis_end = i;
			}

		}

		System.out.printf("Final LIS is of length %d: ", lis);
		reconstruct_print(lis_end, A, P);
	}
}
