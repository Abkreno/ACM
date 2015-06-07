package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class WhatGoesUp {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l;
		int n = 0;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while ((l = bf.readLine()) != null && l.length() > 0) {
			nums.add(Integer.parseInt(l));
			n++;
		}
		Vector<Integer> L = new Vector<Integer>();
		int[] P_id = new int[n + 5];
		int[] P = new int[n + 5];
		int maxLen = 0;
		int last_index = 0;
		for (int i = 0; i < n; i++) {
			int curr = nums.get(i);
			int pos = Collections.binarySearch(L, curr);
			if (pos < 0)
				pos = -(pos + 1);
			if (pos >= L.size())
				L.add(curr);
			else
				L.set(pos, curr);
			P_id[pos] = i;
			P[i] = pos > 0 ? P_id[pos - 1] : -1;
			if (pos + 1 > maxLen) {
				maxLen = pos + 1;
				last_index = i;
			}
		}
		System.out.println(maxLen + "\n-");
		Stack<Integer> s = new Stack<Integer>();
		for (; P[last_index] >= 0; last_index = P[last_index])
			s.push(nums.get(last_index));
		System.out.println(nums.get(last_index));
		for (; !s.isEmpty(); s.pop())
			System.out.println(s.peek());

	}
}
