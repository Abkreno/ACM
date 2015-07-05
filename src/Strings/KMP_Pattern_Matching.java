package Strings;

import java.util.Arrays;

public class KMP_Pattern_Matching {
	static char[] txt, pat;
	static int dfa[][];
	static int M, N;

	static boolean search() {
		// simulate operation of DFA on text
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			j = dfa[txt[i] - 'a'][j];
		}
		if (j == M)
			return true; // found
		return false; // not found
	}

	static void KMP() {
		int R = 26;

		// build DFA from pattern
		dfa = new int[R][M];
		dfa[pat[0] - 'a'][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X]; // Copy mismatch cases.
			dfa[pat[j] - 'a'][j] = j + 1; // Set match case.
			X = dfa[pat[j] - 'a'][X]; // Update restart state.
		}
	}

	public static void main(String[] args) {
		txt = "abababaa".toCharArray();
		pat = "aba".toCharArray();
		M = pat.length;
		KMP();
		for (int i = 0; i < 2; i++) {
			System.out.println(Arrays.toString(dfa[i]));
		}
	}
}
