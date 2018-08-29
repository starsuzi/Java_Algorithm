//baekjoon 1012
package Example0828;

import java.util.Scanner;

public class Organic {
	
	static int T,M,N,K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,+1,0,0};
	static int[] dy = {0,0,-1,+1};
	static int count = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		T=sc.nextInt();
		
		
		while(T>0) {
			
			
		M=sc.nextInt();
		N=sc.nextInt();
		K = sc.nextInt();
		
		map = new int [N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[y][x] = 1;
				
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
			
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 1) {
					count ++;
					dfs(y,x);					
				}
			}
		}
		System.out.println(count);
		count = 0;
		T--;	
		}		
	}

	public static void dfs(int y, int x) {
		
		//1. 방문체크
		map[y][x] = 2;
		//2. 연결된길
		for (int i = 0; i < 4; i++) {
			
			int targetY = dy[i] + y;
			int targetX = dx[i] + x;
			
			//3. 갈수있는길
			if(targetY >= 0 && targetX >= 0 && targetY<N && targetX<M ) {
				//4. 간다
				
				if(map[targetY][targetX] == 1) {
					dfs(targetY, targetX);
				}
				

			}
		}
		

	}
	
}
