package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThePlayBoyChimp {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int nums[] = new int[n];
		String[] l = bf.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}

		@SuppressWarnings("unused")
		int Q = Integer.parseInt(bf.readLine());
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			int curr = Integer.parseInt(l[i]);
			int lo = 0;
			int hi = n - 1;
			int ans1 = 0, ans2 = 0;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (nums[mid] < curr) {
					lo = mid + 1;
					ans1 = mid;
				} else {
					hi = mid - 1;
				}
			}
			lo = 0;
			hi = n - 1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (nums[mid] <= curr) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
					ans2 = mid;
				}
			}
			ans1 = nums[ans1];
			ans2 = nums[ans2];
			if (ans1 >= curr)
				ans1 = -1;
			if (ans2 <= curr)
				ans2 = -1;
			System.out.println((ans1 == -1 ? 'X' : ans1 + "") + " "
					+ (ans2 == -1 ? 'X' : ans2 + ""));
		}

	}
}
