
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		long[] depth = new long[N + 1];
		long[] order = new long[N + 1];
		int cnt = 1;
		arr = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();

			arr[u].add(v);
			arr[v].add(u);
		}

		for (int i = 1; i < depth.length; i++) {
			depth[i] = -1;
		}

		for (int i = 1; i < arr.length; i++) {
			Collections.sort(arr[i]);
		}
		long dep = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		depth[V] = dep;
		visited[V] = true;
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			dep = depth[poll] + 1;
			order[poll] = cnt++;
			for (int i : arr[poll]) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
					depth[i] = dep;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		long sum = 0;

		for (int i = 1; i < depth.length; i++) {
			sum += depth[i] * order[i];
		}
		sb.append(Long.toString(sum));
		System.out.println(sb);
	}
}