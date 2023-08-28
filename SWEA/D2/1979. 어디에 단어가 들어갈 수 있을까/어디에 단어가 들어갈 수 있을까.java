
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테케 수
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 가로 세로 길이
			int N = sc.nextInt();
			// 글자 수
			int K = sc.nextInt();

			int[][] puzzle = new int[N + 1][N + 1];
			for (int i = 1; i < puzzle.length; i++) {
				for (int j = 1; j < puzzle.length; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			// 가로 세로 이동
			int[] dr = { 0, 1 };
			int[] dc = { 1, 0 };

			int ans = 0;

			for (int i = 1; i < puzzle.length; i++) {
				for (int j = 1; j < puzzle[i].length; j++) {
					// 빈칸(1)을 만난 경우
					if (puzzle[i][j] == 1) {
						// 방향별 탐색
						for (int p = 0; p < 2; p++) {
							// 이전의 자리가 0인 경우
							if (puzzle[i - dr[p]][j - dc[p]] == 0) {
								boolean flag = true;
								// k번 검증
								for (int o = 1; o <= K; o++) {
									int nr = i + dr[p] * o;
									int nc = j + dc[p] * o;
									// 범위를 벗어나는 경우
									if (nr < 0 || nr >= puzzle.length || nc < 0 || nc >= puzzle.length) {
										if (o == K) {
											break;
										} else {
											flag = false;
											break;
										}
									}
									// k번째에도 공백이 나오는 경우
									else if (o == K && puzzle[nr][nc] == 1) {
										flag = false;
										break;
									}
									// k번 이전에 검정색 나오는 경우 탈락
									else if (o < K && puzzle[nr][nc] == 0) {
										flag = false;
										break;
									}
								}
								if (flag) {
									ans++;
								}
							} else {
								continue;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}