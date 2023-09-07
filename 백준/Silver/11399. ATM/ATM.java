import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N + 1];
		int ans = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int[] dp = new int[N + 1];

		for (int i = 1; i < dp.length; i++) {
			if (i == 1) {
				dp[i] = arr[i];
			} else {
				dp[i] += dp[i - 1] + arr[i];
			}
			ans += dp[i];
		}
		System.out.println(ans);
	}
}