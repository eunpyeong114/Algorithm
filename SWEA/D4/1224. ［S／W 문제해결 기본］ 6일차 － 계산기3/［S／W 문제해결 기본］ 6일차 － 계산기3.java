
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> priority = new HashMap<>();
		priority.put("*", 2);
		priority.put("/", 2);
		priority.put("+", 1);
		priority.put("-", 1);
		priority.put("(", 0);

		for (int tc = 1; tc <= 10; tc++) {
			int top = -1;
			int length = sc.nextInt();
			String[] input = sc.next().split("");

			// 연산자 담을 stack
			String[] operator = new String[length];
			// 후위 표기식 담을 변수
			String numbers = "";

			// 후위 표기식으로 변환
			for (int i = 0; i < input.length; i++) {
				// 피연산자인 경우
				if ("1234567890".contains(input[i])) {
					// numbers에 담기
					numbers += input[i];
					// 연산자인 경우
				} else {
					// operator 배열에 값이 없는 경우이거나 ( 가 들어오는 경우
					if (top == -1 || input[i].equals("(")) {
						// operator 배열에 값 담아주기
						operator[++top] = input[i];
						// 닫힌 괄호가 들어오는 경우
					} else if (input[i].equals(")")) {
						// 열린 괄호를 만날때까지 없애고, numbers에 없앤 값 담기
						while (!operator[top].equals("(")) {
							numbers += operator[top--];
						}
						top--;
						// 그 외의 경우(괄호 외 연산자가 들어오는 경우)
					} else {
						// 현재 들어온 연산자의 우선순위
						int push = priority.get(input[i]);
						// top에 위치한 연산자의 우선순위
						int exist = priority.get(operator[top]);
						// 현재 들어오려는 연산자의 우선순위가 더 큰 경우
						if (push > exist) {
							// operator에 값 담기
							operator[++top] = input[i];
							// 현재 들어오려는 연산자의 우선순위가 같거나 더 작은 경우
						} else {
							// 우선순위가 커질때까지 top에 위치한 값을 numbers 담고, top-- 반복
							while (priority.get(operator[top]) >= push) {
								// top--
								numbers +=  operator[top--];
								// numbers 문자에 추가
								// top이 0보다 작은 경우 종료
								if (top < 0) {
									break;
								}
							}
							operator[++top] = input[i];
						}
					}
				}
				

			}
			while(top>=0) {
				if(operator[top].equals("(")) {
					top--;
					continue;
				}
				numbers+=operator[top--];
			}
			// 계산
			int top2 = -1;
			// 숫자를 담을 stack
			int[] numStack = new int[numbers.length()];
			for (int i = 0; i < numbers.length(); i++) {
				// 숫자인 경우
				if ("1234567890".contains(numbers.charAt(i) + "")) {
					numStack[++top2] = numbers.charAt(i) - 48;
					// 숫자가 아닌 경우
					
				} else {
					int num2 = numStack[top2--];
					int num1 = numStack[top2--];
					int push = 0;
					if (numbers.charAt(i) == '+') {
						push = num1 + num2;
					} else if (numbers.charAt(i) == '-') {
						push = num1 - num2;
					} else if (numbers.charAt(i) == '*') {
						push = num1 * num2;
					} else {
						push = num1 / num2;
					}
					numStack[++top2] = push;
				}

			}
			System.out.printf("#%d %d\n", tc, numStack[0]);
		}
	}
}
