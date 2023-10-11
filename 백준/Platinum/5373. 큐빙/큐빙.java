import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
	static int cnt;
	static char[][][] cube;
	static char[] colors = new char[] { 'w', 'y', 'r', 'o', 'g', 'b' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			//초기화
			cube = new char[6][3][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						cube[i][j][k] = colors[i];
					}
				}
			}
			//초기화
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				String[] tmp = str[i].split("");
				command(tmp[0],tmp[1]);
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(cube[0][j][2 - i]);
				}
				System.out.println();
			}
		}
	}



	static void method(int f, int u, int l, int d, int r, boolean dir) { 
		char[][] tmp = new char[3][3];
		char[] tmp2 = new char[3];

		if (dir) {
			for (int i = 0; i < 3; ++i) // 반시계 90도 회전
				for (int j = 0; j < 3; ++j) {
					tmp[i][j] = cube[f][2 - j][i];
				}
			//한칸씩 밀기
			for (int i = 0; i < 3; ++i)
				tmp2[i] = cube[u][i][0];
			for (int i = 0; i < 3; ++i)
				cube[u][i][0] = cube[l][0][2 - i];
			for (int i = 0; i < 3; ++i)
				cube[l][0][2 - i] = cube[d][2][i];
			for (int i = 0; i < 3; ++i)
				cube[d][2][i] = cube[r][2 - i][2];
			for (int i = 0; i < 3; ++i)
				cube[r][2 - i][2] = tmp2[i];
		} else {
			for (int i = 0; i < 3; ++i) 
				for (int j = 0; j < 3; ++j) {
					tmp[i][j] = cube[f][j][2 - i];
				}
			for (int i = 0; i < 3; ++i) 
				tmp2[i] = cube[u][i][0];
			for (int i = 0; i < 3; ++i) 
				cube[u][i][0] = cube[r][2 - i][2];
			for (int i = 0; i < 3; ++i)
				cube[r][2 - i][2] = cube[d][2][i];
			for (int i = 0; i < 3; ++i)
				cube[d][2][i] = cube[l][0][2 - i];
			for (int i = 0; i < 3; ++i)
				cube[l][0][2 - i] = tmp2[i];
		}
		cube[f] = tmp;// 값 넣기
	}

	static void command(String s,String dir) {
		boolean flag = true;
		if(dir.equals("-")) {
			flag = false;
		}

		switch (s) {
		case "U":
			method(U, L, F, R, B, flag);
			break;
		case "D":
			method(D, B, R, F, L, flag);
			break;
		case "F":
			method(F, U, L, D, R, flag);
			break;
		case "B":
			method(B, R, D, L, U, flag);
			break;
		case "L":
			method(L, F, U, B, D, flag);
			break;
		case "R":
			method(R, D, B, U, F, flag);
			break;
		}

	}
}