
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
			// 방문기록 남기기 위한 boolean 배열
			visited = new boolean[16][16];
			// dfs 시작
			DFS(1, 1);
			System.out.println("#" + tc + " " + ans);
			ans = 0;
		}

	}

	public static void DFS(int r, int c) {
		// 방문한 기록이 있다면 return
		if (visited[r][c]) {
			return;
		}
		// 현재 위치 방문기록 true해주기
		visited[r][c] = true;
		// 현재 위치 기준으로 4방향에 3이 존재하는 경우 도착한 것! => return
		for (int i = 0; i < 4; i++) {
			if (maze[r + nr[i]][c + nc[i]].equals("3")) {
				ans = 1;
				return;
			}
		}
		// 4방향 탐색을 했지만 이동할 수 있는 경로가 없는 경우 체크를 위해서
		boolean flag = false;
		// 4방향 탐색
		for (int i = 0; i < 4; i++) {
			// 새로 이동할 위치
			int ar = r + nr[i];
			int ac = c + nc[i];
			// 새로 이동할 위치가 방문한 적도 없으면서 0일 때
			if (!visited[ar][ac] && maze[ar][ac].equals("0")) {
				// dfs함수 호출(재귀)
				DFS(ar,ac);
				// 이동할 수 있는 경로가 존재한다는 것을 표시 true
				flag = true;
			}
		}
		// 이동할 곳이 없을 때 return하고 이전 함수로 돌아가서 남은 방향 탐색
		if (!flag) {
			return;
		}

	}
}