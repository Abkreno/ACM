package CompleteSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TorDeFrance {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String l[] = bf.readLine().split(" ");
			int f = Integer.parseInt(l[0]);
			if (f == 0)
				break;
			int r = Integer.parseInt(l[1]);
			double ff[] = new double[f];
			double rr[] = new double[r];
			l = bf.readLine().split(" ");
			for (int i = 0; i < ff.length; i++) {
				ff[i] = Double.parseDouble(l[i]);
			}
			l = bf.readLine().split(" ");
			for (int i = 0; i < rr.length; i++) {
				rr[i] = Double.parseDouble(l[i]);
			}
			double div[] = new double[f * r];
			int ind = 0;
			for (int i = 0; i < ff.length; i++) {
				for (int j = 0; j < rr.length; j++) {
					div[ind++] = ff[i] / rr[j];
				}
			}
			Arrays.sort(div);
			double res = -1.0;
			for (int i = div.length - 1; i > 0; i--) {
				res = Math.max(res, div[i] / div[i - 1]);
			}
			String x = String.format("%.2f", res);
			System.out.println(x);
		}
	}
}
