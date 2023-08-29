
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static int[] crypt = { 13, 25, 19, 61, 35, 49, 47, 59, 55, 11 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 세로 크기
			int N = sc.nextInt();
			// 가로 크기
			int M = sc.nextInt();

			int[][] input = new int[N][M];
			// 입력 값 숫자로 배열에 담기
			for (int i = 0; i < N; i++) {
				String[] inputStr = sc.next().split("");
				for (int j = 0; j < inputStr.length; j++) {
					input[i][j] = Integer.parseInt(inputStr[j]);
					
				}
			}

			int[] code = new int[9];
			// 뒤에서부터 탐색 (1이 발견될 때까지)
			out: for (int i = 0; i < input.length; i++) {
				for (int j = input[i].length - 1; j >= 0; j--) {
					// 뒤에서 1을 만나면
					if (input[i][j] == 1) {
						// 암호문 8글자 반복
						for (int p = 0; p < 8; p++) {
							int sum = 0;
							// 입력 받은 값 7자리 계산
							for (int k = 0; k < 7; k++) {
								sum += input[i][j - k] * Math.pow(2, k);
							}
							// 계산 다 한 후 다음 7자리 계산을 위해 j 값 -= 7
							j -= 7;
							// crypt 배열에서 합계에 해당하는 인덱스 번호가 해독한 암호문
							for (int k = 0; k < crypt.length; k++) {
								if(crypt[k]==sum) {
									code[8 - p] = k;
								}
							}
						}
						break out;
					}
				}
			}
			// 암호문이 맞는지 체크하기 위한 변수
			int ans = 0;
			// 맞을 경우 합을 구할 변수
			int result = 0;
			for(int i = code.length-1; i>0; i--) {
				if(i%2==1) {
					ans += code[i]*3;
				} else {
					ans+=code[i];					
				}
			}

			if(ans%10==0) {
				for(int n : code) {
					result+=n;
				}
				System.out.printf("#%d %d\n",tc,result);
			} else {
				System.out.printf("#%d 0\n",tc);
			}

		}
	}

}