import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Str {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int c = 1;
		PrintWriter out = new PrintWriter(System.out);
		while (t-- > 0) {
			String l[] = bf.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			String first = l[1];

			String sec = l[2];
			boolean sameFirstChar = false;
			if ((sec.charAt(0) + "").equalsIgnoreCase(first.charAt(0) + ""))
				sameFirstChar = true;
			out.println("Case " + c + ":");
			for (int i = 0; i < n; i++) {
				boolean flag = false;
				String curr = bf.readLine();
				if (sameFirstChar) {
					for (int j = 0; j < curr.length(); j++) {
						if ((curr.charAt(j) + "").equalsIgnoreCase(first
								.charAt(0) + "")) {
							flag = true;
							break;
						}
					}
				} else {
					flag = true;
				}
				out.print((flag ? "YES" : "NO"));
				if (n - 1 > 0)
					out.println();
			}
			if (t - 1 > 0)
				out.println();
			c++;
		}
		out.close();
	}
}
