import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 앵무새들의 입력값 받기 위한 스택
		Stack[] words = new Stack[N];
		sc.nextLine();
		// 각 앵무새들의 입력값 스택에 할당
		for (int i = 0; i < N; i++) {
			String[] input = sc.nextLine().split(" ");
			Stack<String> inputStack = new Stack<>();
			for (int j = 0; j < input.length; j++) {
				inputStack.push(input[j]);
			}
			words[i] = inputStack;
		}
		// 받아적은 단어들 스택에 할당
		String[] record = sc.nextLine().split(" ");
		Stack<String> records = new Stack<>();
		for (int i = 0; i < record.length; i++) {
			records.push(record[i]);
		}

		for (int i = records.size() - 1; i >= 0; i--) {
			for (int j = 0; j < words.length; j++) {
				if(words[j].isEmpty()) {
					continue;
				} else if(words[j].peek().equals(records.peek())) {
					words[j].pop();
					records.pop();
					break;
				}
			}
		}
		
		if(records.size()==0) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
    }
}