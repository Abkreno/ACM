package MathAndUsefullAlgorthims;

import java.util.ArrayList;

public class PrimeFactorization_CheckForPrime {
	static boolean isPrime(long n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (long i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static ArrayList<Long> primeFactors(long numbers) {
		long n = numbers;
		ArrayList<Long> factors = new ArrayList<Long>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

	public static void main(String[] args) {
		System.out.println(primeFactors(6));
	}
}
