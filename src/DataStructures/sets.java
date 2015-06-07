package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class sets {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n;
		while (true) {
			n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			HashMap<String, Integer> m = new HashMap<String, Integer>();
			@SuppressWarnings("unchecked")
			LinkedList<Integer>[] sets = new LinkedList[n];
			int max = -1;
			for (int i = 0; i < n; i++) {
				String[] line = bf.readLine().split(" ");
				sets[i] = new LinkedList<Integer>();
				for (int j = 0; j < 5; j++) {
					sets[i].add(Integer.parseInt(line[j]));
				}
				Collections.sort(sets[i]);
				String ss = "";

				for (int j : sets[i]) {
					ss += j;
				}
				if (m.containsKey(ss)) {
					m.put(ss, m.get(ss) + 1);
				} else {
					m.put(ss, 1);
				}
			}
			int res = 0;
			for (int i = 0; i < n; i++) {
				String ss = "";
				for (int j : sets[i]) {
					ss += j;
				}
				if (m.containsKey(ss)) {
					if (m.get(ss) > max) {
						max = m.get(ss);
						res = 1;
					} else if (m.get(ss) == max) {
						res++;
					}
				}
			}
			out.println(res);
		}
		out.close();
		bf.close();
	}
}
