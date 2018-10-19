package samsungSW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CCTV15683 {

	static int N,M;
	static int[][] map;
	static int[][] copiedMap;
	static int[] dx1 = {};
	static int[] dy1 = {};
	static int[] dx2 = {};
	static int[] dy2 = {};
	static int[] dx5 = {+1,0,-1,0};
	static int[] dy5 = {0,+1,0,-1};
	static int result = Integer.MAX_VALUE;
	static Queue<CCTVPosition> queue;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copiedMap = new int[N][M];
		queue = new LinkedList<>();

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		copiedMap = copy(map);
		call5(map);

	}

	static void CCTV1(int current, int depth) {
		//1.방문체크

		//2.연결된길
		//3.갈수있는길
		//4.간다
		//5.방문해지
	}

	static void CCTV2(int current, int depth) {

	}

	static void CCTV5(int current, int depth) {

		int currentY = current/M;
		int currentX = current%M;

		//1.방문체크
		copiedMap[currentY][currentX] = 7;
		//2.연결된길
		for (int i = 0; i < 4; i++) {
			int targetY = currentY + dy5[i];
			int targetX = currentX + dx5[i];
			//3.갈수있는길
			if(targetY >= 0 && targetX >= 0 && targetY < N && targetX < M) {
				int tempX = targetX;
				//동
				while(true) {
					if(copiedMap[targetY][tempX] == 6 
							|| tempX > M-2) {
						break;
					}
					tempX++;
				}
				targetX = tempX;
				//4.간다
				//CCTV5(targetY*M+targetX, depth+1);

			}
		}


		//5.방문해지

	}

	static void print(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int[][] copy(int[][] temp) {
		int[][] cMap = new int[N][M];

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				cMap[i][j] = temp[i][j];
			}
		}
		return cMap;
	}

	static void clear(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = 0;
			}
		}
	}

	static int squaredArea(int[][] temp) {
		int count = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static void call5 (int[][] temp){
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 5) {
					//queue.add(new CCTVPosition(i, j));
					CCTV5(i*M+j, 1);
				}
			}
		}
	}

}

class CCTVPosition{
	int y;
	int x;

	public CCTVPosition(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}



	@Override
	public String toString() {
		return "CCTVPosition [y=" + y + ", x=" + x + "]";
	}


}
