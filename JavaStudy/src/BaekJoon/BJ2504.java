package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;

public class BJ2504 {
	static Stack<Integer> stack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String argv[]) throws Exception {

		char c = (char) br.read();
		try {
			while (c == '(' || c == ')' || c == '[' || c == ']') {
				switch (c) {
				case '(':
					stack.push(-1);
					break;
				case '[':
					stack.push(1);
					break;
				case ')':
					StackCheck(-1, 1);
					break;
				case ']':
					StackCheck(1, 1);
					break;
				}
				c = (char) br.read();
			}
			while (stack.size() > 1) {
				int tmp = stack.pop();
				if (tmp < 2 || stack.peek() < 2)
					throw new EmptyStackException();
				stack.push(tmp + stack.pop());
			}
			bw.write(stack.peek() + "\n");
		} catch (Exception EmptyStackException) {
			bw.write("0\n");
		}
		bw.flush();
	}

	static void StackCheck(int index, int result) throws Exception {

		int tmp = 0;
		if (stack.peek() * index == 1) {
			tmp = result * ((5 + stack.pop()) / 2);
			stack.push(tmp);
		} else if (stack.peek() * index == -1)
			throw new EmptyStackException();
		else {
			if (result == 1)
				result--;
			result += stack.pop();
			StackCheck(index, result);
		}
	}
}