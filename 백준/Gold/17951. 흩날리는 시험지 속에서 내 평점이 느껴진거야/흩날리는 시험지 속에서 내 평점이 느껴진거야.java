import java.util.Scanner;

public class Main {
	public static int N;
	public static int K;
	public static int[] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 시험지 갯수
		N = sc.nextInt();
		// 나눌 그룹 갯수
		K = sc.nextInt();
		// 시험지 담을 배열
		paper = new int[N];
		// 내가 최대로 맞을 수 있는 점수
		int sum = 0;
		for (int i = 0; i < N; i++) {
			paper[i] = sc.nextInt();
			sum += paper[i];
		}

		System.out.println(binarySearch(sum));
	}

	// 이분탐색
	public static int binarySearch(int num) {
		int str = 0;
		int end = num;
		int result = Integer.MIN_VALUE;
		while (str <= end) {
			int mid = (str + end) / 2;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < paper.length; i++) {
				sum += paper[i];
				// 합이 초과할 때
				if (sum >= mid) {
					cnt++;
					min = Math.min(min, sum);
					sum = 0;
				}

//				// 마지막인 경우
//				else if (i == paper.length - 1) {
//					min = Math.min(min, sum);
//					cnt++;
//				}
			}

			if (cnt == K) {
				result = Math.max(result, min);
				str = mid + 1;
			} else if (cnt < K) {
				end = mid - 1;
			} else {
				str = mid + 1;
			}
		}
		
		if(result == Integer.MIN_VALUE) {
			result = 0;
		}
		return result;
	}
}