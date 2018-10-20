package samsungSW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CCTV15683 {

	static int N,M;
	static int[][] map;
	static int[][] copiedMap;
	static int[] dx = {0,0};
	static int[] dy = {-1,+1};
	static int[] dx4 = {+1, -1, 0,0};
	static int[] dy4 = {0,0,+1,-1};
	static int[] dx3 = {0,+1,0,-1};
	static int[] dy3 = {-1,0,+1,0};
	static int[] dx2 = {0,+1};
	static int[] dy2 = {-1,0};
	static int result = Integer.MAX_VALUE;
	static Queue<CCTVPosition> queue;
	static int[][] tempCopiedMap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copiedMap = new int[N][M];
		queue = new LinkedList<>();
		tempCopiedMap = new int[N][M];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		copiedMap = copy(map);
		call5(map);
		call4(map);
		call3(map);
		call2(map);
		call1(map);

		result = squaredArea(map);
		System.out.println(result);
		
		
	}

	static void CCTV1(int current, int depth, int temp) {
		int currentY = current/M;
		int currentX = current%M;
	}

	static void CCTV2(int current, int depth, int temp) {
		
		int currentY = current/M;
		int currentX = current%M;
		
		for (int i = 0; i < 2; i++) {
			int targetY = currentY + dy2[i];
			int targetX = currentX + dx2[i];
			
			if(targetY >= 0 && targetX >= 0 && targetY < N && targetX < M) {
				int tempX = targetX;
				int tempY = targetY;
				
				if(i==0) {
					//북
					north(tempY, tempX);
					south(currentY, currentX);
					
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
					copiedMap = copy(map);
				}
				if(i==1)  {
					//동
					east(tempY, tempX);
					west(currentY, currentX);
					
					if(temp>squaredArea(copiedMap)) {
						temp = squaredArea(copiedMap);
						tempCopiedMap = copy(copiedMap);
					}

					copiedMap = copy(map);

				}
			}
			
			
		}
		//1.방문체크
		copiedMap[currentY][currentX] = 2;
		System.out.println();
		map = copy(tempCopiedMap);
		print(map);
	}

	static void CCTV3(int current, int depth, int temp) {


		int currentY = current/M;
		int currentX = current%M;

		//2.연결된길
		for (int i = 0; i < 4; i++) {
			int targetY = currentY + dy3[i];
			int targetX = currentX + dx3[i];
			//3.갈수있는길
			if(targetY >= 0 && targetX >= 0 && targetY < N && targetX < M) {
				int tempX = targetX;
				int tempY = targetY;

				if(i==0) {
					//북
					north(tempY, tempX);
					east(currentY, currentX);
					
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
					copiedMap = copy(map);
				}

				if(i==1)  {
					//동
					east(tempY, tempX);
					south(currentY, currentX);
					
					if(temp>squaredArea(copiedMap)) {
						temp = squaredArea(copiedMap);
						tempCopiedMap = copy(copiedMap);
					}

					copiedMap = copy(map);

				}

				if(i == 2) {
					//남
					south(tempY, tempX);
					west(currentY, currentX);
					
					if(temp>squaredArea(copiedMap)) {
						temp = squaredArea(copiedMap);
						tempCopiedMap = copy(copiedMap);
					}

					copiedMap = copy(map);
				}
				
				if(i==3) {
					//서
					west(tempY, tempX);
					north(currentY, currentX);
					
					if(temp>squaredArea(copiedMap)) {
						temp = squaredArea(copiedMap);
						tempCopiedMap = copy(copiedMap);
					}
				}

			}
		}

		//1.방문체크
		copiedMap[currentY][currentX] = 3;
		System.out.println();
		map = copy(tempCopiedMap);
		print(map);
	
	}

	static void CCTV4(int current, int depth, int temp) {

		int currentY = current/M;
		int currentX = current%M;

		//2.연결된길
		for (int i = 0; i < 2; i++) {
			int targetY = currentY + dy4[i];
			int targetX = currentX + dx4[i];
			//3.갈수있는길
			if(targetY >= 0 && targetX >= 0 && targetY < N && targetX < M) {
				int tempX = currentX;
				int tempY = currentY;
				
				if(i==0) {
					//북
					north(tempY, tempX);
					//동,서
					east(tempY, tempX);
					west(tempY, tempX);
					
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
					copiedMap = copy(map);
					
				}
				if(i==1) {
					//남
					south(tempY, tempX);
					//동,서
					east(tempY, tempX);
					west(tempY, tempX);
					
					if(temp>squaredArea(copiedMap)) {
						temp = squaredArea(copiedMap);
						tempCopiedMap = copy(copiedMap);
					}
				}
			}
		}

		//1.방문체크
		copiedMap[currentY][currentX] = 4;
		System.out.println();
		map = copy(tempCopiedMap);
		print(map);
	}


	static void CCTV5(int current, int depth) {

		int currentY = current/M;
		int currentX = current%M;

		//2.연결된길
		for (int i = 0; i < 4; i++) {
			int targetY = currentY + dy[i];
			int targetX = currentX + dx[i];
			//3.갈수있는길
			if(targetY >= 0 && targetX >= 0 && targetY < N && targetX < M) {
				int tempX = targetX;
				int tempY = targetY;

				if(i==0) {
					//동
					east(tempY, tempX);
				}
				if(i==1) {
					//남
					south(tempY, tempX);
				}
				if(i==2) {
					//서
					west(tempY, tempX);
				}
				if(i==3) {
					//북
					north(tempY, tempX);
				}
			}
		}

		//1.방문체크
		copiedMap[currentY][currentX] = 5;
		//	print(copiedMap);
		result = squaredArea(copiedMap);
		map = copy(copiedMap);
		System.out.println(result);
	}

	static void east(int targetY, int targetX) {

		//동
		System.out.println("동");
		while(true) {

			if(copiedMap[targetY][targetX] == 6 || targetX > M-2) {
				if(copiedMap[targetY][targetX] == 0) {
					copiedMap[targetY][targetX] = 7;	
				}
				break;
			}


			if(copiedMap[targetY][targetX] == 0) {
				copiedMap[targetY][targetX] = 7;		
			}

			targetX++;

		}
		print(copiedMap);

	}

	static void south(int targetY, int targetX) {
		System.out.println("남");

		while(true) {
			if(copiedMap[targetY][targetX] == 6 || targetY > N - 2) 
			{
				if(copiedMap[targetY][targetX] == 0) {
					copiedMap[targetY][targetX] = 7;	
				}
				break;
			}
			if(copiedMap[targetY][targetX] == 0) {
				copiedMap[targetY][targetX] = 7;		
			}
			targetY++;
		}
		print(copiedMap);
	}


	static void west(int targetY, int targetX) {
		//서
		System.out.println("서");
		while(true) {
			if(copiedMap[targetY][targetX] == 6 || targetX < 1) {
				if(copiedMap[targetY][targetX] == 0 ) {
					copiedMap[targetY][targetX] = 7;	
				}
				
				break;
			}
			if(copiedMap[targetY][targetX] == 0) {
				copiedMap[targetY][targetX] = 7;		
			}
			targetX --;
		}
		print(copiedMap);
	}

	static void north(int targetY, int targetX) {
		//북
		System.out.println("북");
		while(true) {
			if(copiedMap[targetY][targetX] == 6 || targetY<1) {
				if(copiedMap[targetY][targetX] == 0) {
					copiedMap[targetY][targetX] = 7;
				}

				break;
			}
			if(copiedMap[targetY][targetX] == 0) {
				copiedMap[targetY][targetX] = 7;		
			}
			targetY -- ;
		}
		print(copiedMap);

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

	static void call4 (int[][] temp){
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 4) {
					//queue.add(new CCTVPosition(i, j));
					CCTV4(i*M+j, 1,0);
				}
			}
		}
	}
	static void call3 (int[][] temp){
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 3) {
					//queue.add(new CCTVPosition(i, j));
					CCTV3(i*M+j, 1, 0);
				}
			}
		}
	}

	static void call2 (int[][] temp){
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 2) {
					//queue.add(new CCTVPosition(i, j));
					CCTV2(i*M+j, 1, 0);
				}
			}
		}
	}
	static void call1 (int[][] temp){
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 1) {
					//queue.add(new CCTVPosition(i, j));
					CCTV1(i*M+j, 1, 0);
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
