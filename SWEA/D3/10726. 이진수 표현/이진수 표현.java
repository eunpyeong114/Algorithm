import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		test: for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			for (int i = 0; i < N; i++) {
				if ((M & 1 << i) == 0) {
					System.out.printf("#%d OFF\n", tc);
					continue test;
				}
			}
			System.out.printf("#%d ON\n", tc);
		}
	}
}