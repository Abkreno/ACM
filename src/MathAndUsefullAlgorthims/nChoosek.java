package MathAndUsefullAlgorthims;

public class nChoosek {
	static long nCk(long n, long k) {
		if (k > n)
			return 0;
		if (k * 2 > n)
			k = n - k;
		if (k == 0)
			return 1;

		long result = n;
		for (int i = 2; i <= k; ++i) {
			result *= (n - i + 1);
			result /= i;
		}
		return result;
	}

	static long nC2(long n) {
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		long k = 2;
		return n * (n - k + 1) / k;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000000; i++) {
			if (nC2(i) != nCk(i, 2))
				System.out.println(i);
		}
	}
}
