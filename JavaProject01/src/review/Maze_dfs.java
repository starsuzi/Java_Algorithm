//백준 2178
package review;

import java.util.Scanner;

public class Maze_dfs {

	static int N,M;
	static int[][] map;
	static int[][] visited;
	static int distance;
	static int[] dx = {0,0,-1,+1};
	static int[] dy = {-1,+1,0,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int y = 0; y < N; y++) {
			String temp = sc.next();
			for (int x = 0; x < M; x++) {

				if (temp.charAt(x) == '1') {
					map[y][x] = 1;
				} else {
					map[y][x] = 0;
				}
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//System.out.print(map[i][j]);
			}
			//System.out.println();
		}

		distance = Integer.MAX_VALUE;

		dfs(0,0,0);
		System.out.println(distance);

	}

	public static void dfs (int y, int x, int current) {
		//System.out.println("("+x+","+y+")");
		
		current++;
		//0.도달?
		if(y==N-1 && x == M-1) {
			//아니면 distance에 최소값을 넣고 다시 시작
			if(current<distance) {
				//System.out.println("end");
				distance = current;
				current = 0;
			}
			//최소
			else {
				return;
			}
		}
		

		//1.방문체크
		map[y][x] = map[y][x] + 2;
		//2.연결된길
		for (int i = 0; i < 4; i++) {
			int targetY = y+dy[i];
			int targetX = x+dx[i];
			//3.갈수있는길
			if(targetY>=0 && targetY<N && targetX>=0 && targetX<M&& map[targetY][targetX] == 1) {
				//4.간다
				dfs(targetY, targetX,current);
				
			}

		}
		
		//5.방문해제
		map[y][x] = map[y][x] - 2; 


	}


}
