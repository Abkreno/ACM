package DataStructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class ferryLoading {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int c = Integer.parseInt(bf.readLine());
		while (c-- > 0) {
			LinkedList<Integer> right = new LinkedList<Integer>();
			LinkedList<Integer> left = new LinkedList<Integer>();
			String line[] = bf.readLine().split(" ");
			int l = Integer.parseInt(line[0]) * 100;
			int m = Integer.parseInt(line[1]);
			while (m-- > 0) {
				line = bf.readLine().split(" ");
				int curr = Integer.parseInt(line[0]);
				if (line[1].charAt(0) == 'l') {
					left.add(curr);
				} else {
					right.add(curr);
				}
			}
			int len = l;
			int res = 0;
			while (!left.isEmpty() || !right.isEmpty()) {

				while (!left.isEmpty() && len > 0) {
					if (left.peekFirst() <= len) {
						len -= left.peekFirst();
						left.removeFirst();
					} else {
						break;
					}
				}
				if (!left.isEmpty() || !right.isEmpty() || len != l) {
					res++;
				}
				len = l;
				while (!right.isEmpty() && len > 0) {
					if (right.peekFirst() <= len) {
						len -= right.peekFirst();
						right.removeFirst();
					} else {
						break;
					}
				}
				if (!left.isEmpty() || !right.isEmpty() || len != l) {
					res++;
				}
				len = l;
			}
			out.println(res);
		}
		out.close();
		bf.close();
	}
}