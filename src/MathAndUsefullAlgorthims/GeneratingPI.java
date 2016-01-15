package MathAndUsefullAlgorthims;

public class GeneratingPI {
	static float gen_pi(int n) {
		// Loop checks if n (precision) = 1, if so then just return 1.
		if (n != 1) {

			// Main part of the gen_pi function, this is the code version of my
			// equation
			float pi = 0;
			for (float i = 1; i <= n; i++) {
				pi = pi + (-1 * pow_index(-1, (int) i) * (1 / (2 * i - 1)));
			}
			pi = 4 * pi;

			// Return value of pi.
			return pi;

			// As explained above, if n=1, then just return 1
		} else {
			return 1;
		}
	}

	// My 'raise number to index' function, simple stuff and works perfect. :D
	static float pow_index(float base, int index) {
		float answer = 1;
		for (int i = 1; i <= index; i++) {
			answer = answer * base;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println();
	}
}
