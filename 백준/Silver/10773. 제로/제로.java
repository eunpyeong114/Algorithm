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
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input != 0) {
				stack.add(input);
			} else {
				stack.pop();
			}
		}

		for(int i = 0; i<stack.size(); i++) {
			ans+=stack.get(i);
		}
		bw.write(Integer.toString(ans));
		bw.flush();
	}
}
