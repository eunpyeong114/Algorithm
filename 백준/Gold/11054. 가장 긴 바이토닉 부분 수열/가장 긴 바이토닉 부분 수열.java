import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N + 1];

		for (int i = 1; i < input.length; i++) {
			input[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][N + 1];

		// i는 제일 큰수라 가정
		for (int i = 1; i <= N; i++) {
			// i에서 1번 인덱스로 i위치의 값보다 더 작은지 체크
			for (int j = i - 1; j >= 1; j--) {
				int leftMax = 0;
				for (int k = i; k > j; k--) {
					if (input[j] < input[k]) {
						leftMax = Math.max(leftMax, dp[i][k] + 1);
					}
				}
				dp[i][j] = leftMax;
			}
			// i번에서 N번 인덱스로 i위치의 값보다 더 작은지 체크
			for (int j = i + 1; j <= N; j++) {
				int rightMax = 0;
				for (int k = i; k < j; k++) {
					if (input[j] < input[k]) {
						rightMax = Math.max(rightMax, dp[i][k] + 1);
					}
				}
				dp[i][j] = rightMax;
			}
		}

		int[] max = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int maxLeft = 0, maxRight = 0;
			for (int j = 1; j <= N; j++) {
				if (i < j) {
					maxRight = Math.max(maxRight, dp[i][j]);
				} else if (i > j) {
					maxLeft = Math.max(maxLeft, dp[i][j]);
				}
			}
			max[i] = maxRight+maxLeft;
		}
		int maxvalue = 0;
		for(int i = 1; i<=N; i++) {
			if(maxvalue<max[i]) {
				maxvalue = max[i];
			}
		}
		System.out.println(maxvalue+1);
    }
    
}