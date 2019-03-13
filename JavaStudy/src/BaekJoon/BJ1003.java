package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1003 {
	static class Dot {
		int n0, n1;

		Dot() {
			this.n0 = -1;
			this.n1 = -1;
		} 

		Dot(int n0, int n1) {
			this.n0 = n0;
			this.n1 = n1;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;
	static int n0 = 0, n1 = 0;
	static Dot arr[] = new Dot[41];

	public static void main(String argv[]) throws Exception {

		tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		arr[0] = new Dot(1, 0);
		arr[1] = new Dot(0, 1);
		
		for (int i = 2; i < arr.length; i++) {
			arr[i] = new Dot();
		}
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int ins = Integer.parseInt(tokenizer.nextToken());
			Fib(ins);
			bw.write(arr[ins].n0 + " " + arr[ins].n1 + "\n");
			n0 = n1 = 0;
		}
		bw.flush();
	}

	static void Fib(int ins) {
		if (arr[ins].n0 == -1) {
			Fib(ins - 1);
			Fib(ins - 2);
			arr[ins].n0 = arr[ins - 1].n0 + arr[ins - 2].n0;
			arr[ins].n1 = arr[ins - 1].n1 + arr[ins - 2].n1;
		}

	}
}