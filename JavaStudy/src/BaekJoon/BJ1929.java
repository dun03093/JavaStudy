package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1929 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;

	public static void main(String argv[]) throws IOException {
		tokenizer = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(tokenizer.nextToken());
		int N = Integer.parseInt(tokenizer.nextToken());
		boolean[] arr = new boolean[N + 1]; // initialize false
		arr[1] = true;
		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= N; i++) {
			if (arr[i])
				continue;
			int j = i;
			j += i;
			while (j <= N) {
				if (!arr[j])
					arr[j] = true;
				j += i;
			}
		}

		for (int i = M; i <= N; i++) {
			if (!arr[i])
				sb.append(i + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}