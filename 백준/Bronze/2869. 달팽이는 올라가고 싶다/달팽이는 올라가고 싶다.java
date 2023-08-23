
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long diff = A - B;
		long V = sc.nextLong();
		long divided = V - B;
		long day = divided / diff;
		if (divided % diff != 0) {
			day++;
		}

		System.out.print(day);
	}
}
