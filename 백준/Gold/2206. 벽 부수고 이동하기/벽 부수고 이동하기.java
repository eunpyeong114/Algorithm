import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static String[][] arr;
	public static int[][] dist;
	public static int ans = Integer.MAX_VALUE;
	public static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new String[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().split("");
		}

		visited = new boolean[N][M][2];

		bfs(0, 0, 1, 1);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs(int x, int y, int lim, int res) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] { x, y, lim, res });
		visited[x][y][0] = true;
		visited[x][y][1] = true;
		
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int r = poll[0];
			int c = poll[1];
			int limit = poll[2];
			int result = poll[3];

			if (r == N - 1 && c == M - 1) {
				ans = Math.min(result, ans);
				return;
			}

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (limit == 1) {
					if (!visited[nr][nc][1] && arr[nr][nc].equals("1")) {
						visited[nr][nc][1] = true;
						queue.add(new int[] { nr, nc, limit - 1, result + 1 });
					} else if (!visited[nr][nc][0] && arr[nr][nc].equals("0")) {
						visited[nr][nc][0] = true;
						queue.add(new int[] { nr, nc, limit, result + 1 });
					}
				} else if (limit == 0) {
					if (!visited[nr][nc][1] && arr[nr][nc].equals("0")) {
						visited[nr][nc][1] = true;
						queue.add(new int[] { nr, nc, limit, result + 1 });
					}
				}
			}
		}
	}
}