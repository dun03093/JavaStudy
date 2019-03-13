package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ1874 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Stack<Integer> stack = new Stack<>();
	static Queue<Boolean> buffer = new LinkedList<Boolean>();

	public static void main(String arg[]) throws IOException {

		int count = 1, n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			stack.push(i);
			buffer.offer(true);

			while (!stack.isEmpty() && num == stack.peek()) {
				stack.pop();
				buffer.offer(false);

				if (!stack.isEmpty() || i != n) {
					num = Integer.parseInt(br.readLine());
					count++;
				}
			}
		}
		if (!stack.isEmpty()) {
			br.skip(3 * (n - count));
			bw.write("NO");
			bw.flush();
		} else
			while (!buffer.isEmpty())
				if (buffer.poll())
					sb.append("+\n");
				else
					sb.append("-\n");
		
		bw.write(sb.toString());
		bw.flush();
	}
}