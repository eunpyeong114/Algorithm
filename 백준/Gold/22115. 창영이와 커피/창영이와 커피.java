
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 커피의 갯수
		int N = sc.nextInt();
		// 하루 섭취 카페인의 양
		int K = sc.nextInt();
		int[] caffeine = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			caffeine[i] = sc.nextInt();
		}

		long[][] dp = new long[N + 1][K + 1];

		for (long[] a : dp) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}

		Arrays.sort(caffeine);

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j <= K; j++) {
				if (j < caffeine[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					if (j == caffeine[i]) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - caffeine[i]] + 1);
					}
				}
			}
		}
		if (K == 0) {
			System.out.println(0);
		} else if (dp[N][K] < Integer.MAX_VALUE) {
			System.out.println(dp[N][K]);
		} else {
			System.out.println(-1);
		}
	}
}
