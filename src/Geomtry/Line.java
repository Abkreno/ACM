package Geomtry;

import java.awt.Point;

public class Line {
	/**
	 * https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection
	 */
	/**
	 * How to know if a line is btw two points suppose we have 2 points p1 =
	 * (x1,y1) , p2 = (x2,y2) and the eq of the line is aX +bY + c = 0 , and
	 * |a|+|b| > 0 substitute with p1 in the eq to get v1 and substitute with p2
	 * in the eq to get v2 if v1*v2 < 0 then the line lies btw the 2 points else
	 * then the line lie either above or below or on one of the two points
	 */

	static boolean checkLineBtwTwoPoints(Point p1, Point p2, int a, int b, int c) {
		int x1 = p1.x;
		int y1 = p1.y;
		int x2 = p2.x;
		int y2 = p2.y;
		boolean v = x1 * a + y1 * b + c < 0;
		v ^= (x2 * a + y2 * b + c) < 0;
		return v;
	}
}
