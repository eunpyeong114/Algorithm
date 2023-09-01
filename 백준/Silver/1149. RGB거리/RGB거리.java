import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] house = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				house[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[N + 1][3];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1) {
					dp[i][j] = house[i][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3])+house[i][j];
				}
			}
		}
		System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));
	}
}