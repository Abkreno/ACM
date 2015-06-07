package DataStructures;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AhoyPirates {
	static int totalC, barberC, otherC;
	static boolean[] pirates;
	static Point[] sTree;

	static int mid(int start, int end) {
		return (start + (end - start) / 2);
	}

	static int leftChild(int x) {
		return x * 2 + 1;
	}

	static int rightChild(int x) {
		return x * 2 + 2;
	}

	static void buildSTree(int startIndex, int endIndex, int current) {
		sTree[current] = new Point();
		if (startIndex == endIndex) {
			if (pirates[startIndex]) {
				sTree[current].x++;
			} else {
				sTree[current].y++;
			}
			return;
		}
		int mid = mid(startIndex, endIndex);
		buildSTree(startIndex, mid, leftChild(current));
		buildSTree(mid + 1, endIndex, rightChild(current));
		sTree[current].x = sTree[leftChild(current)].x
				+ sTree[rightChild(current)].x;
		sTree[current].y = sTree[leftChild(current)].y
				+ sTree[rightChild(current)].y;
	}

	static void update(int current, int s, int e, int i, int j, char c) {
		if (i > e || j < s)
			return;
		if (s == e) {
			switch (c) {
			case 'F':
				sTree[s].x += sTree[s].y;
				sTree[s].y = 0;
				return;
			case 'E':
				sTree[s].y += sTree[s].x;
				sTree[s].x = 0;
				return;
			case 'I':
				int tmp = sTree[current].x;
				sTree[s].x = sTree[s].y;
				sTree[s].y = tmp;
				return;
			}

		}
		update(leftChild(current), s, mid(s, e), i, j, c);
		update(rightChild(current), mid(s, e) + 1, e, i, j, c);
		sTree[current].x = sTree[leftChild(current)].x
				+ sTree[rightChild(current)].x;
		sTree[current].y = sTree[leftChild(current)].y
				+ sTree[rightChild(current)].y;
	}

	static int qTree(int current, int s, int e, int i, int j) {
		if (i > e || j < s)
			return 0;
		if (s >= i && e <= j)
			return sTree[current].x;
		return qTree(leftChild(current), s, mid(s, e), i, j)
				+ qTree(rightChild(current), mid(s, e) + 1, e, i, j);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while (T-- > 0) {
			totalC = barberC = otherC = 0;
			int index = 0;
			int S = Integer.parseInt(bf.readLine());
			pirates = new boolean[1024000 + 5];
			while (S-- > 0) {
				int N = Integer.parseInt(bf.readLine());
				String l = bf.readLine();
				totalC += N * l.length();
				while (N-- > 0) {
					for (int i = 0; i < l.length(); i++) {
						if (l.charAt(i) == '0') {
							pirates[index++] = false;
							barberC++;
						} else {
							pirates[index++] = true;
							otherC++;
						}
					}
				}
			}
			int size = 2 * (int) Math.pow(2,
					Math.ceil(Math.log(totalC) / Math.log(2)));
			sTree = new Point[size];
			buildSTree(0, totalC - 1, 0);
			System.out.println(Arrays.toString(sTree));
			System.out.println(qTree(0, 0, totalC - 1, 1, 4));
			update(0, 0, totalC - 1, 1, 4, 'F');
			System.out.println(qTree(0, 0, totalC - 1, 1, 4));
		}
	}
}
