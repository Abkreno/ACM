package CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class queens {
	static int[] pos;
	static int INF = 1000000000;

	static int f(int i, int[] pos) {
		if (i >= 8) {
			return 0;
		}
		int call = INF;
		loop: for (int k = 0; k < 8; k++) {
			for (int s = 0; s < i; s++) {
				if (s == i)
					continue;
				if (pos[s] == k)
					continue loop;
				if (Math.abs(pos[s] - k) == Math.abs(i - s))
					continue loop;
			}
			int[] tmp = pos.clone();
			if (k == tmp[i])
				call = Math.min(call, f(i + 1, tmp));
			else {
				tmp[i] = k;
				call = Math.min(call, 1 + f(i + 1, tmp));
			}
		}
		return call;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String next;
		int c = 1;
		while (true) {
			next = bf.readLine();
			if (next==null)
				break;
			String[] line = next.split(" ");
			pos = new int[8];
			for (int i = 0; i < 8; i++) {
				int j = Integer.parseInt(line[i]);
				pos[i] = j - 1;
			}
			int ans = f(0, pos);
			out.printf("Case %d: %d\n", c, ans);
			c++;
		}
		out.close();
		bf.close();
	}
}
