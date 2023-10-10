
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static int K;
	public static String[][] arr;
	public static int ans = Integer.MAX_VALUE;
	public static boolean[][][] visited;
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new String[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().split("");
		}

		visited = new boolean[N][M][K+1];

		bfs(0, 0, 0, 1);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs(int x, int y, int cnt, int res) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] { x, y, cnt, res });
		
		for(int i = 0; i<K+1; i++) {
			visited[x][y][i] = true;
		}
		
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int r = poll[0];
			int c = poll[1];
			int Wcnt = poll[2];
			int result = poll[3];

			if (r == N - 1 && c == M - 1) {
				ans = Math.min(result, ans);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				
				if (arr[nr][nc].equals("1")) {
					if (Wcnt<K && !visited[nr][nc][Wcnt]) {
						visited[nr][nc][Wcnt] = true;
						queue.add(new int[] { nr, nc, Wcnt+1, result + 1 });
					} 
				} else if (arr[nr][nc].equals("0")) {
					if (!visited[nr][nc][Wcnt]) {
						visited[nr][nc][Wcnt] = true;
						queue.add(new int[] { nr, nc, Wcnt, result + 1 });
					} 
				}
			}
		}
	}
}