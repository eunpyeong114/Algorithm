
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
//		int[] count = new int[10];

//		int[] sortArr = new int[N];
//		int div = 1;
//		for (int i = 0; i < 5; i++) {
//
//			for (int j = 0; j < input.length; j++) {
//				count[(input[j] / div) % 10] += 1;
//			}
//
//			for (int j = 0; j < count.length - 1; j++) {
//				count[j + 1] += count[j];
//			}
//			for (int j = input.length - 1; j >= 0; j--) {
//				sortArr[count[(input[j] / div) % 10] - 1] = input[j];
//				count[input[j]]--;
//			}
//			input = sortArr;
//			div *= 10;
//		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t : input) {
			bw.write(t + "\n");
		}
		bw.flush();
		bw.close();
	}
}
