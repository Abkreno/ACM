package MathAndUsefullAlgorthims;

import java.awt.Point;
import java.util.Arrays;

public class IsSquare {

	static long distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	static boolean isSquare(Point[] points) {
		long[] ds = new long[6];
		int p = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				ds[p++] = distance(points[i], points[j]);
			}
		}
		Arrays.sort(ds);
		return ds[0] > 0 && ds[3] == ds[0] && ds[4] == ds[3] * 2
				&& ds[4] == ds[5];
	}

	public static void main(String[] args) {
		Point p1 = new Point(2, 6);
		Point p2 = new Point(1, 7);
		Point p3 = new Point(3, 7);
		Point p4 = new Point(2, 8);
		System.out.println(isSquare(new Point[] { p1, p4, p3, p2 }));
	}
}
