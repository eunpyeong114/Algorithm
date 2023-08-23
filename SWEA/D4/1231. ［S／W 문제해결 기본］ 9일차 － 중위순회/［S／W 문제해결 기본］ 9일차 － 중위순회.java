
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			sc.nextLine();
			// 트리
			System.out.printf("#%d ", tc);
			String[] tree = new String[N + 1];
			for (int i = 1; i <= N; i++) {
				String[] input = sc.nextLine().split(" ");
				tree[Integer.parseInt(input[0])] = input[1];
			}
			inorder(tree, 1);
			System.out.println();
		}
	}

	// 중위순회 매서드
	public static void inorder(String[] arr, int a) {
		if (a < arr.length) {
			inorder(arr, a * 2); // L
			if (!arr[a].equals(null)) {
				System.out.print(arr[a]);
			} // V
			inorder(arr, a * 2 + 1); // R
		}
	}
}
