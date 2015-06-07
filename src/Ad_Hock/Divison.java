package Ad_Hock;
import java.util.Scanner;

public class Divison {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			boolean flag = false;
			for (int i = 1234; i <= 98765; i++) {

				int m = i * n;
				if (m > 98765)
					break;
				if (m <= 98765 && check(m, i)) {
					flag = true;
					if (i <= 9999)
						System.out.printf("%d / 0%d = %d\n", m, i, n);
					else
						System.out.printf("%d / %d = %d\n", m, i, n);
				}

			}
			if (!flag)
				System.out.printf("There are no solutions for %d.\n", n);
			System.out.println();
		}
		sc.close();
	}

	static boolean check(int m, int i) {
		boolean v[] = new boolean[10];
		if (m >= 9999)
			v[0] = true;
		while (m > 0) {
			int b = m % 10;
			if (v[b])
				return false;
			v[b] = true;
			m /= 10;
		}
		while (i > 0) {
			int b = i % 10;
			if (v[b])
				return false;
			v[b] = true;
			i /= 10;
		}
		return true;
	}
}
