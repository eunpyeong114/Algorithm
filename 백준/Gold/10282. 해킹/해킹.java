import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] time;
	public static List<int[]>[] adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			// 컴퓨터 갯수
			n = sc.nextInt();
			// 의존성 갯수
			int d = sc.nextInt();
			// 해킹당한 컴퓨터 번호
			int c = sc.nextInt();
			// 인접 리스트
			adjList = new ArrayList[n + 1];

			for (int i = 1; i < n + 1; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int s = sc.nextInt();
				adjList[B].add(new int[] { A, s });
			}

			// 감염에 걸리는 시간
			time = new int[n + 1];

			Arrays.fill(time, Integer.MAX_VALUE);
			dijkstra(c);
			int comCnt = 0;
			int comTime = Integer.MIN_VALUE;
			for (int i = 1; i < time.length; i++) {
				if (time[i] != Integer.MAX_VALUE) {
					comCnt++;
					if (comTime < time[i]) {
						comTime = time[i];
					}
				}
			}
			System.out.println(comCnt + " " + comTime);
		}
	}

	public static void dijkstra(int start) {
		// 방문기록 체크
		boolean[] visited = new boolean[n + 1];

		time[start] = 0;

		for (int i = 1; i < n + 1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;

			for (int j = 1; j < n + 1; j++) {
				if (!visited[j] && min > time[j]) {
					min = time[j];
					idx = j;
				}
			}
			if (idx == -1) {
				break;
			}

			visited[idx] = true;

			for (int j = 0; j < adjList[idx].size(); j++) {
				int[] curr = adjList[idx].get(j);
				// 의존관계있는 정점
				int v = curr[0];
				// 감염되는 시간
				int s = curr[1];
				// 방문하지 않았고, idx 컴퓨터를 거쳐 감염되는 시간이 더 짧은 경우
				if (!visited[v] && time[v] > time[idx] + s) {
					time[v] = time[idx] + s;
				}

			}

		}

	}
}