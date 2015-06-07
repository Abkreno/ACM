package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxSum {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			int[] nums = new int[n];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(bf.readLine());
			}
			int maxI = 0;
			int maxJ = 0;
			int maxAns = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				int max = nums[i];
				int sumSofar = nums[i];
				int bestJ = i;
				for (int j = i + 1; j < nums.length; j++) {
					sumSofar += nums[j];
					if (sumSofar > max) {
						max = sumSofar;
						bestJ = j;
					}
				}
				if (max > maxAns) {
					maxAns = max;
					maxI = i;
					maxJ = bestJ;
				} else if (max == maxAns && (maxJ - maxI) > (bestJ - i)) {
					maxAns = max;
					maxI = i;
					maxJ = bestJ;
				}
			}
			int numOFZeros = 0;
			for (int i = maxI; i <= maxJ; i++) {
				if (nums[i] == 0)
					continue;
				System.out.print(nums[i]);
				numOFZeros++;
				if (i != maxJ)
					System.out.print(' ');
			}
			if (numOFZeros == 0)
				System.out.println(0);
			System.out.println();
		}

	}
}
