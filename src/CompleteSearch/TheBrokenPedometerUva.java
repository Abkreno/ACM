package CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TheBrokenPedometerUva {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int p = Integer.parseInt(bf.readLine());
			int n = Integer.parseInt(bf.readLine());
			String[][] LEDs = new String[n][];
			for (int i = 0; i < LEDs.length; i++) {
				LEDs[i] = bf.readLine().split(" ");
			}
			int best = Integer.MAX_VALUE;
			for (int i = 0; i < 1 << p; i++) {
				HashSet<String> digits = new HashSet<String>();
				boolean good = true;
				for (int j = 0; j < LEDs.length; j++) {
					String[] curr = LEDs[j];
					String res = "";
					for (int c = 0; c < curr.length; c++) {
						if (curr[c].equals("0"))
							res += curr[c];
						else {
							if ((i & (1 << c)) > 0) {
								res += curr[c];
							} else {
								res += '0';
							}
						}
					}
					if (digits.contains(res)) {
						good = false;
						break;
					} else {
						digits.add(res);
					}
				}
				if (good) {
					best = Math.min(best, Integer.bitCount(i));
				}
			}
			System.out.println(best);
		}
	}
}
