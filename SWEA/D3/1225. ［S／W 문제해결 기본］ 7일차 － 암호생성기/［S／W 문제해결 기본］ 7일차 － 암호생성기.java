import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int front = 0, rear = 0;
			int tc = sc.nextInt();
			// 비밀번호 배열 생성
			int[] queue = new int[9];
			// 비밀번호 배열에 값 할당
			for (int i = 0; i < 8; i++) {
				queue[++rear] = sc.nextInt();
			}
			// 비밀번호 값 빼기하면서 순회
			loof: while (true) {
				for (int i = 1; i <= 5; i++) {
					rear = (rear + 1) % 9;
					front = (front + 1) % 9;
					queue[rear] = queue[front] - i;
					// 0이하 되는 순간 중단
					if (queue[rear] <= 0) {
						queue[rear] = 0;
						break loof;
					}
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 1; i <= 8; i++) {
				System.out.printf("%d ", queue[(front + i) % 9]);
			}
			System.out.println();
		}
	}
}
