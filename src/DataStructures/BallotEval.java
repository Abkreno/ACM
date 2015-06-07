package DataStructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public class BallotEval {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String line = bf.readLine();
		TreeMap<String, Double> m = new TreeMap<String, Double>();
		String l[] = line.split(" ");
		int p = Integer.parseInt(l[0]);
		int g = Integer.parseInt(l[1]);
		while (p-- > 0) {
			l = bf.readLine().split(" ");
			double per = Double.parseDouble(l[1]);
			m.put(l[0], per);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= g; ++i) {
			l = bf.readLine().split("[ ]+");
			int n = l.length;
			String op = l[n - 2];
			double value = Double.parseDouble(l[n - 1]);
			double sum = 0.0;
			for (int j = 0; j < n - 2; j += 2)
				sum += m.get(l[j]);

			boolean ok = false;
			if (op.equals("<")) {
				if (sum < value - EPS)
					ok = true;
			} else if (op.equals(">")) {
				if (sum > value + EPS)
					ok = true;
			} else if (op.equals("<=")) {
				if (sum < value + EPS)
					ok = true;
			} else if (op.equals(">=")) {
				if (sum > value - EPS)
					ok = true;
			} else if (op.equals("=")) {
				if (Math.abs(sum - value) < EPS)
					ok = true;
			}

			sb.append("Guess #" + i + " was " + (ok ? "correct" : "incorrect")
					+ ".\n");
		}
		out.print(sb);
		out.close();
		bf.close();
		System.exit(0);
	}
}
