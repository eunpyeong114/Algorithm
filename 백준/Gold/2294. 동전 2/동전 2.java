
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 동전의 종류
        int n = sc.nextInt();
        // 원하는 가치
        int k = sc.nextInt();
        // 동전 배열
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        // dp
        long[] dp = new long[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 무한대로 초기화

        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        
        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
