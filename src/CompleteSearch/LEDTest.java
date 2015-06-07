package CompleteSearch;

import java.util.Scanner;

public class LEDTest {
	static String[] LEDS, nums = { "YYYYYYN", "NYYNNNN", "YYNYYNY", "YYYYNNY",
			"NYYNNYY", "YNYYNYY", "YNYYYYY", "YYYNNNN", "YYYYYYY", "YYYYNYY" };

	static boolean check(int curr, int numIndex, boolean[] mask) {
		if (curr >= LEDS.length)
			return true;
		if (numIndex < 0)
			return false;
		String currNum = nums[numIndex];
		String currLED = LEDS[curr];
		for (int i = 0; i < 7; i++) {
			if (currLED.charAt(i) == 'Y'
					&& (currNum.charAt(i) == 'N' || mask[i]))
				return false;
			if (currLED.charAt(i) == 'N' && currNum.charAt(i) == 'Y') {
				mask[i] = true;
			}
		}
		return check(curr + 1, numIndex - 1, mask);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			LEDS = new String[n];
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				String st = sc.next();
				LEDS[i] = st;
			}
			boolean flag = false;
			for (int i = 9; i >= n - 1; i--) {
				if (check(0, i, new boolean[10])) {
					flag = true;
					break;
				}
			}
			System.out.println(flag ? "MATCH" : "MISMATCH");
		}
		sc.close();
	}
}
