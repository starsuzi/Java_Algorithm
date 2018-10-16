package samsungSW;

import java.util.Scanner;

public class Ladder15684 {

	static int N, M, H;
	static int[][] givenDot;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1,+1};
	static int[] dy = {0,0};
	static 	int count = 0;
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

		for (int y = 1; y < H+1; y++) {
			for (int x = 1; x < N; x++) {

				if(map[y][x] == 0 && map[y][x+1] == 0) {

					if(2<=x && x<=N-2) {
						if(map[y][x-1] != 1 && map[y][x+2] != 1) {
							count++;
							dfs(y*(N+1)+x, 1);
						}
					}
					else if(x == 1) {
						if( map[y][x+2] != 1) {
							count++;
							dfs(y*(N+1)+x, 1);

						}
					}
					else if(x==N-1) {
						if( map[y][x-1] != 1) {
							count++;
							dfs(y*(N+1)+x, 1);
							
						}
					}
				}
			
			}
		}
		System.out.println("original");
		for (int i = 0; i < H+1; i++) {
			for (int j = 0; j < N+1; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("count"+count);

	}

	static void dfs(int current, int depth) {

		int currentY = current/(N+1);
		int currentX = current%(N+1);
		
		//1.방문체크
		map[currentY][currentX] = 1;
		map[currentY][currentX+1] = 1;
		
		//map을 temp에 담는다
		//지나가는 함수 호출
		//depth가 3이 넘어가면 그냥 return
		//다시 temp를 map에 담는다
		
		System.out.println("currentX: "+currentX+" currentY: "+currentY+" depth: "+depth);

		for (int i = 0; i < H+1; i++) {
			for (int j = 0; j < N+1; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		

		//2.연결된길	
		for (int i = current+1; i < (H+1)*(N+1); i++) {
			
			int targetY = i / (N+1);
			int targetX = i % (N+1);
			//3.갈수있는길
			if(targetY>0 && targetX >0 && targetY<H+1 && targetX<N) {
	
				//4.간다
				if(map[targetY][targetX] == 0 && map[targetY][targetX+1] == 0) {
					
					if(2<=targetX && targetX<=N-2) {
						if(map[targetY][targetX-1] != 1 && map[targetY][targetX+2] != 1) {

							dfs(targetY*(N+1)+targetX, depth+1);
						}
					}
					else if(targetX == 1) {
						if( map[targetY][targetX+2] != 1) {

							dfs(targetY*(N+1)+targetX, depth+1);

						}
					}
					else if(targetX==N-1) {
						if( map[targetY][targetX-1] != 1) {

							dfs(targetY*(N+1)+targetX, depth+1);
						}
					}
				}
			}
		}

		//5.방문해지
		 map[currentY][currentX] = 0;
		 map[currentY][currentX+1] = 0;
	}
	static void go() {
		for (int x = 1; x < N+1; x++) {
			
		}
	}
}
