package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolveIt {
	static double p, q, r, s, t, u;
	static final double EPS = 1e-7;

	static double solve(double x) {
		return p * Math.pow(Math.E, -x) + q * Math.sin(x) + r * Math.cos(x) + s
				* Math.tan(x) + t * x * x + u;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = bf.readLine()) != null && line.length() > 0) {
			String[] in = line.split(" ");
			double low = 0.0;
			double hi = 1.0;
			double mid = 0.0;
			p = Integer.parseInt(in[0]);
			q = Integer.parseInt(in[1]);
			r = Integer.parseInt(in[2]);
			s = Integer.parseInt(in[3]);
			t = Integer.parseInt(in[4]);
			u = Integer.parseInt(in[5]);
			@SuppressWarnings("unused")
			double ans = 0.0;
			if (solve(0) * solve(1) > 0) {
				System.out.println("No solution");
			} else {
				while (hi - low > EPS) {
					mid = (low + hi) / 2.0;
					if ((ans = solve(mid) * solve(low)) > 0.0) {
						low = mid;
					} else
						hi = mid;
				}
				System.out.println(String.format("%.4f", hi));
			}
		}
	}
}
