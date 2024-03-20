import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 줄 갯수
		int cnt = sc.nextInt();
		sc.nextLine();
		// 단축키 사용여부 체크
		boolean[] keys = new boolean[91];
		// 입력 값
		loof:
		for (int i = 0; i < cnt; i++) {
			// 입력 문장
			String sentence = sc.nextLine();
			// 공백 기준으로 나누기
			String[] word = sentence.split(" ");

			for (int j = 0; j < word.length; j++) {
				// 각 단어 첫째 글자
				int startWord = word[j].charAt(0);
				if (startWord >= 97)
					startWord -= 32;
				// 키워드로 사용가능하다면
				if (!keys[startWord]) {
					// 방문 기록 남기기
					keys[startWord] = true;
					// 출력하고 중단
					word[j] = word[j].replaceFirst(String.valueOf(word[j].charAt(0)), "[" + word[j].charAt(0) + "]");
					String result = String.join(" ", word);
					System.out.println(result);
					continue loof;
				}
			}

			for (int j = 0; j < word.length; j++) {
				for (int k = 1; k < word[j].length(); k++) {
					int num = word[j].charAt(k);
					if (num >= 97)
						num -= 32;
					if (!keys[num]) {
						// 방문 기록 남기기
						keys[num] = true;
						// 출력하고 중단
						word[j] = word[j].replaceFirst(String.valueOf(word[j].charAt(k)), "[" + word[j].charAt(k) + "]");
						String result = String.join(" ", word);
						System.out.println(result);
						continue loof;
					}
				}
			}
			System.out.println(sentence);
		}
	}
}
