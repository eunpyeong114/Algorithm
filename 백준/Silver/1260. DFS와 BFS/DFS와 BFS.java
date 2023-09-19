
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
		arr = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= M; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			arr[v].add(u);
			arr[u].add(v);
		}

		for (int i = 1; i < arr.length; i++) {
			Collections.sort(arr[i]);
		}

		DFS(V);
		System.out.println();
		visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited[V] = true;
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			for (int i = 0; i < arr[poll].size(); i++) {
				if (!visited[arr[poll].get(i)]) {
					queue.add(arr[poll].get(i));
					visited[arr[poll].get(i)] = true;
				}
			}
			System.out.print(poll + " ");
		}

	}

	public static void DFS(int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;
		System.out.print(v + " ");
		for (int i : arr[v]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}
}