package MathAndUsefullAlgorthims;

public class NumberOfSubSequencesDivisbleByK {
	// Explanation
	// http://stackoverflow.com/questions/24518682/count-subsequences-divisible-by-k
	static long get_count(int[] vec, int k) {
		// Initialize count array.
		int[] cnt_mod = new int[k];
		cnt_mod[0] = 1;
		int pref_sum = 0;
		// Iterate over the input sequence.
		for (int elem : vec) {
			pref_sum += elem;
			pref_sum %= k;
			cnt_mod[pref_sum]++;
		}
		// Compute the answer.
		long res = 0;
		for (int mod = 0; mod < k; mod++)
			res += (long) cnt_mod[mod] * (cnt_mod[mod] - 1) / 2;
		return res;
	}
}
