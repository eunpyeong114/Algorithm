
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			// 재료 번호
			int[] gredients = new int[N + 1];
			// 재료 번호 할당
			for (int i = 1; i <= N; i++) {
				gredients[i] = i;
			}
			// 시너지 배열
			int[][] synergys = new int[N + 1][N + 1];

			// 시너지 입력값 할당
			for (int i = 1; i < synergys.length; i++) {
				for (int j = 1; j < synergys[i].length; j++) {
					synergys[i][j] = sc.nextInt();
				}
			}

			int ans = Integer.MAX_VALUE;
			// 전체 부분집합 구하기
			for (int i = 0; i < 1 << N; i++) {
				List<Integer> list = new ArrayList<>();
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						list.add(gredients[j + 1]);
					}
				}

				// 부분집합의 원소갯수가 N/2인 경우에만 계산(=재료 갯수가 N/2일때)
				if (list.size() == N / 2) {
					// list와 다른 리스트 하나 더 만듬
					List<Integer> anotherList = new ArrayList<>();
					// List에 없는 값 anotherList에 넣기
					for (int k = 1; k <= N; k++) {
						if (!list.contains(gredients[k])) {
							anotherList.add(k);
						}
					}
					// List의 합과 anotherList의 합
					int result1 = 0;
					int result2 = 0;

					for (int k = 0; k < N / 2; k++) {
						for (int p = 0; p < N / 2; p++) {
							result1 += synergys[list.get(k)][list.get((k + p) % (N / 2))];
						}
					}

					for (int k = 0; k < N / 2; k++) {
						for (int p = 0; p < N / 2; p++) {
							result2 += synergys[anotherList.get(k)][anotherList.get((k + p) % (N / 2))];
						}
					}
					
					// List합과 anotherList합의 차이
					int result = result1 - result2;
					// 음수인 경우 양수로 바꿔주기
					if (result < 0) {
						result = -result;
					}

					if (result < ans) {
						ans = result;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
