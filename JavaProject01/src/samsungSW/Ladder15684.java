package samsungSW;

import java.util.Scanner;

public class Ladder15684 {

	static int N, M, H;
	static int[][] givenDot;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1,+1,0};
	static int[] dy = {0,0,+1};
	static 	int count = 0;
	static int[][] path;
	static int[][] copiedMap;
	static int answer = -1;

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
		copiedMap = new int[H+1][N+1];
		path = new int[H+1][N+1];

		for (int i = 0; i < M; i++) {
			int mapy = givenDot[i][0];
			int mapx = givenDot[i][1];
			map[mapy][mapx] = 1;
			map[mapy][mapx+1] = 1;
		}

		//print

		copiedMap = CopyMap(map);
		for (int i = 1; i < N+1; i++) {
			go(1, i, 1, true);
			System.out.println("original"+i);
			print(map);
			System.out.println();
			print(visited);
			System.out.println(isArrived(visited[H][i]));
			if(isArrived(visited[H][i]) == false) {
				System.out.println(isArrived(visited[H][i]));
				ClearMap(visited);
				//break;
			}
			ClearMap(visited);
			if(i==N) {
				answer = 0;
				System.out.println(answer);
				return;
			}
		}



		for (int y = 1; y < H+1; y++) {
			for (int x = 1; x < N; x++) {

				if(map[y][x] == 0 && map[y][x+1] == 0) {
					//dfs(y*(N+1)+x, 1);
				}

			}
		}




		//System.out.println("original");
		for (int i = 0; i < H+1; i++) {
			for (int j = 0; j < N+1; j++) {
				//System.out.print(map[i][j]);
			}
			//System.out.println();
		}


		//	System.out.println("count"+count);
		System.out.println(answer);

	}

	static void print(int[][] printedVar) {
		for (int i = 0; i < printedVar.length; i++) {
			for (int j = 0; j < printedVar[0].length; j++) {
				System.out.print(printedVar[i][j]);
			}
			System.out.println();
		}
	}

	static void dfs(int current, int depth) {

		int currentY = current/(N+1);
		int currentX = current%(N+1);

		//0.도달?
		//if (depth > 3) {
		//	return;
		//}

		//1.방문체크
		map[currentY][currentX] = 1;
		map[currentY][currentX+1] = 1;

		//map을 temp에 담는다
		//지나가는 함수 호출
		//depth가 3이 넘어가면 그냥 return- 해결
		//다시 temp를 map에 담는다

		System.out.println("currentX: "+currentX+" currentY: "+currentY+" depth: "+depth);

		for (int i = 0; i < H+1; i++) {
			for (int j = 0; j < N+1; j++) {
				//System.out.print(map[i][j]);
			}
			//System.out.println();
		}
		//System.out.println();

		//go함수 호출
		copiedMap = CopyMap(map);

		for (int i = 1; i < N+1; i++) {
			go(1, i, 1, true);
			System.out.println("iteration"+i);
			print(map);
			System.out.println();
			print(copiedMap);
			System.out.println();
			print(visited);
			System.out.println(isArrived(visited[H][i]));
			//System.out.println("end"+visited[H][i]);
			System.out.println(isArrived(visited[H][i]));
			if(isArrived(visited[H][i]) == false) {
				ClearMap(visited);
				break;
			}
			ClearMap(visited);
			if(i == N) {
				answer = depth;
				return;
			}
		}


		//2.연결된길	
		for (int i = current+1; i < (H+1)*(N+1); i++) {

			int targetY = i / (N+1);
			int targetX = i % (N+1);
			//3.갈수있는길
			if(targetY>0 && targetX >0 && targetY<H+1 && targetX<N) {

				//4.간다
				if(map[targetY][targetX] == 0 && map[targetY][targetX+1] == 0) {
					dfs(targetY*(N+1)+targetX, depth+1);
				}
			}
		}

		//5.방문해지
		map[currentY][currentX] = 0;
		map[currentY][currentX+1] = 0;
	}

	static boolean isArrived(int end) {
		if(end == 1) {
			return true;
		}
		else {
			return false;
		}
	}


	static int[][] CopyMap(int[][] original) {

		int[][] temp = new int[H+1][N+1];

		for (int y = 0; y < H+1; y++) {
			for (int x = 0; x < N+1; x++) {
				temp[y][x]= original[y][x];
			}
		}

		return temp;
	}

	static void ClearMap(int[][] temp) {

		for (int y = 0; y < H+1; y++) {
			for (int x = 0; x < N+1; x++) {
				temp[y][x] = 0;
			}
		}
	}

	static void go(int currentY, int currentX, int depth, boolean isDown) {
		//0.도달
		if(currentY==N+1) {
			visited[currentY][currentX] = 1;
			//	return;
		}

		else {
			//1.방문체크
			visited[currentY][currentX] = 1;

			//2.연결된길
			for (int i = 0; i < 3; i++) {

				int targetY = currentY+dy[i];
				int targetX = currentX + dx[i];	
				//3.갈수있는길	
				if(targetY>0 && targetX>0 && targetY<H+1 && targetX<N+1 && targetY >= currentY) {
					//if(visited[targetY][targetX] != 1) {

					//처음부터 1111놓인 경우

					/* To Do 
					 * 1. If-else Condition Change
					 * 2. 빈칸 채우기
					 * 3. 돌려보기
					 * */

					if((currentX-1 > 0) && (currentX+1 < N+1)) {
						if(
								copiedMap[currentY][currentX] == 1
								&& copiedMap[currentY][currentX-1] == 1
								&& copiedMap[currentY][currentX+1] == 1
								&& isDown != false
								) {


							int countRight = 0;
							int tempX = currentX+1;

							while(copiedMap[currentY][tempX] == 1) {
								countRight++;
								tempX++;
							}

							System.out.println(countRight);
							if((countRight%2) == 1) {
								go(currentY, currentX+1, depth+1, false);
								return;
							}
							else if((countRight%2) == 0) {
								go(currentY, currentX -1, depth+1, false);
								return;
							} 
						}	
					}

					

					//양옆
					else if(currentY == targetY && isDown != false && copiedMap[targetY][targetX] == 1 && copiedMap[currentY][currentX] == 1) {
						go(targetY, targetX, depth+1, false);
						return;
					}

					//내려간다
					else if (currentY+1 == targetY) {
						isDown = true;
						go(targetY, targetX, depth+1, true);
						return;
					}
					//}
				}
			}
		}
	}
}
