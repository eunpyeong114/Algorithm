import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10 ;tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			int[][] adjArr = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];
			
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adjArr[a][b] = 1;
				degree[b]++;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			// 진입차수가 0 인 것 큐에 넣기
			for (int i = 1; i < degree.length; i++) {
				if (degree[i] == 0)
					queue.add(i);
			}
			System.out.print("#"+tc+" ");
			// queue가 빌 때까지 반복
			while (!queue.isEmpty()) {
				int poll = queue.poll();
				System.out.print(poll+" ");
				// 연결된 정점의 차수 -1;
				for (int i = 1; i < adjArr.length; i++) {
					if (adjArr[poll][i] == 1) {
						degree[i]--;
						if (degree[i] == 0) {
							queue.add(i);
						}
					}
				}
			}
			System.out.println();
			
		}

	}
}