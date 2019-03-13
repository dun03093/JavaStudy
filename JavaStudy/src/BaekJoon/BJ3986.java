package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ3986 {
	static Stack<Character> stack = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String argv[]) throws Exception {
 
		String str;
		char[] c;
		int N, count = 0;
	
		N = Integer.parseInt(br.readLine());

		for (int loopIndex = 0; loopIndex < N; loopIndex++) {

			str = br.readLine();
			c = str.toCharArray();
			for (int strIndex = 0; strIndex < str.length(); strIndex++) {

				if (!stack.isEmpty() && c[strIndex] == stack.peek())
					stack.pop();
				else
					stack.push(c[strIndex]);
			}
			if (stack.isEmpty())
				count++;
			stack.clear();

		}
		bw.write(count + "\n");
		bw.flush();
	}
}