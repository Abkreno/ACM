package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class extendedPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		String line = "";
		char[] s;
		boolean flag;
		int len, last, printFromHereIndex, countRev, countUp, matchSoFar, countUpSofar, countDownSoFfar;
		while ((line = bf.readLine()) != null && line.length() > 0) {
			s = line.toCharArray();
			last = s[s.length - 1];
			printFromHereIndex = -1;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == last) {
					countRev = s.length - 2;
					len = countRev;
					if ((len - i) / 2 == 0)
						break;
					countUp = 0;
					matchSoFar = -1;
					countUpSofar = -1;
					countDownSoFfar = -1;

					flag = false;

					for (int j = i + 1; countUp < (len - i) / 2; j++) {
						if (!flag && s[j] == last) {
							matchSoFar = j;
							countUpSofar = matchSoFar + 1;
							countDownSoFfar = s.length - 1;
							flag = true;
						} else if (flag) {
							if (s[countUpSofar] != s[countDownSoFfar]) {
								flag = false;
								matchSoFar = -1;
							} else {
								countUpSofar++;
								countDownSoFfar++;
							}
						}
						if (s[j] != s[countRev]) {
							if (matchSoFar != -1 && flag) {
								i = matchSoFar - 1;
								printFromHereIndex = matchSoFar - 1;
							} else {
								i = j;
								printFromHereIndex = j;
							}
							break;
						} else {
							countRev--;
							countUp++;
							if (countUp == (len - i) / 2) {
								i = s.length;
								break;
							}

						}
					}
				} else {
					printFromHereIndex = i;
				}
			}
			out.append(line);
			for (int i = printFromHereIndex; i >= 0; i--) {
				out.append(s[i]);
			}
			out.append("\n");
		}
		System.out.println(out);
	}

}
