import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[i][0] = 0;
				dp[i][1] = 1;
			} else {
				dp[i][0] = dp[i - 1][1];
				dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
			}
		}
		System.out.printf("%d %d", dp[N][0], dp[N][1]);
	}
}