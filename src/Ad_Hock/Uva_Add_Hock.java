package Ad_Hock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Uva_Add_Hock {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(bf.readLine());
		int ca = 1;
		while (X-- > 0) {
			String[] line = bf.readLine().split(" ");
			int R = Integer.parseInt(line[0]);
			int C = Integer.parseInt(line[1]);
			int M = Integer.parseInt(line[2]);
			int N = Integer.parseInt(line[3]);
			int chars[] = new int[100];
			while (R-- > 0) {
				char[] c = bf.readLine().toCharArray();
				for (int i = 0; i < C; i++) {
					chars[c[i]]++;
				}
			}
			Arrays.sort(chars);
			int max = chars[99];
			int res = 0;
			for (int i = 99; i >= 0; i--) {
				if (chars[i] == 0)
					break;
				if (chars[i] == max)
					res += M * chars[i];
				else
					res += N * chars[i];
			}
			out.printf("Case %d: %d\n", ca++, res);
		}
		out.close();
		bf.close();
	}
}