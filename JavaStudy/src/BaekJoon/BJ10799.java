package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ10799 {
	static Stack<Boolean> stack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String argvs[]) throws Exception {

		char c;
		int total = 0;
		boolean lazer = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = (char) br.read();
		do {

			if (c == '(') {
				stack.push(true);
				lazer = true;
			} else if (c == ')') {
				if (lazer) {
					stack.pop();
					total += stack.size();
					lazer = false;
				}
				else{
					stack.pop();
					total++;
				}
			}
			c = (char) br.read();
		} while (c != '\n');
		bw.write(total + "\n");
		bw.flush();
	}
}