package Geomtry;

public class AngleBtwPointAndXaxis {
	public static double epsilon = 1e-8;

	public static double angle(double x, double y) {
		double res = Math.atan2(y, x);
		if (res >= 0)
			return res;
		return res + Math.toRadians(360);
	}

	public static void main(String[] args) {
		System.out.println(Math.toDegrees(angle(2, 0)));
	}

}
