package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FAVDICE_FavoriteDice {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			double res = 0;
			for (int k = 1; k <= n; k++)
				res += n / (double) k;
			System.out.printf("%.2f\n", res);
		}
	}
}
