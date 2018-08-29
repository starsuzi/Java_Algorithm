package Example0828;

import java.util.Scanner;

public class Virus {
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = 1;
			map[to][from] = 1;
			
		}
		
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				//System.out.print(map[i][j]+" ");
			}
			//System.out.println();
		}
		
		dfs(1);
		System.out.println(count);
		
	}

	static public void dfs(int node) {
		//1. 방문체크
		visited[node] = true;
		
		//2. 연결된길 for
		for (int i = 0; i < N+1; i++) {
			//3. 갈수있는길 if
			if(map[i][node] == 1 && visited[i] == false) {
				//4. 간다
				count++;
				dfs(i);
			}
		}
		
		
		
	}
	
}
