package CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class CD {
	static int[] nums;
	static int[] bestArr;
	static int max, bestCount, maxTime;
	static Stack<Integer> track;

	static int best(int curr, int time) {
		if (time > maxTime)
			return -1;
		if (curr >= nums.length) {
			if (time > max) {
				max = time;
				bestCount = 0;
				Arrays.fill(bestArr, -1);
				for (int i : track) {
					bestArr[bestCount++] = i;

				}
			} else if (time == max && track.size() > bestCount) {
				max = time;
				bestCount = 0;
				Arrays.fill(bestArr, -1);
				for (int i : track) {
					bestArr[bestCount++] = i;
				}
			}
			return time;
		}
		track.push(nums[curr]);
		int c1 = best(curr + 1, time + nums[curr]);
		track.pop();
		return Math.max(c1, best(curr + 1, time));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuffer b = new StringBuffer();
		while ((line = bf.readLine()) != null && line.length() > 0) {
			String[] s = line.split(" ");
			nums = new int[Integer.parseInt(s[1])];
			bestArr = new int[nums.length];
			track = new Stack<Integer>();
			maxTime = Integer.parseInt(s[0]);
			bestCount = 0;
			max = 0;
			for (int i = 2; i < s.length; i++) {
				nums[i - 2] = Integer.parseInt(s[i]);
			}
			int best = best(0, 0);
			for (int i = 0; i < bestArr.length && bestArr[i] != -1; i++) {
				b.append(bestArr[i] + " ");
			}
			b.append("sum:" + best + '\n');

		}
		System.out.print(b);
	}
}
