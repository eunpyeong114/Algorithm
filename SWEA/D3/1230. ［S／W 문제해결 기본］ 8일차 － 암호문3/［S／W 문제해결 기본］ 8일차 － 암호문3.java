import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// 원본 암호문 뭉치 속 암호문의 갯수
			int N = sc.nextInt();
			// 원본 암호문 뭉치
			LinkedList<String> cryptoList = new LinkedList<>();
			// 원본 암호문 뭉치 값 할당
			for (int i = 0; i < N; i++) {
				cryptoList.add(sc.next());
			}
			// 명령어 갯수
			int M = sc.nextInt();
			// 명령어 모음 값 할당
			for (int i = 0; i < M; i++) {
				String command = sc.next();
				// 삽입의 경우
				if(command.equals("I")) {
					// 앞에서 x 번째
					int x = sc.nextInt();
					// 암호문 바로 뒤 y개
					int y = sc.nextInt();
					// 덧붙일 암호문
					for (int j = 0; j < y; j++) {
						cryptoList.add(x+j,sc.next());
					}
					// 삭제의 경우
				} else if(command.equals("D")) {
					// 앞에서 x번째
					int x = sc.nextInt();
					// 암호문 바로 뒤 y개
					int y = sc.nextInt();
					// 암호문 제거
					for(int j = 0; j<y; j++) {
						cryptoList.remove(x);
					}
				} else if(command.equals("A")) {
					// 덧붙일 암호문 갯수
					int y = sc.nextInt();
					// 덧붙이기
					for(int j = 0; j<y; j++) {						
						cryptoList.add(sc.next());
					}
				}
			}
			// 출력
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.printf("%s ", cryptoList.get(i));
			}
			System.out.println();
		}
	}
}