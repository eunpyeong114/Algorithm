import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 가로 앉을 수 있는 수
        int rowPerson = W / (M + 1);
        if (W % (M + 1) > 0) {
            rowPerson += 1;
        }

        // 세로 앉을 수 있는 수
        int columnPerson = H / (N + 1);
        if (H % (N + 1) > 0) {
            columnPerson += 1;
        }

        System.out.println(rowPerson * columnPerson);
    }
}