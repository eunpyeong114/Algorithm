import java.util.Scanner;

public class Solution {
	public static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 집합 갯수
			int N = sc.nextInt();
			// 연산 갯수
			int M = sc.nextInt();

			p = new int[N + 1];
			// makeset
			for (int i = 1; i < p.length; i++) {
				p[i] = i;
			}

			String str = "";

			for (int i = 1; i <= M; i++) {
				int command = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				// 합집합으로 합치는 연산
				if (command == 0) {
					if (findset(x) != findset(y))
						union(x, y);
					// 같은 집합인지 확인하는 연산
				} else {
					if (findset(x) != findset(y)) {
						str += "0";
					} else {
						str += "1";
					}
				}
			}
			System.out.println("#" + tc + " " + str);
		}

	}

	public static int findset(int i) {
		if (p[i] != i) {
			p[i] = findset(p[i]);
		}
		return p[i];
	}

	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

}