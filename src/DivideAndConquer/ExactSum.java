package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExactSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = bf.readLine()) != null && line.length() > 0) {
			int n = Integer.parseInt(line);
			String[] l = bf.readLine().split(" ");
			int money = Integer.parseInt(bf.readLine());
			int p[] = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = Integer.parseInt(l[i]);
			}
			Arrays.sort(p);
			int minDif = Integer.MAX_VALUE;
			int x = 0;
			int y = 0;
			for (int i = 0; i < n; i++) {
				int pos = Arrays.binarySearch(p, money - p[i]);
				if (pos >= 0 && pos != i && p[pos] + p[i] == money) {
					if (p[i] - p[pos] < minDif) {
						x = i;
						y = pos;
						minDif = Math.abs(p[i] - p[pos]);
					}
				}
			}
			System.out.printf(
					"Peter should buy books whose prices are %d and %d.\n\n",
					p[x], p[y]);
			bf.readLine();
		}
	}
}
