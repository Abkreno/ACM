package MathAndUsefullAlgorthims;

public class LowerHigherBound {
	private static int[] primes;

	static int higherBound(int l) {
		int lo = 0;
		int hi = 664579;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (primes[mid] < l) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return hi;
	}

	static int lowerBound(int r) {
		int lo = 0;
		int hi = 664579;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (primes[mid] <= r) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
