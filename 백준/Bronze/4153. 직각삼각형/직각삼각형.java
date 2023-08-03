import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 0) {
				break;
			} else {
				int a2 = a * a;
				int b2 = b * b;
				int c2 = c * c;
				if (a2 + b2 == c2 || b2 + c2 == a2 || c2 + a2 == b2) {
					str += "right ";
				} else {
					str += "wrong ";
				}
			}
		}
		String[] answer = str.split(" ");
		for (String a : answer) {
			System.out.println(a);
		}
	}
}
