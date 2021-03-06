package samsungSW;

import java.util.Scanner;

public class StartLink14889 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int[] history;
	static int[] history2;
	static int whole = 0;
	static int max = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];
		history = new int[N/2];
		history2 = new int[N];
		visit = new boolean[N];

		for (int y = 0; y <N; y++) {
			for (int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				//	System.out.print(map[y][x]);
			}
			//System.out.println();
		}


		for (int i = 0; i < N; i++) {
			dfs(i,0);	
		}

		System.out.println(max);

	}

	static void dfs(int node , int depth) {


		//0.도달
		if(depth == N/2 -1) {
			//		System.out.println("node: "+node+" depth: "+depth);
			int sum = 0;
			int sum2 =0;
			
			visited[node] = true;
			history[depth] = node;

			for (int i = 0; i < history.length; i++) {
				for (int j = 0; j < history.length; j++) {
					sum += map[history[i]][history[j]];	
				}
			}		

			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited.length; j++) {
					if(visited[i] == false && visited[j] == false) {
						sum2 += map[i][j];
					}
				}
			}

			int result = Math.abs(sum2 - sum);

			if(result<max) {

			//	System.out.println(sum+" : sum");
			//	System.out.println(sum2+" : sum2");

				max = result;

				for (int i = 0; i < visited.length; i++) {
				//	System.out.print(visited[i]+" ");
				}
				//	System.out.println(max+" : max");
			}
			
			visited[node] = false;
			return;
		}

		else {
			//1.방문체크
			visited[node] = true;
			history[depth] = node;

			//2.연결된길
			for (int i = node+1; i < N; i++) {
				//3.갈수있는길
				if(visited[i] == false) {
					//4.간다
					dfs(i,depth+1);
				}
			}

			//5.방문해지
			visited[node] = false;
		}
	}
}



