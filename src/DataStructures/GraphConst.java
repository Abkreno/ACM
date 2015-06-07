package DataStructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GraphConst {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		while ((n = sc.nextInt()) != 0) {
			Integer nums[] = new Integer[n];
			int sums[] = new int[n];
			int sums2[] = new int[n];
			int sum = 0;
			boolean p = true;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				sum += nums[i];
				if (nums[i] < 0)
					p = false;
			}
			Arrays.sort(nums, new Comparator<Integer>() {
				@Override
				public int compare(Integer i, Integer j) {
					// TODO Auto-generated method stub
					return j - i;
				}

			});
			if (n == 1 && nums[0] != 0) {
				p = false;
			} else if (p && (sum % 2) == 0) {
				sums[0] = nums[0];
				sums2[0] = Math.min(nums[0], 1);
				for (int i = 1; i < n; i++) {
					sums[i] = nums[i] + sums[i - 1];
				}
				int d = 0;
				int r = 0;
				p = true;
				for (int i = 0; i < n - 1; i++) {
					d = sums[i];
					r = 0;
					for (int k = i + 1; k < n; k++) {
						r += Math.min(nums[k], i + 1);
					}
					r += (i * (i + 1));
					if (d > r) {
						p = false;
						break;
					}
				}
			} else {
				p = false;
			}
			if (p)
				System.out.printf("Possible\n");
			else
				System.out.printf("Not possible\n");
		}
		sc.close();
	}
}
