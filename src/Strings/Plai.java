package Strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Plai {
	static String arr;
	static int DP[][];
	static HashSet<String> h;

	static int f(int curr, int last, int start, int end) {
		if (curr < 0 || last < 0 || curr >= arr.length()
				|| last >= arr.length())
			return 0;
		if (curr == last) {
			int i = start;
			int j = end;
			while (i < j) {
				String current = arr.substring(i, j + 1);
				h.add(current);
				j--;
				i++;
			}
			h.add(arr.charAt(i) + "");
			DP[start][end] = 1;
			return ((end - start) / 2) + 1
					+ f(start, (end / 2) - 1, start, (end / 2) - 1);
		}
		if (curr + 1 == last) {
			if (arr.charAt(curr) == arr.charAt(last)) {
				int i = start;
				int j = end;
				while (i < j) {
					String current = arr.substring(i, j + 1);
					h.add(current);
					j--;
					i++;
				}

				DP[start][end] = 1;
				return ((end - start) / 2) + ((end - start) % 2)
						+ f(start, end / 2, start, end / 2);
			} else {
				return 0;
			}
		}
		if (arr.charAt(curr) == arr.charAt(last))
			return DP[curr][last] = f(curr + 1, last - 1, start, end);
		else {
			int c1 = 0;
			int c2 = 0;
			if (DP[start + 1][end] == 0) {
				c1 = f(start + 1, end, start + 1, end);
			}
			if (DP[start + 1][end] == 0) {
				c2 = f(start, end - 1, start, end - 1);
			}
			return DP[curr][last] = c1 + c2;
		}

	}

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:/Users/Moh/Desktop/File.txt");
		@SuppressWarnings({ "unused", "resource" })
		BufferedReader bf1 = new BufferedReader(fr);
		PrintWriter bw = new PrintWriter("C:/Users/Moh/Desktop/File2.txt");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String line = "";
		DP = new int[5001][5001];
		while ((line = bf.readLine()) != null && line.length() > 0) {
			h = new HashSet<String>();
			for (int i = 0; i < DP.length; i++) {
				Arrays.fill(DP[i], 0);
			}
			arr = line;
			f(0, arr.length() - 1, 0, arr.length() - 1);
			System.out.println(arr.length());
			System.out.println(h.size());
		}
		bw.flush();
		bw.close();

	}
}
