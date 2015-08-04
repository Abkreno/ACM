package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class K12_BuildingConstruction {
	static int n;
	static Building nums[];

	static class Building implements Comparable<Building> {
		long h, c;

		Building(long h) {
			this.h = h;
		}

		@Override
		public int compareTo(Building b) {
			if (h > b.h)
				return 1;
			if (h < b.h)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		while (t-- > 0) {
			n = Integer.parseInt(bf.readLine());
			nums = new Building[n];
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				nums[i] = new Building(Integer.parseInt(l[i]));
			}
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				nums[i].c = Integer.parseInt(l[i]);
			}
			Arrays.sort(nums);
			System.out.println(ternarySearchMin(0, n - 1));
		}
	}

	static long ternarySearchMin(int lo, int hi) {
		while (hi - lo > 3) {
			int g = lo + (hi - lo) / 3;
			int h = lo + (2 * (hi - lo)) / 3;

			if (cost(g) < cost(h)) {
				hi = h;
			} else {
				lo = g;
			}
		}
		long ans = cost(hi);
		for (int i = lo; i < hi; i++) {
			ans = Math.min(ans, cost(i));
		}
		return ans;
	}

	static long cost(int mid) {
		long res = 0;
		for (int i = 0; i < n; i++) {
			res += Math.abs(nums[mid].h - nums[i].h) * nums[i].c;
		}
		return res;
	}

	static boolean rightGreaterThanLeft(long mid) {
		long leftCost = 0;
		long rightCost = 0;
		boolean left = true;
		for (int i = 0; i < n; i++) {
			if (nums[i].h > mid) {
				left = false;
			}
			if (left) {
				leftCost += (mid - nums[i].h) * nums[i].c;
			} else {
				rightCost += (nums[i].h - mid) * nums[i].c;
			}
		}
		return rightCost > leftCost;
	}
}
