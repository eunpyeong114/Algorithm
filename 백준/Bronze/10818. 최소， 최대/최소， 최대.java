import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x > max) {
				max = x;
			}
			if (x < min) {
				min = x;
			}
		}
		System.out.printf("%d %d", min, max);
	}
}
