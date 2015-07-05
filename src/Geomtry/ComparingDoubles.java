package Geomtry;

public class ComparingDoubles {
	static double eps = 1e-10;

	static int compare(double a, double b) {
		if (Math.abs(a - b) < eps)
			return 0;
		if (a - b < 0.0)
			return -1;
		return 1;
	}
}
