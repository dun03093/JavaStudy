package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ10984 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;

	public static void main(String argv[]) throws Exception {

		double G = 0, avgGrade, count;

		tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());

		for (int i = 0; i < N; i++) {

			avgGrade = 0;
			count = 0;
			tokenizer = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(tokenizer.nextToken());

			for (int j = 0; j < C; j++) {

				tokenizer = new StringTokenizer(br.readLine(), " ");
				G = Double.parseDouble(tokenizer.nextToken());
				count += G;
				avgGrade += Double.parseDouble(tokenizer.nextToken()) * G;
			}
			avgGrade = (double) Math.round((avgGrade /= count) * 10) / 10;
			bw.write((int) count + " " + Double.toString(avgGrade) + "\n");
		}
		bw.flush();
	}
}