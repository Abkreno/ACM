package MathAndUsefullAlgorthims;

import java.util.Arrays;

public class NumbersAfterDecimalPoint {
	static int[] numAfterDecPoint(int a, int b, int n) {
		int res[] = new int[n + 1];
		res[0] = a / b;// first number
		a %= b;
		for (int i = 1; i < res.length; i++) {
			a *= 10;
			res[i] = a / b;
			a %= b;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(numAfterDecPoint(222, 7, 18)));
	}
}
