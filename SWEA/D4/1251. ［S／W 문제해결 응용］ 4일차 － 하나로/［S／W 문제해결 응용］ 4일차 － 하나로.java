import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 섬 갯수
			int N = sc.nextInt();
			// 섬들 x 좌표
			int[] X = new int[N];

			for (int i = 0; i < X.length; i++) {
				X[i] = sc.nextInt();
			}
			// 섬들 y 좌표
			int[] Y = new int[N];

			for (int i = 0; i < Y.length; i++) {
				Y[i] = sc.nextInt();
			}
			// 환경 부담 세율
			double E = sc.nextDouble();

			double[][] edges = new double[((N - 1) * N) / 2][3];

			int idx = 0;
			// 간선 배열 값 할당
			for (int i = 0; i < X.length - 1; i++) {
				for (int j = i + 1; j < Y.length; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					double x = X[i] - X[j];
					double y = Y[i] - Y[j];
					edges[idx][2] = Math.sqrt(x * x + y * y);
					idx++;
				}
			}

			// 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});
			p = new int[N];

			// makeset
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			// findset + union
			double ans = 0;
			long cnt = 0;
			for (int i = 0; i < edges.length; i++) {
				int x = findset(edges[i][0]);
				int y = findset(edges[i][1]);
				if (x != y) {
					union(x, y);
					cnt++;
					ans += edges[i][2] * edges[i][2] * E;
				}

				if (cnt == N - 1) {
					break;
				}
			}
			System.out.println("#" + tc + " " + Math.round(ans));
		}
	}

	public static int findset(double i) {
		if (p[(int) i] != i) {
			p[(int) i] = findset(p[(int) i]);
		}
		return p[(int) i];
	}

	public static void union(int x, int y) {
		p[y] = x;
	}
}
