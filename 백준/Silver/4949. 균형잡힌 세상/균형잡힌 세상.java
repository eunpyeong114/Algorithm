import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		loof: while (sc.hasNext()) {
			Stack<Character> stack = new Stack<>();
			char[] charArr = sc.nextLine().toCharArray();
			if (charArr[0] == '.') {
				break loof;
			}
			for (int i = 0; i < charArr.length; i++) {
				if (charArr[i] == '[') {
					stack.add('[');
				} else if (charArr[i] == '(') {
					stack.add('(');
				} else if (charArr[i] == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						System.out.println("no");
						continue loof;
					}
				} else if (charArr[i] == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						System.out.println("no");
						continue loof;
					}
				}
			}
			if (stack.size() == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}