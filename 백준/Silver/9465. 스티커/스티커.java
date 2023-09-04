
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] input = new int[4][N + 1];

			for (int i = 1; i <= 2; i++) {
				for (int j = 1; j <= N; j++) {
					input[i][j] = sc.nextInt();
				}
			}

			int[][] dp = new int[4][N + 1];

			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= 2; i++) {
					if (j == 1) {
						dp[i][j] = input[i][j];
					} else if (i == 1) {
						if (j == 2) {
							dp[i][j] = dp[i + 1][j - 1] + input[i][j];
						} else {
							dp[i][j] = Math.max(dp[i + 1][j - 1] + input[i][j], dp[i + 1][j - 2] + input[i][j]);
						}
					} else if (i == 2) {
						if (j == 2) {
							dp[i][j] = dp[i - 1][j - 1] + input[i][j];
						} else {
							dp[i][j] = Math.max(dp[i - 1][j - 1] + input[i][j], dp[i - 1][j - 2] + input[i][j]);
						}
					}
				}
			}
			int ans1 = dp[1][N];
			int ans2 = dp[2][N];
			
			if (ans1 > ans2) {
				System.out.println(ans1);
			} else {
				System.out.println(ans2);
			}
		}
	}
}