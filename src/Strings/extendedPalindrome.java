package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class extendedPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		String line = "";
		while ((line = bf.readLine()) != null && line.length() > 0) {
			char[] s = line.toCharArray();
			int last = s[s.length - 1];
			int printFromHereIndex = -1;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == last) {
					int countRev = s.length - 2;
					int len = countRev;
					if ((len - i) / 2 == 0)
						break;
					int countUp = 0;
					int matchSoFar = -1;
					int countUpSofar = -1;
					int countDownSoFfar = -1;

					boolean flag = false;

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
			for (int i = printFromHereIndex; i >= 0; i--) {
				line += s[i];
			}
			out.append(line);
			out.append("\n");
		}
		System.out.println(out);
	}

}
