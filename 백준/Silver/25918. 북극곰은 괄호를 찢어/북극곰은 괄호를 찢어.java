
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] S = sc.next().toCharArray();

		int ans = 0;
		int cnt = 0;
		if (S.length % 2 != 0) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < S.length; i++) {
			if (S[i] == '(') {
				cnt++;
			} else {
				cnt--;
			}
			if (Math.abs(cnt) > ans) {
				ans = Math.abs(cnt);
			}
		}

		if (cnt != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
}