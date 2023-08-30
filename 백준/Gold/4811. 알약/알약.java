import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}

			long[] dp = new long[31];

			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 2;

			for (int i = 3; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					dp[i] += dp[j] * dp[i - j -1];
				}
			}
			System.out.println(dp[N]);
		}
	}
}