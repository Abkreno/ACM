package DataStructures;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimalCoverage {

	static class Line implements Comparable<Line> {
		int start, end;

		public Line(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return start + " " + end;
		}

		public int compareTo(Line arg0) {
			if (start < arg0.start || (start == arg0.start && end > arg0.end))
				return -1;
			return 1;
		}
	}

	public static void main(String[] args) {
		int c;
		Scanner in = new Scanner(System.in);
		c = in.nextInt();
		while (c-- > 0) {
			int m = in.nextInt();
			PriorityQueue<Line> Q = new PriorityQueue<Line>();
			int s = in.nextInt();
			int e = in.nextInt();
			while (s != 0 || e != 0) {
				Q.add(new Line(s, e));
				s = in.nextInt();
				e = in.nextInt();
			}
			int start = 0;
			LinkedList<Line> taken = new LinkedList<Line>();
			while (start < m) {
				Line best = null;
				while (!Q.isEmpty() && Q.peek().start <= start) {
					Line cur = Q.remove();
					if (best == null || cur.end > best.end)
						best = cur;
				}
				if (best == null)
					break;
				else {
					start = best.end;
					taken.add(best);
				}
			}
			if (start < m)
				System.out.println(0);
			else {
				System.out.println(taken.size());
				for (Line i : taken) {
					System.out.println(i);
				}
			}
			if (c != 0)
				System.out.println();
		}
		in.close();
	}
}