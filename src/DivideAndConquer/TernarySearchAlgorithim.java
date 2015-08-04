package DivideAndConquer;

public class TernarySearchAlgorithim {
	static int ternarySearchMin(int lo, int hi) {
		while (hi - lo > 3) {
			int g = lo + (hi - lo) / 3;
			int h = lo + 2 * (hi - lo) / 3;

			if (f(g) < f(h)) {
				hi = h;
			} else {
				lo = g;
			}
		}
		int ans = f(hi);
		for (int i = lo; i < hi; i++) {
			ans = Math.min(ans, f(i));
		}
		return ans;
	}

	static int f(int g) {
		return 0;
	}
}
