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
	static int[][] originMap;
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
		originMap = new int[H+1][N+1];

		for (int i = 0; i < M; i++) {
			int mapy = givenDot[i][0];
			int mapx = givenDot[i][1];
			map[mapy][mapx] = 1;
			map[mapy][mapx+1] = 1;
		}

		//print

		originMap = CopyMap(map);


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
				break;
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
					dfs(y*(N+1)+x, 1);
				}

			}
		}


		if(answer>3) {
			System.out.println(3);
		}
		else {
			System.out.println(answer);
		}


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

		System.out.println("currentX: "+currentX+" currentY: "+currentY+" depth: "+depth);

		//go함수 호출
		answer = Integer.MAX_VALUE;
		copiedMap = CopyMap(map);

		for (int i = 1; i < N+1; i++) {
			go(1, i, 1, true);
			System.out.println("iteration"+i);
			print(copiedMap);
			System.out.println();
			print(visited);
			System.out.println(isArrived(visited[H][i]));
			if(isArrived(visited[H][i]) == false) {
				System.out.println();
				print(visited);
				ClearMap(visited);
				break;
			}

			if(i == N) {
				System.out.println();
				print(copiedMap);
				System.out.println();
				print(visited);

				int temp = depth;
				if(answer > temp) {
					answer = temp;
				}
				return;
			}
			ClearMap(visited);

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

	static int count(int[][] temp) {
		int sum = 0;
		for (int i = 1; i < H+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(temp[i][j] == 1) {
					sum++;
				}
			}
		}
		return (sum/2);
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

	static int RowSum(int[][] temp) {
		int sum = 0;
		for (int i = 1; i < N+1; i++) {
			if(temp[H][i] == 1) {
				sum++;
			}
		}


		return sum;
	}

	static void go(int currentY, int currentX, int depth, boolean isDown) {

		if(currentY==H) {
			//1.방문체크
			visited[currentY][currentX] = 1;
			if( isDown != false 
					&&(currentX+1 < N+1) 
					&& copiedMap[currentY][currentX+1] == 1
					&& copiedMap[currentY][currentX] == 1) {

				visited[currentY][currentX+1] = 1;
				return;
			}
			else if( isDown != false 
					&& (currentX > 1)
					&& (copiedMap[currentY][currentX-1] == 1)
					&& copiedMap[currentY][currentX] == 1) {

				visited[currentY][currentX-1] = 1;
				return;
			}
			return;
		}


		//1.방문체크
		visited[currentY][currentX] = 1;

		//2.연결된길
		for (int i = 0; i < 3; i++) {

			int targetY = currentY+dy[i];
			int targetX = currentX + dx[i];	
			//3.갈수있는길	
			if(targetY>0 && targetX>0 && targetY<H+1 && targetX<N+1 && targetY >= currentY) {

				/* To Do 
				 * 1. If-else Condition Change
				 * 2. 빈칸 채우기
				 * 3. 돌려보기
				 * */

				if(
						(currentX > 1) && (currentX+1 < N+1) &&
						copiedMap[currentY][currentX] == 1
						&& copiedMap[currentY][currentX-1] == 1
						&& copiedMap[currentY][currentX+1] == 1
						&& isDown != false
						) {


					int countRight = 0;
					int tempX = currentX;

					while(tempX <N+1 && copiedMap[currentY][tempX] == 1) { //error check
						countRight++;
						tempX++;
					}

					if((countRight%2) == 0) {
						go(currentY, currentX+1, depth+1, false);
						return;
					}
					else if((countRight%2) == 1) {
						go(currentY, currentX-1, depth+1, false);
						return;
					} 
				}	


				//양옆
				else if(currentY == targetY && isDown != false && copiedMap[targetY][targetX] == 1) {
					if(copiedMap[currentY][currentX] == 1) {
						go(targetY, targetX, depth+1, false);
						return;
					}
					else if(copiedMap[currentY][currentX] == 0){
						if(
								(currentX > 1) && (currentX+1 < N+1)
								&& copiedMap[currentY][currentX - 1] == 1
								&& copiedMap[currentY][currentX + 1] == 1
								&& (currentX % 2) == 0
								) {
							go(currentY, currentX-1, depth+1, false);
							return;
						}
						else if(
								(currentX > 1) && (currentX+1 < N+1)
								&& copiedMap[currentY][currentX - 1] == 1
								&& copiedMap[currentY][currentX + 1] == 1
								&& (currentX % 2) == 0
								) {
							go(currentY, currentX+1, depth+1, false);
							return;
						}
						else if(
								(currentX > 1) && (currentX+1 < N+1)
								&& (copiedMap[currentY][currentX - 1] == 1
								|| copiedMap[currentY][currentX + 1] == 1
								&& copiedMap[targetY][targetX] == 1
								)
								) {
							go(targetY, targetX, depth+1, false);
							return;
						}

					}

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
