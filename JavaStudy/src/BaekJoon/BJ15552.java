package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ15552 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;

	public static void main(String argv[]) throws Exception {

		int N, A;

		tokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokenizer.nextToken());

		for (int i = 0; i < N; i++) {

			tokenizer = new StringTokenizer(br.readLine());
			A = Integer.parseInt(tokenizer.nextToken());
			A += Integer.parseInt(tokenizer.nextToken());
			bw.write(A + "\n");
			;
		}
		bw.flush();
	}
}