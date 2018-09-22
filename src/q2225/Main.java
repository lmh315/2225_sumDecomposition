package q2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		memo = new int[N + 1][K + 1];

		for (int i = 0; i <= N; i++) {
			memo[i][1] = 1;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				for (int k = 0; k <= j; k++) {
					memo[j][i] = (memo[j][i] + memo[k][i-1]) % 1000000000;
				}
			}
		}
		
		System.out.println(memo[N][K]);
//		System.out.println(Integer.MAX_VALUE);

	}
}
