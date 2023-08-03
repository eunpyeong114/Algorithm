import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			boolean check = true;
			int num = sc.nextInt();
			// 1인 경우 제외
			if (num == 1) {
				continue;
				// 2부터 자기자신-1 까지 반복문 실행
				// 나눠서 떨어지는 수가 있으면(=소수가 아님) 반복문 중단
			} else {
				for (int j = 2; j < num; j++) {
					if (num % j == 0) {
						check = false;
						break;
					}
				}
				// 나누어 떨어지는 수가 없는 경우 +1
				if (check) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
