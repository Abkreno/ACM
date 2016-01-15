package DataStructures;

public class DisjointSets {
	static class Set {
		int parent; // index of parent in vector
		int rank;

		// Construct the i'th of an array of disjoint sets
		Set(int i) {
			parent = i;
			rank = 0;
		}
	}

	private Set[] forest;

	/**
	 * Construct a disjoint sets object.
	 *
	 * @param numElements
	 *            the initial number of elements--also the initial number of
	 *            disjoint sets, since every element is initially in its own
	 *            set.
	 **/
	public DisjointSets(int numElements) {
		forest = new Set[numElements];
		for (int i = 0; i < forest.length; i++) {
			forest[i] = new Set(i);
		}
	}

	public boolean merge(int i, int j) {
		int root_i = find(i);
		int root_j = find(j);
		if (root_i != root_j) {
			if (forest[root_i].rank < forest[root_j].rank)
				forest[root_i].parent = root_j;
			else if (forest[root_i].rank > forest[root_j].rank)
				forest[root_j].parent = root_i;
			else {
				forest[root_i].parent = root_j;
				forest[root_j].rank += 1;
			}
			return true;
		}
		return false;
	}

	public int find(int i) {
		if (forest[i].parent == i)
			return i;
		else {
			forest[i].parent = find(forest[i].parent);
			return forest[i].parent;
		}
	}
}