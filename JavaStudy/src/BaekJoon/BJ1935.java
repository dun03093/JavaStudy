package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ1935 {
	static Stack<Double> stack = new Stack<Double>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String argv[]) throws IOException {
		int N = Integer.parseInt(br.readLine());
		double[] alphArr = new double[N];
		char[] arr = br.readLine().toCharArray();
		double tmp;
		for (int i = 0; i < N; i++)
			alphArr[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case '+':
				stack.push(stack.pop() + stack.pop());
				break;
			case '-':
				tmp = stack.pop();
				stack.push(stack.pop() - tmp);
				break;
			case '/':
				tmp = stack.pop();
				stack.push(stack.pop() / tmp);
				break;
			case '*':
				stack.push(stack.pop() * stack.pop());
				break;
			default:
				stack.push(alphArr[arr[i] - 'A']);
				break;
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}