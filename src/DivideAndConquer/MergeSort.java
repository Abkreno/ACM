package DivideAndConquer;

import java.util.Scanner;

public class MergeSort {
	static int[] arr;
	static int swaps = 0;

	static void mSort(int lo, int hi) {
		if (hi - lo < 2)
			return;
		int mid = (hi + lo) / 2;
		mSort(lo, mid);
		mSort(mid, hi);
		merg(lo, mid, hi);
	}

	static void merge(int lo, int hi) {
		int[] b = new int[hi - lo];
		int mid = b.length / 2;
		int s1 = 0;
		int end = b.length;
		int s2 = mid;
		for (int i = lo; i < hi; i++) {
			if (s1 >= mid) {
				arr[i] = b[s2++];
			} else if (s2 >= end) {
				arr[i] = b[s1++];
			} else if (b[s1] > b[s2]) {
				swaps++;
				arr[i] = b[s2++];
			} else {
				arr[i] = b[s1++];
			}
		}

	}

	static void merg(int iBegin, int iMiddle, int iEnd) {
		int i0 = iBegin, i1 = iMiddle;
		int[] B = new int[iEnd - iBegin];
		// While there are elements in the left or right runs
		for (int j = 0; j < B.length; j++) {
			// If left run head exists and is <= existing right run head.
			if (i0 < iMiddle && (i1 >= iEnd || arr[i0] <= arr[i1])) {
				B[j] = arr[i0];
				i0 = i0 + 1;
			} else {
				B[j] = arr[i1];
				swaps += (iMiddle - i0);
				i1 = i1 + 1;
			}
		}
		int c = 0;
		for (int i = iBegin; i < iEnd; i++) {
			arr[i] = B[c++];
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		mSort(0, n);
		System.out.println(swaps);
		sc.close();
	}

}
