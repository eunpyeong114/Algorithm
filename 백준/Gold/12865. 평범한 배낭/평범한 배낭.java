import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		long[][] dp = new long[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			int W = sc.nextInt();
			int V = sc.nextInt();
			for (int j = 1; j <= K; j++) {
				if (j >= W) {
					dp[i][j] = Math.max(dp[i-1][j - W] + V, dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.print(dp[N][K]);
    }
}