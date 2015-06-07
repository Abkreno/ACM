package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pops {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int period, numOfYears = 0, bestStart = 0, bestCount;
		String line = "";
		int periods[] = new int[1000001];
		while ((line = bf.readLine()) != null && line.length() > 0) {
			period = Integer.parseInt(line);
			int s = 1;
			int end = period;
			int count = 0, currY;
			int index = 0;
			bestCount = 0;
			numOfYears = Integer.parseInt(bf.readLine());
			while (numOfYears-- > 0) {
				currY = Integer.parseInt(bf.readLine());
				periods[index++] = currY;
				while (currY > end) {
					s = end + 1;
					end = s + period - 1;
					count = 0;
				}
				count++;
				if (count > bestCount) {
					bestCount = count;
					bestStart = index - 1;
				}
			}
			bestStart -= bestCount;
			System.out.println(bestCount + " " + periods[bestStart + 1] + " "
					+ periods[bestStart + bestCount]);
		}
	}
}
