package MathAndUsefullAlgorthims;

import java.io.IOException;

public class DivsionSum {
	/*
	 * returns (n/1) + (n/2) + (n/3) + ..... (n/m)
	 */
	static long divisionSum(long n, long m) {
		long res = 0;
		long c = n;
		long end, start;
		for (long i = 1; i <= n; i++) {
			start = (n / (i + 1)) + 1;
			end = n / i;
			if (end <= start) {
				c = end;
				break;
			}
			end = Math.min(m, end);
			if (start > m || start > end)
				continue;
			res += (end - start + 1) * i;
		}

		for (long j = 1; j <= c; j++) {
			res += (n / j);
		}
		return res;
	}

	/*
	 * returns (n/1)*1 + (n/2)*2 + (n/3)*3 + ..... (n/m)*m
	 */
	static long divisionSumWithMult(long n, long m) {
		long res = 0;
		long c = n;
		long end, start, sum;
		for (long i = 1; i <= n; i++) {
			start = (n / (i + 1)) + 1;
			end = n / i;
			if (end <= start) {
				c = end;
				break;
			}
			end = Math.min(m, end);
			if (start > m || start > end)
				continue;
			sum = sum(end);
			sum -= sum(start - 1);
			sum *= i;
			res += sum;
		}

		for (long j = 1; j <= c; j++) {
			res += (n / j) * j;
		}
		return res;
	}

	static long sum(long n) {
		return n * (n + 1) / 2;
	}

	public static void main(String[] args) throws IOException {
		long n = 10000000000000L;
		System.out.println(divisionSum(n, n));
	}
}
