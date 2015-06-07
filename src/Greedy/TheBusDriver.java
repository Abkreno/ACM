package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheBusDriver {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String l[] = bf.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			int d = Integer.parseInt(l[1]);
			int r = Integer.parseInt(l[2]);
			if (n + d + r == 0)
				break;
			int mor[] = new int[n];
			int night[] = new int[n];
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				mor[i] = Integer.parseInt(l[i]);
			}
			l = bf.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				night[i] = Integer.parseInt(l[i]);
			}
			Arrays.sort(mor);
			Arrays.sort(night);
			long sum = 0;
			int j = n - 1;
			for (int i = 0; i < n; i++) {
				if (mor[i] + night[j] > d) {
					sum += (long) ((mor[i] + night[j] - d) * r);
				}
				j--;
			}
			System.out.println(sum);

		}
	}
}
