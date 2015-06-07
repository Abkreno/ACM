package CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlockVoting {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int power[] = new int[25];
		int inp[] = new int[25];
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			String line[] = bf.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int sum = 0;
			for (int i = 0; i < n; i++) {
				inp[i] = Integer.parseInt(line[i + 1]);
				sum += inp[i];
				power[i]=0;
			}

			int mid = sum / 2;
			for (int j = 0; j < (1 << n); j++) {
				sum = 0;
				for (int k = 0; k < n; k++) {
					if ((j & (1 << k)) != 0) {
						sum += inp[k];
					}
				}
				if (sum > mid)
					continue;

				else {
					for (int k = 0; k < n; k++)
						if ((j & (1 << k)) == 0 && sum + inp[k] > mid)
							power[k]++;

				}

			}

			for (int j = 0; j < n; j++) {
				out.append("party " + (j + 1) + " has power index " + power[j]
						+ "\n");
			}
			out.append("\n");
		}
		System.out.print(out);

	}
}
