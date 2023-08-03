import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int sum = A * B * C;
		int[] numCount = new int[10];
		String[] strCount = Integer.toString(sum).split("");
		for (int i = 0; i < strCount.length; i++) {
			numCount[Integer.parseInt(strCount[i])] += 1;
		}
		for(int i = 0 ; i<numCount.length;i++) {
			System.out.println(numCount[i]);
		}
	}
}
