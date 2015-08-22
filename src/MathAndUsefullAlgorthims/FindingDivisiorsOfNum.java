package MathAndUsefullAlgorthims;

import java.util.ArrayList;

public class FindingDivisiorsOfNum {
	static ArrayList<Long> findDivisors(long n) {
		ArrayList<Long> res = new ArrayList<>();
		for (long i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				res.add(i);
			}
			if (n % i == 0 && n / i != i) {
				res.add(n / i);
			}
		}
		// Collections.sort(res);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findDivisors(10000000000000000L));
	}
}
