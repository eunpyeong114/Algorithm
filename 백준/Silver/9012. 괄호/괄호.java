import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		out: for (int tc = 1; tc <= T; tc++) {
			Stack<Character> input = new Stack<>();
			String str = sc.next();

			for (int i = 0; i < str.length(); i++) {
				input.add(str.charAt(i));
			}

			int check = 0;
			int size = input.size();
			for (int i = 0; i < size; i++) {
				if (input.pop() == ')') {
					check++;
				} else {
					check--;
				}

				if (check < 0) {
					System.out.println("NO");
					continue out;
				}
			}

			if (check == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}