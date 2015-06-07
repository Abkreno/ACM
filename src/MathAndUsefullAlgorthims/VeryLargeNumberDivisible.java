package MathAndUsefullAlgorthims;

public class VeryLargeNumberDivisible {
	/**
	 * to check if a large a number is divisble by smaller one b
	 */

	public boolean divisbleByLeftToRight(char[] a, int b) {
		int[] prefixMod = new int[a.length];
		prefixMod[0] = (a[0] - '0') % b;
		for (int i = 1; i < a.length; i++) {
			prefixMod[i] = (prefixMod[i - 1] * 10 + (a[i] - '0')) % b;
		}
		return prefixMod[a.length - 1] == 0;
	}

	public boolean divisbleByRightToLeft(char[] a, int b) {
		int[] powOfTen = new int[a.length];
		powOfTen[0] = 1;
		for (int i = 1; i < powOfTen.length; i++)
			powOfTen[i] = (powOfTen[i - 1] * 10) % b;

		int[] suffixMod = new int[a.length];
		suffixMod[a.length - 1] = (a[a.length - 1] - '0') % b;
		for (int i = a.length - 2; i >= 0; i--) {
			int p = powOfTen[a.length - 1 - i];
			suffixMod[i] = (((a[i] - '0') * p) + suffixMod[i + 1]) % b;
		}
		return suffixMod[0] == 0;
	}

	public static void main(String[] args) {
		VeryLargeNumberDivisible v = new VeryLargeNumberDivisible();
		System.out.println(v.divisbleByLeftToRight(
				"2842545891539".toCharArray(), 1009));
		System.out.println(v.divisbleByRightToLeft(
				"2842545891539".toCharArray(), 1009));
	}
}
