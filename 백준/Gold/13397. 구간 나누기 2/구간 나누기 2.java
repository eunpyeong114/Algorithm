
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static int[] arr;
	public static long sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열의 크기
		N = sc.nextInt();
		// 구간의 개수
		M = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		arr = new int[N];
		sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		int end = max - min;

		System.out.println(binarySearch(end));
	}

	public static int binarySearch(int num) {
		int str = 0;
		int end = num;
		int result = Integer.MAX_VALUE;
		while (str <= end) {
			int mid = (str + end) / 2;
			int cnt = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(arr[i]);
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				if (max - min > mid) {
					cnt++;
					max = arr[i];
					min = arr[i];
					list.clear();
					list.add(arr[i]);
					if (i == N - 1) {
						cnt++;
					}
				} else if (i == N - 1) {
					cnt++;
				}
			}
			if (cnt > M) {
				str = mid + 1;
			} else if (cnt <= M) {
				result = Math.min(result, mid);
				end = mid - 1;
			}
		}
		return result;
	}
}