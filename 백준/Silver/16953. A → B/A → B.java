import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");

		long A = Integer.parseInt(input[0]);
		long B = Integer.parseInt(input[1]);

		int cnt = 0;
		boolean check = true;
		while (B != A) {
			if (B % 10 == 1 && B > A) {
				B = (B - 1) / 10;
				cnt++;
			} else if (B % 2 == 0) {
				B = B / 2;
				cnt++;
			} else if (B == A) {
				break;
			} else {
				check = false;
				break;
			}
		}
		if (check) {
			bw.write(Integer.toString(cnt+1));
		} else {
			bw.write(Integer.toString(-1));
		}
		bw.flush();
		bw.close();
	}
}