
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static long[] wood;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 나무의 수
		N = sc.nextInt();
		// 필요한 나무 길이
		M = sc.nextInt();
		// 나무
		wood = new long[N];

		for (int i = 0; i < N; i++) {
			wood[i] = sc.nextLong();
		}

		Arrays.sort(wood);

		System.out.println(binarySearch());
	}

	public static long binarySearch() {
		long str = 0;
		long end = wood[N - 1];
		long mid = 0;
		long ans = 0;
		while (str <= end) {
			mid = (str + end) / 2;
			long sum = 0;
			for (int i = 0; i < wood.length; i++) {
				if (wood[i] - mid > 0)
					sum += wood[i] - mid;
			}
			if (sum == M) {
				ans = mid;
				return ans;
			} else if (sum < M) {
				end = mid - 1;
			} else if (sum > M) {
				ans = mid;
				str = mid + 1;
			}
		}
		return ans;
	}
}