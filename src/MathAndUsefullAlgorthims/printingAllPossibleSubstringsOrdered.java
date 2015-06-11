package MathAndUsefullAlgorthims;

public class printingAllPossibleSubstringsOrdered {
	public static void main(String[] args) {
		char[] word = "ABCDEFG".toCharArray();
		int n = word.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				String currword = "";
				for (int k = j; k <= j + i; k++) {
					currword += word[k];
				}
				System.out.println(currword);
			}
		}
	}
}
