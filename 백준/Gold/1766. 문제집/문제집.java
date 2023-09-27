import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 문제 갯수
		int N = sc.nextInt();
		// 문제 정보 갯수
		int M = sc.nextInt();

		// 인접리스트
		List<Integer>[] adjList = new ArrayList[N + 1];

		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 진입차수 배열
		int[] degree = new int[N + 1];

		// 방문 체크위한 배열
		boolean[] visited = new boolean[N + 1];

		// 위상정렬을 위한 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 인접리스트에 값 할당,
		for (int i = 0; i < M; i++) {
			int stNode = sc.nextInt();
			int edNode = sc.nextInt();
			adjList[stNode].add(edNode);
			degree[edNode]++;
		}

		// 진입차수가 0인 경우 queue에 삽입
		for (int i = 1; i < degree.length; i++) {
			if (degree[i] == 0) {
				pq.add(i);
				visited[i] = true;
			}
		}

		// queue의 크기가 0이 될 때까지 반복
		while (!pq.isEmpty()) {
			int poll = pq.poll();
			System.out.print(poll + " ");
			for (int a : adjList[poll]) {
				if (!visited[a]) {
					degree[a]--;
					if (degree[a] == 0) {
						pq.add(a);
						visited[a] = true;
					}
				}
			}
		}
	}
}