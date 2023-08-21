
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String[][] words = new String[100][100];

			// 입력 받은 값 배열에 할당
			for (int i = 0; i < 100; i++) {
				words[i] = sc.next().split("");
			}

			// 최대 회문글자수
			int maxLength = 0;

			// 회문 검색(가로)
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					int cnt = 1;
					int sum = 0;
					// 글자수가 홀수인 경우 
					if (j - cnt >= 0 && j + cnt < 100 && words[i][j - cnt].equals(words[i][j + cnt])) {
						sum = cnt++ * 2 + 1;
						while (j - cnt >= 0 && j + cnt < 100 && words[i][j - cnt].equals(words[i][j + cnt])) {
							sum = cnt++ * 2 + 1;
						}
						if (sum > maxLength) {
							maxLength = sum;
						}
						// 글자수가 짝수인 경우
					} else if (j + cnt < 100 && words[i][j].equals(words[i][j + cnt])) {
						sum = cnt++ * 2;
						while (j - cnt + 1 >= 0 && j + cnt < 100 && words[i][j - cnt + 1].equals(words[i][j + cnt])) {
							sum = cnt++ * 2;
						}
						if (sum > maxLength) {
							maxLength = sum;
						}
					}

				}
			}

			// 회문 검색(세로)
			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					int cnt = 1;
					int sum = 0;
					// 글자수가 홀수인 경
					if (i - cnt >= 0 && i + cnt < 100 && words[i - cnt][j].equals(words[i + cnt][j])) {
						sum = cnt * 2 + 1;
						cnt++;
						while (i - cnt >= 0 && i + cnt < 100 && words[i - cnt][j].equals(words[i + cnt][j])) {
							sum = cnt++ * 2 + 1;
						}
						if (sum > maxLength) {
							maxLength = sum;
						}
						// 글자수가 짝수인 경우
					} else if (i + cnt < 100 && words[i][j].equals(words[i + cnt][j])) {
						sum = cnt++ * 2;
						while (i - cnt + 1 >= 0 && i + cnt < 100 && words[i - cnt + 1][j].equals(words[i + cnt][j])) {
							sum = cnt++ * 2;
						}
						if (sum > maxLength) {
							maxLength = sum;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, maxLength);
		}
	}
}
