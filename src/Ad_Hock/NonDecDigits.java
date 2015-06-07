package Ad_Hock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NonDecDigits {
	static long DP[][][];
	static int N;

	static long f(int curr, byte prev, byte[] digits) {
		if (curr >= N)
			return 1;
		if (DP[curr][(int) prev][N - curr] != -1)
			return DP[curr][prev][N - curr];
		long res = 0;
		for (byte i = prev; i <= 9; i++) {
			byte[] tmp = digits.clone();
			tmp[curr] = i;
			res = res + f(curr + 1, i, tmp);
		}
		return DP[curr][prev][N - curr] = res;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int count = 1;
		while (t-- > 0) {
			String[] l = bf.readLine().split(" ");
			N = Integer.parseInt(l[1]);
			DP = new long[N + 1][10][N + 1];
			for (int i = 0; i < DP.length; i++) {
				for (int j = 0; j < DP[i].length; j++) {
					Arrays.fill(DP[i][j], -1);
				}
			}
			byte[] digits = new byte[N];
			long res = f(0, (byte) 0, digits);
			System.out.println(count + " " + res);
			count++;
		}
	}
}
