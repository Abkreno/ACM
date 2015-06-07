package Ad_Hock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EasyEquation {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			String line[] = bf.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			int boundry = (int) Math.ceil(Math.sqrt(b));
			boolean found = false;
			for (int x = -1 * boundry; x <= boundry && !found; x++) {
				if (x != 0 && b % x == 0) {
					int boundry2 = b / x;
					if (boundry2 < 0)
						boundry2 *= -1;

					for (int y = 1 * boundry2; y <= boundry2 && !found; y++) {
						if (y != 0 && b % y == 0) {
							int boundry3 = b / y;
							if (boundry3 < 0)
								boundry3 *= -1;
							for (int z = -1 * boundry3; z <= boundry3 && !found; z++) {
								if (Math.pow(x, 2) + Math.pow(y, 2)
										+ Math.pow(z, 2) == c) {
									if (!(z == x && y == z) && x + y + z == a
											&& x * y * z == b) {
										if (y < x) {
											int tmp = x;
											x = y;
											y = tmp;
										}
										if (z < y) {
											int tmp = y;
											y = z;
											z = tmp;
										}
										out.println(x + " " + y + " " + z);
										found = true;
									}
								}
							}
						}
					}
				}
			}
			if (!found)
				out.println("No solution.");
		}
		out.close();
		bf.close();
	}
}