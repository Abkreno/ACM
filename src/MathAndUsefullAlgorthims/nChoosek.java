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

	static long nC2(int n) {
		int k = 2;
		if (n < 4)
			k = n - 2;
		return n * (n - k + 1) / k;
	}

	public static void main(String[] args) {
		System.out.println(nC2(4));
		System.out.println(nCk(4, 2));
	}
}
