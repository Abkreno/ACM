package DataStructures;
import java.awt.Point;

public class SegmentTree2 {
	private class Node {
		int best;
		Point R, L;

		private Node() {
		}
	}

	private static Node[] tree;
	private int maxsize;
	private int height;

	private final int STARTINDEX = 0;
	private final int ENDINDEX;
	private final int ROOT = 0;

	public SegmentTree2(int size) {
		height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
		maxsize = 2 * (int) Math.pow(2, height) - 1;
		tree = new Node[maxsize];
		ENDINDEX = size - 1;
	}

	private int leftchild(int pos) {
		return 2 * pos + 1;
	}

	private int rightchild(int pos) {
		return 2 * pos + 2;
	}

	private int mid(int start, int end) {
		return (start + (end - start) / 2);
	}

	private int constructSegmentTreeUtil(int[] elements, int startIndex,
			int endIndex, int current) {
		tree[current] = new Node();
		if (startIndex == endIndex) {
			tree[current].best = 1;
			tree[current].L = tree[current].R = new Point(elements[startIndex],
					1);
			return 1;
		}
		int mid = mid(startIndex, endIndex);
		int leftChild = constructSegmentTreeUtil(elements, startIndex, mid,
				leftchild(current));
		int rightChild = constructSegmentTreeUtil(elements, mid + 1, endIndex,
				rightchild(current));
		tree[current].best = Math.max(leftChild, rightChild);
		if (tree[rightchild(current)].L.x == tree[leftchild(current)].R.x) {
			int sum = tree[rightchild(current)].L.y
					+ tree[leftchild(current)].R.y;
			tree[current].best = Math.max(tree[current].best, sum);
			tree[current].R = tree[current].L = new Point(
					tree[rightchild(current)].L.x, sum);
		} else {
			tree[current].R = (Point) tree[rightchild(current)].L.clone();
			tree[current].L = (Point) tree[leftchild(current)].R.clone();
		}
		return tree[current].best;
	}

	public void constructSegmentTree(int[] elements) {
		constructSegmentTreeUtil(elements, STARTINDEX, ENDINDEX, ROOT);
	}

	public static void main(String... arg) {
		int[] elements = { 1, 2, 2, 1 };
		SegmentTree2 segmentTree = new SegmentTree2(elements.length);
		segmentTree.constructSegmentTree(elements);
		System.out.println(tree[0].best);
	}
}