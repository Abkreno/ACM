package Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PowerStrings {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] s;
		while (true) {
			s = bf.readLine().toCharArray();
			if (s[0] == '.')
				break;
			int l = s.length;
			int best = 1;
			boolean flag;
			for (int len = 1; len < s.length; len++) {
				if (l % len == 0) {
					flag = true;
					for (int i = len; i < s.length; i++) {
						if (s[i] != s[i % len]) {
							flag = false;
							break;
						}
					}
					if (flag)
						best = Math.max(l / len, best);
				}
			}
			System.out.println(best);
		}
	}
}
