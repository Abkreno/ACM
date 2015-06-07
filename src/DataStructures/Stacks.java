package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;

public class Stacks {
	static int Q;
	static Station[] stations;

	static class Station {
		LinkedList<Integer> l = new LinkedList<Integer>();
		boolean full;

		Station() {
			l = new LinkedList<Integer>();
		}

		void enqueue(int x) {
			l.addLast(x);
			if (l.size() == Q)
				full = true;
		}

		int dequeue() {
			if (l.size() - 1 < Q)
				full = false;
			return l.removeFirst();
		}
	}

	static boolean jobDone(int n) {
		for (int i = 0; i < stations.length; i++) {
			if (stations[i].l.size() > 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Stack<Integer> carrier = new Stack<Integer>();
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			String[] line = bf.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			Q = Integer.parseInt(line[2]);
			stations = new Station[N];
			for (int i = 0; i < stations.length; i++) {
				line = bf.readLine().split(" ");
				stations[i] = new Station();
				for (int j = 1; j < line.length; j++) {
					stations[i].enqueue(Integer.parseInt(line[j]));
				}
			}
			int i = 0;
			int time = 0;
			while (true) {
				if (carrier.isEmpty() && jobDone(N)) {
					break;
				} // unload
				while (!carrier.isEmpty()) {
					if (carrier.peek() == (i + 1)) {
						carrier.pop();
						time += 1;
					} else if (!(stations[i].full)) {
						stations[i].enqueue(carrier.pop());
						time++;
					} else {
						break;
					}
				}
				// then load
				while (carrier.size() < S && !(stations[i].l.isEmpty())) {
					carrier.push(stations[i].dequeue());
					time += 1;
				}
				i++;
				if (i == N) {
					i = 0;
				}
				time += 2;

			}
			time -= 2;
			if (time < 0)
				time = 0;
			out.println(time);
		}
		out.close();
		bf.close();
	}
}
