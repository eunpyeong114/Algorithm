import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static int[] budget;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 지방의 수
		N = sc.nextInt();
		budget = new int[N];
		// 총 예산
		for (int i = 0; i < N; i++) {
			budget[i] = sc.nextInt();
		}
		Arrays.sort(budget);
		M = sc.nextInt();
		System.out.println(binarySearch());
	}

	public static long binarySearch() {
		int str = 0;
		int end = budget[N - 1];
		long ans = 0;
		int mid = 0;
		while (str <= end) {
			
			mid = (str + end) / 2;
			long sum = 0;
			for (int i = 0; i < budget.length; i++) {
				if (budget[i] <= mid) {
					sum += budget[i];
				} else {
					sum += mid;
				}
			}
			if (sum == M) {
				ans = mid;
				break;
			} else if (sum < M) {
				ans = mid;
				str = mid + 1;
			} else if (sum > M) {
				end = mid - 1;
			}
		}
		return ans;
	}
}