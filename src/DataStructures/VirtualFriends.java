package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;

public class VirtualFriends {
	static int[] pset;
	static int[] friends;

	static void initSet(int N) {
		for (int i = 0; i < N; i++)
			pset[i] = i;
	}

	static int findSet(int i) {
		return (pset[i] == i) ? i : (pset[i] = findSet(pset[i]));
	}

	static boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}

	static void unionSet(int i, int j) {
		if (!isSameSet(i, j)) {
			friends[findSet(j)] += friends[findSet(i)];
			pset[findSet(i)] = findSet(j);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		friends = new int[100000 + 10];
		pset = new int[100000 + 10];
		while (t-- > 0) {
			int f = Integer.parseInt(in.readLine());
			int friendNum = 0;
			Arrays.fill(friends, 1);
			initSet(friends.length);
			Hashtable<String, Integer> set = new Hashtable<String, Integer>();
			while (f-- > 0) {
				String l[] = in.readLine().split(" ");
				int f1 = 0;
				int f2 = 0;
				if (set.containsKey(l[0])) {
					f1 = set.get(l[0]);
				} else {
					f1 = friendNum;
					set.put(l[0], friendNum++);
				}
				if (set.containsKey(l[1])) {
					f2 = set.get(l[1]);
				} else {
					f2 = friendNum;
					set.put(l[1], friendNum++);
				}
				unionSet(f1, f2);
				System.out.println(friends[findSet(f1)]);
			}
		}
	}
}