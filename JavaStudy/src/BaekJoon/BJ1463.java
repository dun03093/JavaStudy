package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ1463 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> tmpStack = new Stack<Integer>();

	public static void main(String argv[]) throws Exception {

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 5];
		int tmp;
		arr[1] = 0;

		stack.push(1);
		if (N != 1)
			while (arr[N] == 0) {
				tmp = stack.pop();
				if (tmp * 2 <= N && arr[tmp * 2] == 0) {
					arr[tmp * 2] = arr[tmp] + 1;
					tmpStack.push(tmp * 2);

				}

				if (tmp * 3 <= N && arr[tmp * 3] == 0) {
					arr[tmp * 3] = arr[tmp] + 1;
					tmpStack.push(tmp * 3);
				}
				if (tmp < N && arr[tmp + 1] == 0) {
					arr[tmp + 1] = arr[tmp] + 1;
					tmpStack.push(tmp + 1);
				}
				if (stack.isEmpty()) {
					stack.addAll(tmpStack);
					tmpStack.clear();
				}
			}
		bw.write(Integer.toString(arr[N]));
		bw.flush();

	}
}