import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			sc.nextLine();
			String[][] input = new String[N + 1][];
			for (int i = 1; i <= N; i++) {
				input[i] = sc.nextLine().split(" ");
			}
			System.out.printf("#%d %d\n", tc, inorder(input, 1));
		}
	}

	public static int inorder(String[][] arr, int a) {
		int result = 0;
		String operator = "";
		if (a < arr.length) {

			int pre = 0, post = 0;

			if (arr[a].length == 3) {
				pre = inorder(arr, Integer.parseInt(arr[a][2])); // L
			} else if (arr[a].length == 4) {
				post = inorder(arr, Integer.parseInt(arr[a][3])); // R
				pre = inorder(arr, Integer.parseInt(arr[a][2])); // L
			}

			if (!arr[a][1].equals(null)) {
				if ("+-/*".contains(arr[a][1])) {
					operator = arr[a][1];
				} else {
					result = Integer.parseInt(arr[a][1]);
				}
			} // V

			if (operator.equals("+")) {
				result = pre + post;
			} else if (operator.equals("-")) {
				result = pre - post;
			} else if (operator.equals("*")) {
				result = pre * post;
			} else if (operator.equals("/")) {
				result = pre / post;
			}
		}
		return result;
	}
}
