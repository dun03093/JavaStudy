package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ1918 {
	static Stack<Character> operStack = new Stack<Character>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String argv[]) throws IOException {
		char chArr[] = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chArr.length; i++) {
			char ch = chArr[i];
			switch (ch) {
			case '+':
			case '-':
				while (!operStack.empty() && operStack.peek() != '(')
					sb.append(operStack.pop());
				operStack.push(ch);
				break;
			case '*':
			case '/':
				while (!operStack.empty() && (operStack.peek() == '*' || operStack.peek() == '/'))
					sb.append(operStack.pop());
			case '(':
				operStack.push(ch);
				break;
			case ')':
				while (!operStack.empty() && operStack.peek() != '(')
					sb.append(operStack.pop());
				operStack.pop();
				break;
			default:
				sb.append(ch);
				break;
			}
		}
		while (!operStack.empty())
			sb.append(operStack.pop());

		bw.write(sb.toString());
		bw.flush();
	}
}