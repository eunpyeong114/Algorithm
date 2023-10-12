import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int N;
	public static List<int[]>[][] arr;
	public static int K;
	public static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 격자 크기
		N = sc.nextInt();
		// 파이어볼 갯수
		int M = sc.nextInt();
		// 명령 횟수
		K = sc.nextInt();
		arr = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			// 행
			int r = sc.nextInt() - 1;
			// 열
			int c = sc.nextInt() - 1;
			// 질량
			int m = sc.nextInt();
			// 속력
			int s = sc.nextInt();
			// 방향
			int d = sc.nextInt();
			arr[r][c].add(new int[] { m, s, d });
		}

		fireball(0);

		int ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j].isEmpty())
					continue;
				for (int k = 0; k < arr[i][j].size(); k++) {
					ans += arr[i][j].get(k)[0];
				}
			}
		}
		System.out.println(ans);
	}

	public static void fireball(int cnt) {
		if (cnt >= K)
			return;
		// 임시 배열 생성
		List<int[]>[][] tmp = new ArrayList[N][N];
		// 임시 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = new ArrayList<>();
			}
		}

		// 임시 배열에 파이어볼이 이동한 후 위치 할당
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 해당 칸에 파이어볼이 없으면 넘어가
				if (arr[i][j].isEmpty())
					continue;
				// 있다면, 해당칸이 보유한 파이어볼 갯수만큼 반복
				for (int k = 0; k < arr[i][j].size(); k++) {
					// 질량
					int mass = arr[i][j].get(k)[0];
					// 속도
					int speed = arr[i][j].get(k)[1];
					// 방향
					int direction = arr[i][j].get(k)[2];
					// 새로운 행
					int nr = i + dr[direction] * speed;
					// 새로운 열
					int nc = j + dc[direction] * speed;

					// 0보다 작아지는 경우 N만큼 증가시키기
					// N이상이 되는 경우 N으로 나눈 나머지 값으로 감소시키기
					if (nr < 0) {
						while (nr < 0) {
							nr += N;
						}
					}
					if (nr >= N)
						nr = nr % N;
					if (nc < 0) {
						while (nc < 0) {
							nc += N;
						}
					}
					if (nc >= N)
						nc = nc % N;

					tmp[nr][nc].add(new int[] { mass, speed, direction });
				}
				arr[i][j].clear();
			}

		}

		// 파이어볼 방향
		// 파이어볼 합치기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int[] newDr = new int[] { 0, 2, 4, 6 };
				boolean sameDirection = true;
				if (tmp[i][j].size() == 0)
					continue;

				if (tmp[i][j].size() == 1) {
					arr[i][j].add(new int[] { tmp[i][j].get(0)[0], tmp[i][j].get(0)[1], tmp[i][j].get(0)[2] });
					continue;
				}

				int massSum = 0;
				int speedSum = 0;
				int compareDirection = 0;
				int fireballCnt = tmp[i][j].size();
				for (int k = 0; k < tmp[i][j].size(); k++) {
					int mass = tmp[i][j].get(k)[0];
					int speed = tmp[i][j].get(k)[1];
					int direction = tmp[i][j].get(k)[2];
					massSum += mass;
					speedSum += speed;
					// 제일 처음에 방향을 기준으로 비교해나갈 예정
					if (k == 0) {
						if (direction % 2 == 0) {
							compareDirection = 0;
						} else {
							compareDirection = 1;
						}
					}

					if (direction % 2 != compareDirection) {
						sameDirection = false;
					}
				}

				if (!sameDirection) {
					newDr = new int[] { 1, 3, 5, 7 };
				}

				if (massSum / 5 <= 0 || speedSum / fireballCnt <= 0)
					continue;

				for (int k = 0; k < 4; k++) {
					arr[i][j].add(new int[] { massSum / 5, speedSum / fireballCnt, newDr[k] });

				}
			}
		}
		// 재귀
		fireball(cnt + 1);
	}
}