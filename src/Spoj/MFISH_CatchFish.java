package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MFISH_CatchFish {
	static class ship implements Comparable<ship> {
		int B, D;
		int start, end;

		ship(int b, int d) {
			B = b;
			D = d;
		}

		@Override
		public int compareTo(ship s) {
			if (B > s.B)
				return 1;
			if (B < s.B)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int fish[] = new int[n + 1];
		String[] l = bf.readLine().split(" ");
		fish[1] = Integer.parseInt(l[0]);
		for (int i = 2; i < fish.length; i++) {
			fish[i] = fish[i - 1] + Integer.parseInt(l[i - 1]);
		}
		int m = Integer.parseInt(bf.readLine());
		ship[] ships = new ship[m];
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			ships[i] = new ship(Integer.parseInt(l[0]), Integer.parseInt(l[1]));
		}
		Arrays.sort(ships);
		int end = n;
		for (int i = m - 1; i >= 0; i--) {
			ships[i].start = Math.max(1, ships[i].B - ships[i].D + 1);
			ships[i].end = Math.min(end, ships[i].start + ships[i].D - 1);
			end = ships[i].start - 1;
		}
		int last = 1, j, first, maxD, maxSum, total = 0, limit, begin;
		for (int i = 0; i < ships.length; i++) {
			maxD = ships[i].D;
			first = Math.max(last, ships[i].B - ships[i].D + 1);
			maxSum = 0;
			limit = Math.min(n, i + 1 == m ? n : ships[i + 1].start - 1);
			limit = Math.min(limit, maxD + ships[i].B - 1);
			begin = Math.min(first + maxD - 1, n);
			begin = Math.min(begin, limit);
			for (j = begin; j <= limit; j++) {
				if (j - first + 1 > ships[i].D) {
					first++;
				}
				if (fish[j] - fish[first - 1] > maxSum) {
					maxSum = fish[j] - fish[first - 1];
					last = j + 1;
				}
			}

			total += maxSum;
		}
		System.out.println(total);

	}
}
