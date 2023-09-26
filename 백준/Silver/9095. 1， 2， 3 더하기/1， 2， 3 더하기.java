
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력값
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			int[] memo = new int[input + 1];

			System.out.println(getMethods(memo, input));
		}
	}

	public static int getMethods(int[] arr, int input) {
		if(input<=2) {
			arr[input]= input;
		} else if(input==3) {
			arr[input] = 4;
		}
		int result = 0;
		if (arr[input] == 0) {
			arr[input] = getMethods(arr, input - 1) + getMethods(arr, input - 2) + getMethods(arr, input - 3);
			result = arr[input];
		} else {
			result = arr[input];
		}
		return result;
	}
}
