import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0) {
                break;
            }

            int sum = a + b + c;
            int max = Math.max(Math.max(a, b), c);
            int elseSum = sum - max;
            if (elseSum <= max) {
                System.out.println("Invalid");
                continue;
            }

            if (a == b) {
                if (b != c) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Equilateral");
                }
            } else if (a == c) {
                System.out.println("Isosceles");
            } else if (b == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}