package samsungSW;

import java.util.Scanner;

public class Robot14503 {

	static int N,M, r, c, d;
	static int[][] map;
	static int[] dx = {0,-1,0,+1}; //북 서 남 동
	static int[] dy = {-1,0,+1,0};

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



		dfs(c,r,d,transfer(d));	
		
		int count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				//	System.out.print(map[y][x]);
				
				if(map[y][x] == 2) {
					count++;
				}
			}
			//System.out.println();
		}
		
		System.out.println(count);

	}

	static void dfs(int currentX, int currentY, int dir, int depth) {

		System.out.println(dir);
		dirCheck(dir);
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
			int count = 0;
			int targetY = currentY + dy[i%4];
			int targetX = currentX + dx[i%4];
			//3.갈수있는길
			if(targetY>=0 && targetX>=0 && targetX<M && targetY<N) {
				count++;
				if(map[targetY][targetX] == 0) {
					//4.간다
					dfs(targetX, targetY, i%4, depth+1);
				}


				//else {
					if(count==3) {
						//네방향 모두 벽이나 이미 청소
						//후진가능
						//해당이 안되어도 무조건 회전 조건 추가
						int newtargetY = currentY + dy[((i%4)+2)%4];
						int newtargetX = currentX + dx[((i%4)+2)%4];
						
						if(map[newtargetY][newtargetX] == 2) {
							dfs(newtargetX, newtargetY, ((i%4)+2)%4, depth+1);		
						}
						//후진 불가능
						else {
							return;
						}
					}
				//}

			}

		}
	}
	static int transfer(int dir) {
		if(dir == 1) {
			System.out.println("남");
			return 3;
		}
		else if(dir == 3) {
			System.out.println("서");
			return 1;
		}
		else if(dir == 0) {
			System.out.println("북");
			return 0;
		}
		else {
			System.out.println("동");
			return 2;
		}
	}

	static void dirCheck(int dir) {

		if(dir == 2) {
			System.out.println("남");
		}
		else if(dir == 1) {
			System.out.println("서");
		}
		else if(dir == 0) {
			System.out.println("북");
		}
		else {
			System.out.println("동");
		}

	}

}
