package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class BJ7576 {

	static class Dot {
		int x, y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, D = 0;
	static int[][] tomato;
	static Dot dDot[] = { new Dot(1, 0), new Dot(-1, 0), new Dot(0, -1), new Dot(0, 1) };

	static Queue<Dot> que = new LinkedList<Dot>();
	static Queue<Dot> tmpQue = new LinkedList<Dot>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;

	public static void main(String argv[]) throws Exception {

		tokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		tomato = new int[M + 2][N + 2];
		for (int index = 0; index <= M + 1; index++)
			Arrays.fill(tomato[index], -1);

		for (int row = 1; row <= M; row++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int col = 1; col <= N; col++) {
				tomato[row][col] = Integer.parseInt(tokenizer.nextToken());
				if (tomato[row][col] == 1)
					que.offer(new Dot(row, col));
			}
		}
		BFS();
		if (Check())
			bw.write(Integer.toString(D - 1));
		else
			bw.write("-1");
		bw.flush();

	}

	static boolean Check() {
		for (int row = 1; row <= M; row++) {
			for (int col = 1; col <= N; col++) {
				if (tomato[row][col] == 0)
					return false;
			}
		}
		return true;
	}

	static void BFS() {
		while (!que.isEmpty()) {
			while (!que.isEmpty()) {

				Dot loc = que.peek();
				for (int d = 0; d < 4; d++) {
					if (tomato[loc.x + dDot[d].x][loc.y + dDot[d].y] == 0) {
						tomato[loc.x + dDot[d].x][loc.y + dDot[d].y] = 1;
						tmpQue.offer(new Dot(loc.x + dDot[d].x, loc.y + dDot[d].y));
					}
				}
				que.poll();

			}
			D++;
			while (!tmpQue.isEmpty()) {
				que.offer(tmpQue.poll());
			}
		}

	}
}