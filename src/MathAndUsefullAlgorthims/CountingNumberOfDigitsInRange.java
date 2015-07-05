package MathAndUsefullAlgorthims;

public class CountingNumberOfDigitsInRange {
	static long[] nines = new long[18];

	/** count number of occurences of "digit" in the given range **/
	static long count(long range, int i, int digit) {
		if (i == 0)
			return range >= digit ? 1 : 0;
		long pow = (long) Math.pow(10, i);
		long left = range % pow;
		long ldigit = range / pow;
		long res = 0;
		if (ldigit > digit) {
			res += pow;
		} else if (ldigit == digit) {
			res += left + 1;
		}
		res += count(left, i - 1, digit);
		res += ldigit * count(nines[i - 1], i - 1, digit);
		return res;
	}
}
