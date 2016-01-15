package Geomtry;

import java.awt.geom.Line2D;

public class DistanceBetweenLineSegmentAndPoint {
	public static double ptLineDistSquared(double x1, double y1, double x2,
			double y2, double px, double py) {
		// Just use the built in java Method :D
		return Line2D.ptLineDistSq(x1, y1, x2, y2, px, py);
	}

	public static double ptLineDist(double x1, double y1, double x2, double y2,
			double px, double py) {
		return Line2D.ptLineDist(x1, y1, x2, y2, px, py);
	}

	public static void main(String[] args) {
	}
}
