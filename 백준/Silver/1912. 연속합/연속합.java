
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N + 1];

		for (int i = 1; i < input.length; i++) {
			input[i] = sc.nextInt();
		}

		int[] dp = new int[N + 1];

		for (int i = 1; i < dp.length; i++) {
			// 해당 차례 값이 음수인 경우
			if (input[i] < 0) {
				// 하지만 누적합은 0이상인 경우
				if (dp[i - 1] + input[i] >= 0) {
					dp[i] = dp[i - 1] + input[i];
					// 누적합도 음수가 되는 경우(새로 갱신)
				} else {
					if (dp[i - 1] + input[i] < input[i]) {
						dp[i] = input[i];
					} else {
						dp[i] = dp[i - 1] + input[i];
					}
				}
				// 해당 차례 값이 양수이면서 이전 dp값이 음수인 경우
			} else if (dp[i - 1] < 0 && input[i] >= 0) {
				dp[i] = input[i];
				// 그 외
			} else {
				dp[i] = dp[i - 1] + input[i];
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 1; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}