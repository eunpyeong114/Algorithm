
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
		int[] order = new int[N + 1];
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
		for(int i = 1; i<arr.length; i++) {
			Collections.sort(arr[i],Collections.reverseOrder());
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited[V] = true;
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			order[poll] = cnt++;
			for (int i : arr[poll]) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<order.length; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb);
	}
}