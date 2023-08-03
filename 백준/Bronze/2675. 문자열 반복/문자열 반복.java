import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numArr = new int[N];
		String[] strArr = new String[N];
		for (int i = 0; i < N; i++) {
			numArr[i] = sc.nextInt();
			strArr[i] = sc.next();
		}
		for (int i = 0; i < N; i++) {
			String[] str = strArr[i].split("");
			for (int j = 0; j < str.length; j++) {
				for (int k = 0; k < numArr[i]; k++) {
					if (j == str.length - 1 && k == numArr[i] - 1) {
						System.out.println(str[j]);
					} else {
						System.out.print(str[j]);
					}
				}
			}
		}
	}
}
