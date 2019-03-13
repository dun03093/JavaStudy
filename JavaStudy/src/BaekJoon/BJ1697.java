package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class BJ1697 {
	static int N, K;
	static int MAX_SIZE = 100000;
	static boolean[] visited = new boolean[MAX_SIZE * 2];
	static Queue<Integer> intQue = new LinkedList<Integer>();
	static Queue<Integer> tmpQue = new LinkedList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;

	public static void main(String argv[]) throws Exception {
		int count = 0;
		tokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());
		int tmp = N;
		intQue.offer(tmp);
		visited[tmp] = true;
		while (tmp != 0 && tmp < K) {
			intQue.offer(tmp * 2);
			visited[tmp * 2] = true;
			tmp *= 2;
		}
		while (intQue.peek() != K) {
			tmp = intQue.poll();
			if (tmp + 1 <= K && !visited[tmp + 1]) {
				visited[tmp + 1] = true;
				tmpQue.offer(tmp + 1);
			}
			if (tmp - 1 >= 0 && !visited[tmp - 1]) {
				visited[tmp - 1] = true;
				tmpQue.offer(tmp - 1);
			}
			if (intQue.isEmpty()) {
				intQue.addAll(tmpQue);
				while (!tmpQue.isEmpty()) {
					tmp = tmpQue.poll();
					while (tmp != 0 && tmp < K) {
						if (!visited[tmp * 2]) {
							intQue.offer(tmp * 2);
							visited[tmp * 2] = true;
						}
						tmp *= 2;
					}
				}
				count++;
			}
		}
		bw.write(count + "");
		bw.flush();
	}
}