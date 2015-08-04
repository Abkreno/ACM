package MathAndUsefullAlgorthims;

public class FastPower {
	static long mod;

	static long fastPower(long base, long exponent) {
		if (exponent == 0)
			return 1;
		long x = fastPower(base, exponent >> 1);
		x = x * x % mod;
		if ((exponent & 1) != 0)
			x = x * base % mod;
		return x;
	}
}
