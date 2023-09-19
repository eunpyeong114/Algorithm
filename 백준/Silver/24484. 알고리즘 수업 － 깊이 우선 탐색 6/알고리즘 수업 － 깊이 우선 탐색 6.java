import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static int cnt = 0;
	public static long[] depth;
	public static long[] order;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		String[] firstInput = br.readLine().split(" ");
		// 정점의 갯수
		int N = Integer.parseInt(firstInput[0]);
		// 간선의 갯수
		int M = Integer.parseInt(firstInput[1]);
		// 시작 정점
		int R = Integer.parseInt(firstInput[2]);

		// 인접리스트
		graph = new ArrayList[N + 1];

		// 방문 기록
		visited = new boolean[N + 1];

		// 깊이
		depth = new long[N + 1];

		// 방문 순서
		order = new long[N + 1];

		for (int i = 1; i < depth.length; i++) {
			depth[i] = -1;
		}
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= M; i++) {
			String[] otherInput = br.readLine().split(" ");
			int u = Integer.parseInt(otherInput[0]);
			int v = Integer.parseInt(otherInput[1]);
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i < graph.length; i++) {
			Collections.sort(graph[i],Collections.reverseOrder());
		}

		DFS(R, -1);
		long sum = 0;
		for (int i = 1; i < depth.length; i++) {
			sum += order[i] * depth[i];
		}
		bw.write(Long.toString(sum));
		bw.flush();
	}

	public static void DFS(int v, int dep) throws IOException {
		if (visited[v]) {
			return;
		}
		cnt++;
		dep++;
		visited[v] = true;
		order[v] = cnt;
		depth[v] = dep;
		for (int i : graph[v]) {
			if (!visited[i]) {
				DFS(i, dep);
			}
		}
	}
}