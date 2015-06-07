package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pops2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int numOfYears = 0;
		String line = "";
		int periods[] = new int[1000001];
		while ((line = bf.readLine()) != null && line.length() > 0) {
			@SuppressWarnings("unused")
			int period = Integer.parseInt(line);
			int index = 0;
			numOfYears = Integer.parseInt(bf.readLine());

			while (numOfYears-- > 0) {
				periods[index++] = Integer.parseInt(bf.readLine());
			}
		}
	}
}
