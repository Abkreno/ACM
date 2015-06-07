package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Packets {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		while ((l = bf.readLine().split(" ")) != null) {
			int sum = 0;
			int nums[] = new int[6];
			for (int i = 0; i < l.length; i++) {
				nums[i] = Integer.parseInt(l[i]);
				sum += nums[i];
			}
			if (sum == 0)
				break;
			int numOfBoxes = nums[5];

			numOfBoxes += nums[4];
			nums[0] -= nums[4] * 11;
			nums[0] = nums[0] > 0 ? nums[0] : 0;

			numOfBoxes += nums[3];
			int twos = nums[3] * 5; // five 2x2 left for each 4x4 used
			int temp = nums[1];
			nums[1] -= twos;
			nums[1] = nums[1] > 0 ? nums[1] : 0;
			twos -= temp;
			twos = twos < 0 ? 0 : twos;
			nums[0] -= twos * 4;
			nums[0] = nums[0] > 0 ? nums[0] : 0;

			numOfBoxes += nums[2] / 4;
			if (nums[2] % 4 != 0) {
				numOfBoxes++;
			}
			if (nums[2] % 4 == 1) {
				twos = 5;
				temp = nums[1];
				nums[1] -= twos;
				nums[1] = nums[1] > 0 ? nums[1] : 0;
				twos -= temp;
				twos = twos < 0 ? 0 : twos;
				nums[0] -= twos * 4;
				nums[0] -= 7;
				nums[0] = nums[0] > 0 ? nums[0] : 0;
			} else if (nums[2] % 4 == 2) {
				twos = 3;
				temp = nums[1];
				nums[1] -= twos;
				nums[1] = nums[1] > 0 ? nums[1] : 0;
				twos -= temp;
				twos = twos < 0 ? 0 : twos;
				nums[0] -= twos * 4;
				nums[0] -= 6;
				nums[0] = nums[0] > 0 ? nums[0] : 0;
			} else if (nums[2] % 4 == 3) {
				twos = 1;
				temp = nums[1];
				nums[1] -= twos;
				nums[1] = nums[1] > 0 ? nums[1] : 0;
				twos -= temp;
				twos = twos < 0 ? 0 : twos;
				nums[0] -= twos * 4;
				nums[0] -= 6;
				nums[0] = nums[0] > 0 ? nums[0] : 0;
			}

			numOfBoxes += nums[1] / 9;
			if (nums[1] % 9 != 0) {
				numOfBoxes++;
				int numOfOnes = 36 - 4 * (nums[1] % 9);
				nums[0] -= numOfOnes;
				nums[0] = nums[0] > 0 ? nums[0] : 0;
			}

			numOfBoxes += nums[0] / 36;
			if (nums[0] % 36 != 0) {
				numOfBoxes++;
			}
			System.out.println(numOfBoxes);
		}
	}
}
