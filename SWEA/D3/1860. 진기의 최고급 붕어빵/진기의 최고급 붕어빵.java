
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 손님 수
			int N = sc.nextInt();
			// 만드는데 소요되는 시간
			int M = sc.nextInt();
			// 붕어빵 수
			int K = sc.nextInt();
			// 도착시간 배열
			int[] ETA = new int[N];

			for (int i = 0; i < N; i++) {
				ETA[i] = sc.nextInt();
			}
			// 도착시간 배열 정렬
			for (int i = 1; i < N; i++) {
				int key = ETA[i];
				int j;
				for (j = i - 1; j >= 0 && key < ETA[j]; j--) {
					ETA[j + 1] = ETA[j];
				}
				ETA[j + 1] = key;
			}
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				// 해당 시점에 남은 붕어빵 갯수
				long produced = (ETA[i] / M) * K - i;
				if (produced < 1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.printf("#%d Possible\n", tc);
			} else {
				System.out.printf("#%d Impossible\n", tc);
			}
		}
	}
}
