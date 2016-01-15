package MathAndUsefullAlgorthims;

public class InverseMod {
	static long mul_inv(long a, long mod) {
		long mod0 = mod, t, q;
		long x0 = 0, x1 = 1;
		if (mod == 1)
			return 1;
		while (a > 1) {
			q = a / mod;
			t = mod;
			mod = a % mod;
			a = t;
			t = x0;
			x0 = x1 - q * x0;
			x1 = t;
		}
		if (x1 < 0)
			x1 += mod0;
		return x1;
	}
}
