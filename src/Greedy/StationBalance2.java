package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class StationBalance2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String line;
		int c = 1;
		while ((line = bf.readLine()) != null && line.length() > 0) {
			String l[] = line.split(" ");
			int s = Integer.parseInt(l[0]);
			int n = Integer.parseInt(l[1]);
			l = bf.readLine().split(" ");
			LinkedList<Integer> boxes = new LinkedList<Integer>();
			double sum = 0;
			for (int i = 0; i < n; i++) {
				int curr = Integer.parseInt(l[i]);
				boxes.add(curr);
				sum += curr;
			}
			double AM = (sum) / ((double) s);
			Collections.sort(boxes);
			int set[][] = new int[s][2];
			for (int i = 0; i < set.length; i++) {
				Arrays.fill(set[i], -1);
			}
			int size = boxes.size() / 2;
			for (int i = 0; i < Math.max(set.length, size) && !boxes.isEmpty(); i++) {
				set[i][0] = boxes.removeLast();
			}

			// more boxes
			for (int i = set.length - 1; i >= 0 && !boxes.isEmpty(); i--) {
				set[i][1] = boxes.removeLast();
				Arrays.sort(set[i]);
			}
			double ans = 0;
			for (int i = 0; i < set.length; i++) {
				ans += Math
						.abs(((set[i][0] == -1 ? 0 : set[i][0]) + (set[i][1] == -1 ? 0
								: set[i][1]))
								- AM);
			}

			out.println("Set #" + (c++));
			for (int i = 0; i < set.length; i++) {
				out.println(" " + i + ":"
						+ ((int) set[i][0] == -1 ? "" : " " + (int) set[i][0])
						+ ((int) set[i][1] == -1 ? "" : " " + (int) set[i][1]));
			}
			out.println("IMBALANCE = " + String.format("%.5f", ans));
			out.println();
		}
		out.close();
	}
}
