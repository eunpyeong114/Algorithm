import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];

		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A);

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int input = sc.nextInt();
			if (binarySearch(input)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	public static boolean binarySearch(int input) {
		int str = 0;
		int end = N - 1;
		int mid = N / 2;
		while (mid >= str && mid <= end) {
			if (input == A[mid] || input == A[str] || input == A[end]) {
				return true;
			} else if (input < A[mid]) {
				end = mid - 1;
				mid = (str + end) / 2;
			} else if (input > A[mid]) {
				str = mid + 1;
				mid = (str + end) / 2;
			}
		}
		return false;
	}
}