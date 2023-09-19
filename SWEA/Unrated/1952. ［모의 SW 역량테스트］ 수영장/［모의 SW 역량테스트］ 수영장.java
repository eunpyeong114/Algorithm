import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[] fee = new int[5];

			for (int i = 1; i < fee.length; i++) {
				fee[i] = sc.nextInt();
			}

			int[] swimmingDay = new int[13];

			for (int i = 1; i < swimmingDay.length; i++) {
				swimmingDay[i] = sc.nextInt();
			}

			int dp[] = new int[13];

			for (int i = 1; i < swimmingDay.length; i++) {
				if (i < 3) {
					dp[i] = Math.min(fee[4],
							Math.min(fee[3], Math.min(dp[i - 1] + swimmingDay[i] * fee[1], dp[i - 1] + fee[2])));
				} else {
					dp[i] = Math.min(fee[4], Math.min(dp[i - 3] + fee[3],
							Math.min(dp[i - 1] + swimmingDay[i] * fee[1], dp[i - 1] + fee[2])));
				}
			}
			System.out.println("#" + tc + " " + dp[12]);
		}
	}
}
