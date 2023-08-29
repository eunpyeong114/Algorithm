
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 높이
			int H = sc.nextInt();
			// 너비
			int W = sc.nextInt();
			// 게임 맵
			char[][] map = new char[H][W];

			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
			}
			// 명령어 갯수
			int commandCnt = sc.nextInt();
			// 명령어 모음 배열
			char[] command = sc.next().toCharArray();
			// 현재 위치 찾기
			int x = 0, y = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						x = i;
						y = j;
						break;
					}
				}
			}

			// 명령 실행
			for (int i = 0; i < commandCnt; i++) {
				// 명령 U인 경우
				if (command[i] == 'U') {
					// 위칸이 평지인 경우 이동
					if (x - 1 >= 0 && map[x - 1][y] == '.') {
						// 새로운 위치에 전차 이동
						map[x - 1][y] = '^';
						// 기존 위치에 전차 대신 평지로 변경
						map[x][y] = '.';
						x -= 1;
					} else {
						// 전차 방향 바꾸기
						map[x][y] = '^';
					}
					// 명령 D인 경우
				} else if (command[i] == 'D') {
					// 아래칸이 평지인 경우 이동
					if (x + 1 < H && map[x + 1][y] == '.') {
						// 새로운 위치에 전차 이동
						map[x + 1][y] = 'v';
						// 기존 위치에 전차 대신 평지로 변경
						map[x][y] = '.';
						x += 1;
					} else {
						// 전차 방향 바꾸기
						map[x][y] = 'v';
					}
					// 명령 L인 경우
				} else if (command[i] == 'L') {
					// 왼칸이 평지인 경우
					if (y - 1 >= 0 && map[x][y - 1] == '.') {
						// 새로운 위치로 전차 이동
						map[x][y - 1] = '<';
						// 기존 위치에 전차 대신 평지로 변경
						map[x][y] = '.';
						y -= 1;
					} else {
						// 방향만 변경
						map[x][y] = '<';
					}
					// 명령 R인 경우
				} else if (command[i] == 'R') {
					// 오른쪽칸이 평지인 경우
					if (y + 1 < W && map[x][y + 1] == '.') {
						// 새로운 위치로 전차 이동
						map[x][y + 1] = '>';
						// 기존 위치에 전차 대신 평지로 변경
						map[x][y] = '.';
						y += 1;
					} else {
						// 방향만 변경
						map[x][y] = '>';
					}
					// 명령 S인 경우
				} else if (command[i] == 'S') {
					int movements = 1;
					// 전차가 오른쪽을 향하고 있는 경우
					if (map[x][y] == '>') {
						// 범위 안에서만 실행
						while (y + movements < W) {
							// 벽돌을 만나면 해당 벽돌만 없애고 평지로 변환
							if (map[x][y + movements] == '*') {
								map[x][y + movements] = '.';
								break;
							} else if (map[x][y + movements] == '#') {
								break;
							}
							movements++;
						}
						// 전차가 왼쪽을 향하고 있는 경우
					} else if (map[x][y] == '<') {
						while (y - movements >= 0) {
							if (map[x][y - movements] == '*') {
								map[x][y - movements] = '.';
								break;
							} else if (map[x][y - movements] == '#') {
								break;
							}
							movements++;
						}

						// 전차가 위쪽을 향하고 있는 경우
					} else if (map[x][y] == '^') {
						// 범위 안에서만 실행
						while (x - movements >= 0) {
							// 벽돌 만나면 없애고 평지로 변환
							if (map[x - movements][y] == '*') {
								map[x - movements][y] = '.';
								break;
							} else if (map[x - movements][y] == '#') {
								break;
							}
							movements++;
						}
						// 전차가 아래쪽을 향하고 있는 경우
					} else if (map[x][y] == 'v') {
						while (x + movements < H) {
							if (map[x + movements][y] == '*') {
								map[x + movements][y] = '.';
								break;
							} else if (map[x + movements][y] == '#') {
								break;
							}
							movements++;
						}
					}
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.printf("%s", map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
