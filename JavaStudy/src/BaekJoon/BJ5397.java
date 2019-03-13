package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ5397 {
	static Stack<Character> stack = new Stack<Character>();
	static Stack<Character> tmpstack = new Stack<Character>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String argv[]) throws IOException {
		int N = Integer.parseInt(br.readLine());
		char[] str;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			str = br.readLine().toCharArray();
			for (int j = 0; j < str.length; j++) {
				char ch = str[j];
				switch (ch) {
				case '<':
					if (!stack.isEmpty())
						tmpstack.push(stack.pop());
					break;
				case '>':
					if (!tmpstack.isEmpty())
						stack.push(tmpstack.pop());
					break;
				case '-':
					if (!stack.isEmpty())
						stack.pop();
					break;
				default:
					stack.push(ch);
					break;
				}
			}
			while (!stack.isEmpty())
				tmpstack.push(stack.pop());
			while (!tmpstack.isEmpty())
				sb.append(tmpstack.pop());
			bw.write(sb.toString()+"\n");
			bw.flush();
			sb.delete(0, sb.length());
		}
	}
}