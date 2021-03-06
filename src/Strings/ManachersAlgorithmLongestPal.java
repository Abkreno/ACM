package Strings;

import java.util.Arrays;

/******************************************************************************
 * Compilation: javac Manacher.java Execution: java Manacher text Dependencies:
 * StdOut.java
 *
 * Computes the longest palindromic substring in linear time using Manacher's
 * algorithm.
 *
 * Credits: The code is lifted from the following excellent reference
 * http://www.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
 *
 ******************************************************************************/

public class ManachersAlgorithmLongestPal {
	private int[] p; // p[i] = length of longest palindromic substring of t,
						// centered at i
	private char[] s; // original string
	private char[] t; // transformed string

	public ManachersAlgorithmLongestPal(char[] s) {
		this.s = s;
		preprocess();
		p = new int[t.length];

		int center = 0, right = 0;
		for (int i = 1; i < t.length - 1; i++) {
			int mirror = 2 * center - i;

			if (right > i)
				p[i] = Math.min(right - i, p[mirror]);

			// attempt to expand palindrome centered at i
			while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
				p[i]++;

			// if palindrome centered at i expands past right,
			// adjust center based on expanded palindrome.
			if (i + p[i] > right) {
				center = i;
				right = i + p[i];
			}
		}

	}

	// Transform s into t.
	// For example, if s = "abba", then t = "$#a#b#b#a#@"
	// the # are interleaved to avoid even/odd-length palindromes uniformly
	// $ and @ are prepended and appended to each end to avoid bounds
	// checking
	private void preprocess() {
		t = new char[s.length * 2 + 3];
		t[0] = '$';
		t[s.length * 2 + 2] = '@';
		for (int i = 0; i < s.length; i++) {
			t[2 * i + 1] = '#';
			t[2 * i + 2] = s[i];
		}
		t[s.length * 2 + 1] = '#';
	}

	public int longestPalindromicLength() {
		int length = 0; // length of longest palindromic substring
		int center = 0; // center of longest palindromic substring
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] > length) {
				length = p[i];
				center = i;
			}
		}
		return (center - 1 + length) / 2 - (center - 1 - length) / 2;
	}

	// longest palindromic substring
	public char[] longestPalindromicSubstring() {
		int length = 0; // length of longest palindromic substring
		int center = 0; // center of longest palindromic substring
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] > length) {
				length = p[i];
				center = i;
			}
		}
		return Arrays.copyOfRange(s, (center - 1 - length) / 2,
				(center - 1 + length) / 2);
	}

	// longest palindromic substring centered at index i/2
	public char[] longestPalindromicSubstring(int i) {
		int length = p[i + 2];
		int center = i + 2;
		return Arrays.copyOfRange(s, (center - 1 - length) / 2,
				(center - 1 + length) / 2);
	}

	public static void main(String[] args) {
		char[] s = "121311".toCharArray();
		ManachersAlgorithmLongestPal manachers = new ManachersAlgorithmLongestPal(
				s);
		for (int i = 0; i < 2 * s.length; i++)
			System.out.println(i + ": "
					+ String.valueOf(manachers.longestPalindromicSubstring(i)));
		System.out.println(manachers.longestPalindromicLength());
	}
}