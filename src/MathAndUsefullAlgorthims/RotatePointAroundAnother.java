package MathAndUsefullAlgorthims;

import java.awt.Point;

public class RotatePointAroundAnother {
	void rotate_point(double cx, double cy, float angle, Point p) {
		double s = Math.sin(angle);
		double c = Math.cos(angle);

		// translate point back to origin:
		p.x -= cx;
		p.y -= cy;

		// rotate point
		double xnew = p.x * c - p.y * s;
		double ynew = p.x * s + p.y * c;

		// translate point back:
		p.x = (int) (xnew + cx);
		p.y = (int) (ynew + cy);
	}

	static void rotate_counterClockWise90Degrees(int a, int b, Point p) {
		p.x -= a;
		p.y -= b;

		int xnew = p.y;
		int ynew = -p.x;
		p.x = xnew + a;
		p.y = ynew + b;
	}

	public static void main(String[] args) {
		Point p = new Point(0,1);
		rotate_counterClockWise90Degrees(0, 0, p);
		System.out.println(p);
	}
}
