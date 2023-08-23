
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int ans = 1;
		for (int i = 0; i < K; i++) {
			ans *= (N - i);
		}

		for (int i = 0; i < K; i++) {
			ans /= (K - i);
		}
		System.out.println(ans);
	}
}
