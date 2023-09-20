import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] nr = { 0, 1, 0, -1 };
	public static int[] nc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] cheese = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cheese[i][j] = sc.nextInt();
			}
		}
		int max = 1;
		out: for (int day = 1; day <= 100; day++) {
			// BFS 방문기록 체크
			boolean[][] visited = new boolean[N + 2][N + 2];
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 큐를 통해 BFS
					Queue<int[]> queue = new LinkedList<>();
					// 방문한 적이 있다면 다음 반복문으로~
					if (visited[i][j]) {
						continue;
					}
					if (cheese[i][j] > day) {
						int[] add = { i, j };
						queue.add(add);
						// 방문했다는 기록 남기기
						visited[i][j] = true;
						// 큐의 원소가 없어질때까지 반복문 돌리기
						while (!queue.isEmpty()) {
							// 큐 제일 앞의 원소 삭제
							int[] poll = queue.poll();
							// 현재 위치 기준으로 4방향 탐색
							for (int k = 0; k < 4; k++) {
								int r = poll[0] + nr[k];
								int c = poll[1] + nc[k];
								if (!visited[r][c] && cheese[r][c] > day) {
									int[] reAdd = { r, c };
									queue.add(reAdd);
									visited[r][c] = true;
								}

							}
						}
						sum++;
					}
				}
			}
			if (max < sum) {
				max = sum;
			}
			if (sum == 0) {
				break out;
			}
		}
		System.out.println(max);
	}

}
