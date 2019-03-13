package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class BJ1260 {
	static int N, M, V ;
	static int MAX_SIZE = 10010;
	static boolean[][] adjacent = new boolean[MAX_SIZE][MAX_SIZE];
	static boolean[] visited = new boolean[MAX_SIZE];
	static Queue<Integer> intQue = new LinkedList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;
 
	public static void main(String argv[]) throws Exception {

		tokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		V = Integer.parseInt(tokenizer.nextToken());

		for (int forIndex = 0; forIndex < M; forIndex++) {
			int from = 0, to = 0;
			tokenizer = new StringTokenizer(br.readLine());
			from = Integer.parseInt(tokenizer.nextToken());
			to = Integer.parseInt(tokenizer.nextToken());

			adjacent[from][to] = true;
			adjacent[to][from] = true;
		}

		visited[V] = true;
		DFS(V);
		bw.newLine();
		Arrays.fill(visited, false);
		BFS(V);
		bw.flush();
	}

	static void DFS(int insIndex) throws Exception{
		bw.write(insIndex + " ");

		for (int forIndex = 1; forIndex <= N; forIndex++)
			if (adjacent[insIndex][forIndex] && !visited[forIndex]) {
				visited[forIndex] = true;
				DFS(forIndex);
			}
	}

	static void BFS(int insIndex) throws Exception{
		intQue.offer(insIndex);
		visited[insIndex] = true;

		while (!intQue.isEmpty()) {
			insIndex = intQue.poll();

			bw.write(insIndex + " ");

			for (int forIndex = 1; forIndex <= N; forIndex++)
				if (adjacent[insIndex][forIndex] && !visited[forIndex]) {
					visited[forIndex] = true;
					intQue.offer(forIndex);
				}
		}
	}
}