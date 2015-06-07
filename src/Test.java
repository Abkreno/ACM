import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[][] arr = new double[2][n];
		for (int i = 0; i < n; i++) {
			arr[0][i] = i;
			arr[1][i] = i;
		}
		for (int i = 0; i < n; i++) {
			double x = arr[0][i];
			double y = arr[1][i];
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				double x1 = arr[0][j];
				double y1 = arr[1][j];
				double dist = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
				dist = Math.sqrt(dist);
				if ((int) dist == dist)
					System.out.println("sqrt[(" + x1 + " - " + x + ")^2 + ("
							+ y1 + " - " + y + ")^2] = " + dist);
			}
		}
	}
}
