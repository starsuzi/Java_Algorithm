package samsungSW;

import java.util.Scanner;

public class Robot14503 {

	static int N,M, r, c, d;
	static int[][] map;
	static int[] dx = {0,-1,0,+1}; //북 서 남 동
	static int[] dy = {+1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		r= sc.nextInt();
		c = sc.nextInt();
		d= sc.nextInt();

		map = new int[N][M];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				//	System.out.print(map[y][x]);
			}
			//System.out.println();
		}

		
		
		dfs(r,c,d,transfer(d));	


	}

	static void dfs(int currentX, int currentY, int dir, int depth) {

		System.out.println(dir);
		System.out.println("(currentx, currenty) ("+currentY+","+currentX+")");

		//1.방문체크
		if(map[currentY][currentX] == 0) {
			map[currentY][currentX] = 2;
		}
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
		
		//2.연결된길
		for (int i = d+1; i < d+5; i++) {
			int targetY = currentY + dy[i%4];
			int targetX = currentX + dx[i%4];
			//3.갈수있는길
			if(targetY>=0 && targetX>=0 && targetX<M && targetY<N) {
				if(map[targetY][targetX] == 0) {
					//4.간다
					dfs(targetX, targetY, i%4, depth+1);
				}
				//else if(map[targetY][targetX] == 2) {

				//}

			}

		}
	}
	static int transfer(int dir) {
		if(dir == 1) {
			return 3;
		}
		else if(dir == 3) {
			return 1;
		}
		else if(dir == 0) {
			return 0;
		}
		else {
			return 2;
		}
	}

}
