
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			// 1일 때
			if (str.length() != 1) {
				String[] arr = str.split(" ");
				stack.add(Integer.parseInt(arr[1]));
			} else {
				int command = Integer.parseInt(str);
				if (command == 2) {
					if (stack.size() == 0) {
						bw.write(Integer.toString(-1));
						bw.newLine();
					} else {
						bw.write(Integer.toString(stack.pop()));
						bw.newLine();
					}
				} else if (command == 3) {
					bw.write(Integer.toString(stack.size()));
					bw.newLine();
				} else if (command == 4) {
					if (stack.size() == 0) {
						bw.write(Integer.toString(1));
						bw.newLine();
					} else {
						bw.write(Integer.toString(0));;
						bw.newLine();
					}
				} else {
					if (stack.size() != 0) {
						bw.write(Integer.toString(stack.peek()));
						bw.newLine();
					} else {
						bw.write(Integer.toString(-1));
						bw.newLine();
					}
				}
			}
		}
		bw.flush();
	}
}
