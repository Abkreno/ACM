package Ad_Hock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SimpleEquation {
	static boolean check(int x, int y, int z, int a, int b, int c) {
		if (Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2) == c) {
			if (x + y + z == a && x * y * z == b) {
				return true;
			}
		}
		return false;
	}

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
			int boundry = (int) Math.ceil((b + 1.0) / 2.0);
			boolean found = false;
			int xres = 0;
			int yres = 0;
			int zres = 0;
			for (int x = -1 * boundry; x <= boundry; x++) {
				if (x != 0 && b % x == 0) {
					int boundry2 = b / x;
					if (boundry2 < 0)
						boundry2 *= -1;

					for (int y = -1 * boundry2; y <= boundry2; y++) {
						if (y != 0 && y != x && b % y == 0) {
							if (b % (x * y) == 0) {
								for (int i = -1; i <= 1; i++) {
									if (i == 0)
										continue;
									int z = b / (x * y);
									z *= i;
									if (!(z == x && y == z)
											&& check(x, y, z, a, b, c)) {
										if (!found) {
											xres = x;
											yres = y;
											zres = z;
											found = true;
											if (yres < xres) {
												int tmp = xres;
												xres = yres;
												yres = tmp;
											}
											if (zres < yres) {
												int tmp = yres;
												yres = zres;
												zres = tmp;
												if (yres < xres) {
													tmp = xres;
													xres = yres;
													yres = xres;
												}
											}
										} else if (found) {
											if (x < xres) {
												xres = x;
												yres = y;
												zres = z;
											} else if (x == xres && y < yres) {
												yres = y;
												zres = z;
											}

										}
									}

								}
							}
						}
					}
				}
			}

			if (!found)
				out.println("No solution.");
			else
				out.println(xres + " " + yres + " "
						+ zres);
			
		}

		out.close();
		bf.close();
	}
}