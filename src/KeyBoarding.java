import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KeyBoarding {
	static int minDist[][][] = new int[50][50][55];
	static int offset = 42;
	static int INF = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int r, c;
		String line, l[];
		while ((line = bf.readLine()) != null && line.length() > 0) {
			for (int i = 0; i < minDist.length; i++) {
				for (int j = 0; j < minDist.length; j++) {
					Arrays.fill(minDist[i][j], INF);
				}
			}
			l = line.split(" ");
			r = Integer.parseInt(l[0]);
			c = Integer.parseInt(l[1]);

		}
	}
}
