package Spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SOLIT_Solitaire {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long x = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				x |= (1L << (i * 8 + j));
			}
		}
		System.out.println(Long.toBinaryString(x));
	}
}
