import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int[][] tracking = new int[n][m];

		int str = 0;
		int stc = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				tracking[i][j] = -1;
				if (map[i][j] == 2) {
					str = i;
					stc = j;
				} else if (map[i][j] == 0) {
					tracking[i][j] = 0;
				}
			}
		}

		tracking[str][stc] = 0;

		int[] dr = new int[] { 0, 1, 0, -1 };
		int[] dc = new int[] { 1, 0, -1, 0 };

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { str, stc });
		visited[str][stc] = true;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int r = poll[0];
			int c = poll[1];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;

				if (!visited[nr][nc] && map[nr][nc] == 1) {
					queue.add(new int[] { nr, nc });
					visited[nr][nc] = true;
					tracking[nr][nc] = tracking[r][c] + 1;
				} else if (!visited[nr][nc] && map[nr][nc] == 0) {
					tracking[nr][nc] = 0;
				}
			}
		}

		for (int[] a : tracking) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}