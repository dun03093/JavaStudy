package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1764 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;
	static Queue<String> queue = new LinkedList<String>();

	public static void main(String argv[]) throws Exception {

		tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int count = 0;
		String unSeen[] = new String[N];
		String unHeard[] = new String[M];
		for (int i = 0; i < N; i++) {
			unSeen[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			unHeard[i] = br.readLine();
		}
		Arrays.sort(unSeen);
		Arrays.sort(unHeard);

		int a = 0, b = 0;
		while (a < N && b < M) {
			int tmp = unSeen[a].compareTo(unHeard[b]);
			if (tmp == 0) {
				queue.offer(unSeen[a]);

				count++;
				a++;
				b++;

			} else if (tmp < 0)
				a++;
			else
				b++;
		}
		bw.write(count + "\n");
		while (!queue.isEmpty()) {
			bw.write(queue.poll()+"\n");
		}
		bw.flush();
	}
}