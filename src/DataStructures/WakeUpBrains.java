package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class WakeUpBrains {
	static int N = 26;

	static boolean goodChar(char x) {
		if (x >= 65 && x <= 90)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		boolean first = true;
		while ((line = in.readLine()) != null) {
			if (first)
				first = false;
			else
				line = in.readLine();
			@SuppressWarnings("unchecked")
			ArrayList<Integer> Graph[] = new ArrayList[26];
			for (int i = 0; i < Graph.length; i++) {
				Graph[i] = new ArrayList<Integer>();
			}
			int n = Integer.parseInt(line);
			int m = Integer.parseInt(in.readLine());
			line = in.readLine();
			boolean invalid = false;
			boolean waked[] = new boolean[N];
			boolean myChars[] = new boolean[N];

			for (int i = 0; i < line.length(); i++) {
				if (goodChar(line.charAt(i))) {
					waked[line.charAt(i) - 'A'] = true;
					myChars[line.charAt(i) - 'A'] = true;

				} else {
					invalid = true;
					break;
				}
			}
			for (int i = 0; i < m; i++) {
				line = in.readLine();
				if (goodChar(line.charAt(0)) && goodChar(line.charAt(1))) {
					Graph[line.charAt(0) - 'A'].add(line.charAt(1) - 'A');
					Graph[line.charAt(1) - 'A'].add(line.charAt(0) - 'A');
					myChars[line.charAt(0) - 'A'] = true;
					myChars[line.charAt(1) - 'A'] = true;
				} else {
					invalid = true;
				}
			}
			int years = 0;
			LinkedList<Integer> waked1 = new LinkedList<Integer>();
			if (!invalid) {
				while (true) {
					for (int i = 0; i < N; i++) {
						if (myChars[i] && !waked[i]) {
							int connections = 0;
							for (int j : Graph[i]) {
								if (waked[j]) {
									connections++;
								}
							}
							if (connections >= 3) {
								waked1.add(i);
							}
						}
					}
					if (waked1.isEmpty()) {
						break;
					} else {
						years++;
						while (!waked1.isEmpty())
							waked[waked1.remove()] = true;
					}
				}
			}
			int woke = 0;
			for (int i = 0; i < waked.length; i++) {
				if (myChars[i] && !waked[i]) {
					invalid = true;
					break;
				} else if (myChars[i] && waked[i]) {
					woke++;
				}
			}
			if (woke != n)
				invalid = true;
			if (invalid)
				System.out.println("THIS BRAIN NEVER WAKES UP");
			else
				System.out.println("WAKE UP IN, " + years + ", YEARS");
		}
		in.close();
		System.exit(0);
	}
}