
import java.util.Scanner;

public class Solution {
	public static boolean[][] visited;
	public static String[][] maze;
	public static int ans = 0;
	public static int[] nr = { 0, 1, 0, -1 };
	public static int[] nc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스 넘버
			int T = sc.nextInt();
			// 미로 값 담을 배열
			maze = new String[16][16];
			sc.nextLine();
			// 미로에 값 담기
			for (int i = 0; i < 16; i++) {
				maze[i] = sc.nextLine().split("");
			}
			//
			visited = new boolean[16][16];
			DFS(1, 1);
			System.out.println("#" + tc + " " + ans);
			ans = 0;
		}

	}

	public static void DFS(int r, int c) {
		if (visited[r][c]) {
			return;
		}

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			if (maze[r + nr[i]][c + nc[i]].equals("3")) {
				ans = 1;
				return;
			}
		}
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			// 새로 이동할 위치
			int ar = r + nr[i];
			int ac = c + nc[i];

			if (!visited[ar][ac] && maze[ar][ac].equals("0")) {
				DFS(ar,ac);
				flag = true;
			}
		}

		if (!flag) {
			return;
		}

	}
}
