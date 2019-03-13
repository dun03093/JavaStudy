package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ9935 {
	static Stack<Character> stack = new Stack<>();
	static Stack<Character> tmpStack = new Stack<>();
	static Stack<Integer> boomStack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;

	public static void main(String argv[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c[], boom[];
		String str, boomStr;
		int index = 0;
		str = br.readLine();
		c = str.toCharArray();
		boomStr = br.readLine();
		boom = boomStr.toCharArray();

		for (int i = 0; i < c.length; i++) {
			stack.push(c[i]);
			if (c[i] == boom[0]) {
				index = 1;
				boomStack.push(1);
			} else if (c[i] == boom[index] && boomStack.peek() == index) {
				boomStack.pop();
				boomStack.push(++index);
			} else {
				boomStack.clear();
				index = 0;
			}

			if (!boomStack.isEmpty() && boomStack.peek() == boomStr.length()) {
				for (int j = 0; j < boomStr.length(); j++) {
					stack.pop();
				}
				boomStack.pop();
				if (boomStack.isEmpty())
					index = 0;
				else
					index = boomStack.peek();
			}
		}
		if(stack.isEmpty())
			bw.write("FRULA");
		while (!stack.isEmpty()) {
			tmpStack.push(stack.pop());
		}
		while (!tmpStack.isEmpty()) {
			bw.write(tmpStack.pop());
		}
		bw.flush();
	}
}