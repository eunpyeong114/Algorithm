import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt() + arr[i][j - 1];
			}
		}
		
		for (int j = 1; j < arr[1].length; j++) {
			for (int i = 1; i < arr.length; i++) {
				arr[i][j] += arr[i - 1][j];
			}
		}

		for (int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int ans = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
			System.out.println(ans);
		}
	}
}