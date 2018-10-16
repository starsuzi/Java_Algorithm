package samsungSW;

import java.util.Scanner;

public class Ladder15684 {

	static int N, M, H;
	static int[][] givenDot;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1,+1,0};
	static int[] dy = {0,0,+1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();

		givenDot = new int[M][2];

		for (int i = 0; i < M; i++) {
			givenDot[i][0] = sc.nextInt();
			givenDot[i][1] = sc.nextInt();
		}

		map = new int[H+1][N+1];
		visited = new int[H+1][N+1];
		
		for (int i = 0; i < M; i++) {
			int mapy = givenDot[i][0];
			int mapx = givenDot[i][1];
				map[mapy][mapx] = 1;
				map[mapy][mapx+1] = 1;
		}

		for (int i = 1; i < H+1; i++) {
			for (int j = 1; j < N+1; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		 
		
	}

}
