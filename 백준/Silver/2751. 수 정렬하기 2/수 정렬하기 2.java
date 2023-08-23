import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> input = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			input.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(input);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t : input) {
			bw.write(t + "\n");
		}
		bw.flush();
		bw.close();
	}
}
