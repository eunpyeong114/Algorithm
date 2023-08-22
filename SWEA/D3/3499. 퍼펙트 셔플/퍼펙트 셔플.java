import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 문자열 갯수
			int N = sc.nextInt();
			// 문자열 담을 배열
			String input = sc.nextLine();
			String[] str1 = sc.nextLine().split(" ");
			int length = str1.length;
			String[] str2 = new String[length / 2];

			int divPoint;
			if (length % 2 == 0) {
				divPoint = length / 2;
			} else {
				divPoint = length / 2 + 1;
			}

			for (int i = 0; i < str2.length; i++) {
				str2[i] = str1[divPoint + i];
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < str1.length; i++) {
				if (i % 2 == 0) {
					System.out.printf("%s ", str1[i/2]);
				} else {
					System.out.printf("%s ", str2[i / 2]);
				}
			}
			System.out.println();
		}
	}
}