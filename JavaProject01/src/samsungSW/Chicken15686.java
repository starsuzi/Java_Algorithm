package samsungSW;

import java.util.Scanner;

public class Chicken15686 {

	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] chickDis;
	static int House;
	static int ChickenHouse;
	static ChickenPosition[] ChickenLocation;
	static ChickenPosition ChickenPos;
	static ChickenPosition HousePos;
	static ChickenPosition[] HouseLocation;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N+1][N+1];
		visited = new int[N+1][N+1];

		for (int y = 1; y < N+1; y++) {
			for (int x = 1; x < N+1; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		//없어도 될듯
		House = countHouse();

		ChickenHouse = countChicken();

		//얘는 필요
		ChickenLocation = new ChickenPosition[M]; 
		HouseLocation = new ChickenPosition[House];

		chickDis = new int[M];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(map[i][j]==1) {
					HouseLocation[i] = new ChickenPosition(i, j);
					
				}
			}
		}

		//print
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
			//	System.out.print(map[i][j]);
			}
		//	System.out.println();
		}

		//System.out.println(map[1][3]);
		for (int y = 1; y < N+1; y++) {
			for (int x = 1; x < N+1; x++) {
				if(map[y][x] == 2) {
					dfs(y,x,0);
				}
			}
		}
		
		System.out.println(result);
		
	}

	static void dfs(int currentY, int currentX, int depth) {
		//0. 도달?
		if(depth == M-1) {
			int temp ;
			
			ChickenPos = new ChickenPosition(currentY, currentX);
			ChickenLocation[depth] = ChickenPos;
			
			temp = chickenDistance(ChickenLocation);
			if(result>temp) {
				temp = result;
			}

		}
		//1. 방문체크
		visited[currentY][currentX] = 1; 
		//2. 연결된길
		for (int y = 1; y < N+1; y++) {
			for (int x = 1; x < N+1; x++) {
				//3. 갈수있는길
				if(map[y][x] == 2 && visited[y][x] != 1) {
					//각 치킨점을 history배열에 넣는다
					ChickenPos = new ChickenPosition(currentY, currentX);
					ChickenLocation[depth] = ChickenPos;
					//4. 간다
					dfs(y,x,depth+1);
				}
			}
		}
		//5. 방문해지
		visited[currentY][currentX] = 0;
	}

	static int countHouse() {
		int count = 0;

		for (int y = 1; y < N+1; y++) {
			for (int x = 1; x < N+1; x++) {
				if(map[y][x] == 1) {
					count++;
				}
			}
		}
		return count;
	}

	static int countChicken() {
		int count = 0;

		for (int y = 1; y < N+1; y++) {
			for (int x = 1; x < N+1; x++) {
				if(map[y][x] == 2) {
					count++;
				}
			}
		}
		return count;
	}

	static int chickenDistance(ChickenPosition[] chickLo) {
		int temp;
		int dis = Integer.MAX_VALUE;

		for (int i = 0; i < HouseLocation.length; i++) {
			dis = Integer.MAX_VALUE;
			for (int j = 0; j < chickLo.length; j++) {
				temp = (Math.abs(HouseLocation[i].Y -chickLo[j].Y)+Math.abs(HouseLocation[i].X -chickLo[j].X));
				if(temp<dis) {
					dis = temp;
				}
			}
			chickDis[i] = dis;
		}
		int sum = 0;
		for (int i = 0; i < chickDis.length; i++) {
			sum+=chickDis[i];
		}
		return sum;
	}

}
class ChickenPosition{

	int Y;
	int X;

	public ChickenPosition(int Y, int X) {
		super();
		this.Y = Y;
		this.X = X;
	}

	@Override
	public String toString() {
		return "ChickenPosition [Y=" + Y + ", X=" + X + "]";
	}

}



