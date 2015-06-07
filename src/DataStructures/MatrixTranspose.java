package DataStructures;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MatrixTranspose {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = bf.readLine()) != null) {
			String l[] = line.split(" ");
			int n = Integer.parseInt(l[0]);
			int m = Integer.parseInt(l[1]);
			ArrayList<ArrayList<Point>> lists = new ArrayList<ArrayList<Point>>();
			for (int i = 0; i <= m; i++) {
				lists.add(new ArrayList<Point>());
			}
			for (int i = 1; i <= n; i++) {
				l = bf.readLine().split(" ");
				int s = Integer.parseInt(l[0]);
				if (s == 0) {
					bf.readLine();
				} else {
					String currLine[] = bf.readLine().split(" ");
					for (int j = 1; j < l.length; j++) {
						int row = Integer.parseInt(l[j]);
						lists.get(row)
								.add(new Point(i, Integer
										.parseInt(currLine[j - 1])));// column,value
					}
				}
			}
			System.out.println(m + " " + n);
			for (int i = 1; i < lists.size(); i++) {
				int n2 = lists.get(i).size();
				String st = n2 + " ";
				String st2 = "";
				if (n2 == 0) {

					System.out.println(0);
					System.out.println();
				} else {
					for (int j = 0; j < n2; j++) {
						Point nn = lists.get(i).remove(0);
						st = st + nn.x + " ";
						st2 = st2 + nn.y + " ";
					}

					System.out.println(st.substring(0, st.length() - 1));
					System.out.println(st2.substring(0, st2.length() - 1));
				}
			}
		}
	}
}
