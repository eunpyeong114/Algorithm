import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정점의 갯수
		int N = sc.nextInt();
		// 간선의 갯수
		int M = sc.nextInt();

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}

		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.println(count);
		
	}

	public static void DFS(int v) {
		if (visited[v]) {
			return;
		}

		visited[v] = true;
		for (int i : graph[v]) {
			if (visited[i] == false) {
				DFS(i);
			}
		}
	}
}