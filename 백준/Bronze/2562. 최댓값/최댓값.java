
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int maxI = 1;
		for (int i = 2; i <= 9; i++) {
			int num = sc.nextInt();
			if (max < num) {
				max = num;
				maxI = i;
			}
		}
		System.out.println(max);
		System.out.println(maxI);
	}
}
