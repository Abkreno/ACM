package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MaxSum2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			LinkedList<Integer> nums = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				int curr = Integer.parseInt(bf.readLine());
				if (curr == 0)
					continue;
				nums.add(curr);
			}
			if (nums.size() == 0)
				System.out.print(0);
			for (int i = 0; i < nums.size(); i++) {
				System.out.print(nums.get(i));
				if (i != nums.size() - 1)
					System.out.print(' ');
			}
			System.out.println();
		}
		System.out.print(0);
	}
}
