package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

	static class Dot {
		int index, tower;

		Dot(int index, int tower) {
			this.index = index;
			this.tower = tower;
		}
	}

	static Stack<Dot> stack = new Stack<>();
	static Stack<Dot> tmpStack = new Stack<>();
	static Stack<Dot> ansStack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String argv[]) throws Exception {

		br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		int index = 1;
		if (tokenizer.hasMoreTokens()) {
			stack.push(new Dot(index, Integer.parseInt(tokenizer.nextToken())));
			tmpStack.push(stack.peek());
			bw.write("0");
		}
		while (tokenizer.hasMoreTokens()) {
			index++;
			int tower = Integer.parseInt(tokenizer.nextToken());
			while (!stack.isEmpty() && stack.peek().tower < tower)
				stack.pop();

			if (stack.isEmpty())
				bw.write(" 0");
			else
				bw.write(" " + stack.peek().index);
			stack.push(new Dot(index, tower));
		}
		bw.write("\n");
		bw.flush();
	}
}