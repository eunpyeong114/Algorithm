import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = Math.max(N, M);
			int min = Math.min(N, M);
			
			System.out.printf("#%d ",tc);
			for(int i = 1; i<max-min+2; i++) {
				int answer = min+i;
				System.out.printf("%d ",answer);
			}
			System.out.println();
		}
	}
}
