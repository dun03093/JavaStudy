package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;

public class BJ1197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokenizer;
	static Vector<Edge> vector;

	static public class Edge {
		public int node[] = new int[2];
		int distance;

		Edge(int x, int y, int distance) {
			this.node[0] = x;
			this.node[1] = y;
			this.distance = distance;
		}

	}

	@SuppressWarnings("rawtypes")
	static public class EdgeComparator implements Comparator {
		public int compare(Object arg0, Object arg1) {
			return ((Edge) arg0).distance > ((Edge) arg1).distance ? 1 : 0;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String arg[]) throws IOException {
		tokenizer = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(tokenizer.nextToken());
		int[] set = new int[V];
		int E = Integer.parseInt(tokenizer.nextToken());
		vector = new Vector<>(E);
		for (int i = 0; i < E; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			Edge tmpEdge = new Edge(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()),
					Integer.parseInt(tokenizer.nextToken()));
			vector.add(tmpEdge);
		}
		Collections.sort(vector, new EdgeComparator());
		for (int i = 0; i < V; i++)
			set[i] = i;
		int sum = 0;
		for(int i=0;i<vector.size();i++) {
			
		}
			
	}

}
