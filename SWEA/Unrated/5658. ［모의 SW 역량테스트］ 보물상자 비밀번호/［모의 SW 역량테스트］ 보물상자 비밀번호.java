
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			// 중복값 없애기 위해 set 정의
			Set<String> set = new HashSet<>();
			char[] inputs = new char[N + N / 4];
			int front = 0;
			int rear = N - 1;
			char[] inputStr = sc.next().toCharArray();
			for (int i = 0; i < inputStr.length; i++) {
				inputs[i] = inputStr[i];
			}
			int cnt = N / 4;
			// 시계방향으로 돌리기 (cnt번)
			for (int i = 0; i < cnt; i++) {
				char tmp = inputs[front++];
				inputs[++rear] = tmp;
				// 돌릴 때마다 4변에 존재하는 숫자값 구하기
				for (int j = 0; j < 4; j++) {
					String str = "";
					// 글자자르기
					for (int k = 0; k < cnt; k++) {
						str += inputs[front + j * cnt + k];
					}
					set.add(str);
				}
			}
			Integer[] arr = new Integer[set.size()];
			int idx = 0;
			for (String s : set) {
				arr[idx++] = Integer.parseInt(s, 16);
			}
			Arrays.sort(arr, Collections.reverseOrder());
			System.out.println("#" + tc + " " + arr[K - 1]);
		}
	}
}
