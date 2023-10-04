import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static int min = Integer.MAX_VALUE;
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int N, M;
	public static boolean[][] visited;
	public static String[][] maze;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가로 크기
		M = sc.nextInt();
		// 세로 크기
		N = sc.nextInt();
		// 미로
		maze = new String[N][M];
		// 미로값 할당
		for (int i = 0; i < N; i++) {
			maze[i] = sc.next().split("");
		}

		dijkstra(0, 0, 0);
		System.out.println(min);
	}

	public static void dijkstra(int r, int c, int dep) {
		visited = new boolean[N][M];
		Deque<int[]> deque = new LinkedList<>();
		deque.add(new int[] { r, c, dep });

		if (visited[r][c])
			return;

		visited[r][c] = true;

		while (!deque.isEmpty()) {
			int[] poll = deque.poll();
			int pr = poll[0];
			int pc = poll[1];
			int pdep = poll[2];
			if (pr == N - 1 && pc == M - 1) {
				min = Math.min(min, pdep);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (!visited[nr][nc]) {
					if (maze[nr][nc].equals("0")) {
						visited[nr][nc] = true;
						deque.addFirst(new int[] { nr, nc, pdep });
					} else if (maze[nr][nc].equals("1")) {
						visited[nr][nc] = true;
						deque.addLast(new int[] { nr, nc, pdep + 1 });
					}
				}
			}
		}
	}
}