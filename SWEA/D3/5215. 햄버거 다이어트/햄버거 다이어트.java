import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 재료 수
			int N = sc.nextInt();
			// 제한 칼로리
			int L = sc.nextInt();

			int[][] ingredients = new int[N + 1][2];

			for (int i = 0; i < N; i++) {
				// 맛 점수
				ingredients[i][0] = sc.nextInt();
				// 칼로리
				ingredients[i][1] = sc.nextInt();
			}

			int maxTaste = 0;
			for (int i = 0; i < 1 << N; i++) {
				int calSum = 0;
				int score = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						calSum += ingredients[j][1];
						if (calSum > L) {
							break;
						}
						score += ingredients[j][0];
					}
				}
				if (maxTaste < score) {
					maxTaste = score;
				}
			}
			System.out.printf("#%d %d\n",tc,maxTaste);
		}
	}
}
