

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		loof: for (int tc = 0; tc < T; tc++) {
			Deque<String> deque = new ArrayDeque<>();
			// 명령어
			String[] commandArr = br.readLine().split("");
			// 배열 갯수
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			// 배열
			String[] strArr = str.substring(1, str.length() - 1).split(",");
			if (str.length() == 2) {
				for (int i = 0; i < commandArr.length; i++) {
					if (commandArr[i].equals("D")) {
						bw.write("error");
						bw.newLine();
						bw.flush();
						continue loof;
					}
				}
				bw.write("[]");
				bw.newLine();
				continue loof;
			}

			// deque에 값 넣기
			for (int i = 0; i < strArr.length; i++) {
				deque.addLast(strArr[i]);
			}

			boolean reverse = true;

			for (int i = 0; i < commandArr.length; i++) {
				if (commandArr[i].equals("R")) {
					if (reverse) {
						reverse = false;
					} else {
						reverse = true;
					}
				} else {
					if (reverse) {
						if (!deque.isEmpty()) {
							deque.removeFirst();
						} else {
							bw.write("error");
							bw.newLine();
							continue loof;
						}
					} else {
						if (!deque.isEmpty()) {
							deque.removeLast();
						} else {
							bw.write("error");
							bw.newLine();
							continue loof;
						}
					}
				}
			}

			List<String> reverseList = new ArrayList<>();
			if (!reverse) {
				Iterator iter = deque.descendingIterator();
				while (iter.hasNext()) {
					reverseList.add((String) iter.next());
				}
				bw.write("[");
				for (int i = 0; i < reverseList.size(); i++) {
					if (i != reverseList.size() - 1) {
						bw.write(reverseList.get(i)+",");
					} else {
						bw.write(reverseList.get(i));
					}
				}
				bw.write("]");
				bw.newLine();
			} else {
				Iterator iter = deque.iterator();
				while (iter.hasNext()) {
					reverseList.add((String) iter.next());
				}
				bw.write("[");
				for (int i = 0; i < reverseList.size(); i++) {
					if (i != reverseList.size() - 1) {
						bw.write(reverseList.get(i)+",");
					} else {
						bw.write(reverseList.get(i));
					}
				}
				bw.write("]");
				bw.newLine();
			}
			bw.flush();
		}
	}
}
