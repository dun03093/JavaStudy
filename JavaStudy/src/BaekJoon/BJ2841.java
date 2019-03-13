package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2841 {
	static Stack<Integer> stack[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;

	@SuppressWarnings("unchecked")
	public static void main(String argv[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tokenizer.nextToken());
		int P = Integer.parseInt(tokenizer.nextToken());
		int count = 0;
		stack = new Stack[P];

		for (int i = 0; i < P; i++)
			stack[i] = new Stack<>();

		for (int i = 0; i < N; i++) {
			int index, melody;
			tokenizer = new StringTokenizer(br.readLine());
			index = Integer.parseInt(tokenizer.nextToken());
			melody = Integer.parseInt(tokenizer.nextToken());

			while (!stack[index].isEmpty() && stack[index].peek() > melody) {
				stack[index].pop();
				count++;
			}
			if (stack[index].isEmpty()) {
				count++;
				stack[index].push(melody);
			} else if (stack[index].peek() < melody) {
				stack[index].push(melody);
				count++;
			}
		}
		bw.write(Integer.toString(count));
		bw.flush();
	}
}