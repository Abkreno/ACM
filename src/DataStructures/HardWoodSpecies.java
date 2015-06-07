package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class HardWoodSpecies {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (t-- > 0) {
			HashMap<String, Integer> m = new HashMap<String, Integer>();
			LinkedList<String> list = new LinkedList<String>();
			double total = 0.0;
			String line;
			while ((line = bf.readLine()) != null && (!line.isEmpty())) {
				total++;
				if (m.containsKey(line)) {
					m.put(line, m.get(line) + 1);
				} else {
					list.add(line);
					m.put(line, 1);
				}
			}
			Collections.sort(list);
			for (String i : list) {
				int n = m.get(i);
				out.printf("%s %.4f\n", i, (n * 1.0 / total * 100));
			}
			if (t > 0)
				out.println();
		}
		out.close();
		bf.close();
	}
}
