package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2448 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean arr[][] = new boolean[1025][1025];

	public static void main(String[] argv) throws IOException {

		int N = Integer.parseInt(br.readLine());
		int n = 0;
		StringBuilder sb = new StringBuilder();
		arr[1][1] = true;
		N /= 3;
		int tmpN = N;
		while (tmpN > 1) {
			tmpN /= 2;
			n++;
		}

		for (int forIndex = 1; forIndex < N; forIndex *= 2)
			fill(forIndex);
		for (int rowIndex = 1; rowIndex <= N; rowIndex++) {
			for (int triIndex = 0; triIndex < 3; triIndex++) {
				if (rowIndex % 2 == 1 && n != 0)
					sb.append("   ");
				for (int colIndex = 1; colIndex <= (N - rowIndex) / 2; colIndex++)
					sb.append("      ");
				for (int colIndex = 1; colIndex <= rowIndex; colIndex++) {
					if (arr[rowIndex][colIndex]) {
						switch (triIndex) {
						case 0:
							sb.append("  *   ");
							break;
						case 1:
							sb.append(" * *  ");
							break;
						case 2:
							sb.append("*****");
							if (rowIndex != N || colIndex != N)
								sb.append(" ");
							break;
						}
					} else
						sb.append("      ");
				}
				for (int colIndex = 1; colIndex <= (N - rowIndex) / 2; colIndex++)
					sb.append("      ");
				if (rowIndex % 2 == 1 && n != 0)
					sb.append("   ");
				if (rowIndex != N || triIndex != 2)
					sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void fill(int insIndex) {
		for (int rowIndex = 1; rowIndex <= insIndex; rowIndex++) {
			for (int colIndex = 1; colIndex <= insIndex; colIndex++) {
				arr[insIndex + rowIndex][colIndex] = arr[rowIndex][colIndex];
				arr[insIndex + rowIndex][colIndex + insIndex] = arr[rowIndex][colIndex];
			}
		}
	}

}