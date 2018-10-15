package samsungSW;

import java.util.Scanner;

public class Chicken15686 {

	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] chickDis;
	static int House;
	static ChickenPosition[] ChickenLocation;
	static ChickenPosition ChickenPos;
	static ChickenPosition HousePos;
	static ChickenPosition[] HouseLocation;
	static int result = Integer.MAX_VALUE;
	static int tmp;

	public static void main(String[] args) {
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
		
		for (int y = 1; y < 51; y++) {
			for (int x = 1; x < 51; x++) {
			//	System.out.print(0+" ");
			}
			//System.out.println();
		}
		

		House = countHouse();

		ChickenLocation = new ChickenPosition[M]; 
		HouseLocation = new ChickenPosition[House];

		chickDis = new int[House];

		int count = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(map[i][j]==1) {
					HouseLocation[count] = new ChickenPosition(i, j);
					count++;
				}
			}
		}



		for (int y = 1; y < N+1; y++) {
			for (int x = 1; x < N+1; x++) {
				if(map[y][x] == 2) {
					dfs(y,x,0);
					//visited[y][x] = 1;
				}
			}
		}

		for (int i = 0; i < ChickenLocation.length; i++) {
			//	System.out.println(ChickenLocation[i]);
		}
		System.out.println(result);
	}


	static void dfs(int currentY, int currentX, int depth) {

		//0. �룄�떖?
		if(depth == M-1) {
			// 치킨점 좌표를 chickenLocation배열에 넣는다
			ChickenLocation[depth] = new ChickenPosition(currentY, currentX);

			tmp = chickenDistance(ChickenLocation);

			if(result>tmp) {
				result = tmp;
			}
			return;
		}

		//1. 諛⑸Ц泥댄겕
		visited[currentY][currentX] = 1;
		// 移섑궓�젏 醫뚰몴瑜� chickenLocation諛곗뿴�뿉 �꽔�뒗�떎
		ChickenLocation[depth] = new ChickenPosition(currentY, currentX);

		//2. �뿰寃곕맂湲�
		for (int y = 1; y < N+1; y++) {
			for (int x = 1; x < N+1; x++) {
				//3. 媛덉닔�엳�뒗湲�
				if(map[y][x] == 2 && visited[y][x] != 1) {
					//4. 媛꾨떎
					dfs(y,x,depth+1);
				}
			}

		}
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


	static int chickenDistance(ChickenPosition[] chickLo) {
		int temp;
		int dis = Integer.MAX_VALUE;

		for (int i = 0; i < HouseLocation.length; i++) {
			dis = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				//i번째 집에 따른 j번째 치킨집의 거리
				temp = (Math.abs(HouseLocation[i].Y -chickLo[j].Y)+Math.abs(HouseLocation[i].X -chickLo[j].X));
				//i번째 집과 최소 거리에 있는 치킨집 거리를 찾는다
				if(temp<dis) {
					dis = temp;
				}
			}
			//치킨 거리를 배열에 담는다. 
			chickDis[i] = dis;
		}
		int sum = 0;
		for (int i = 0; i < chickDis.length; i++) {
			sum+=chickDis[i];
		}

		for (int i = 0; i < chickDis.length; i++) {
			chickDis[i] = 0;
		}

		return sum;
	}

}
class ChickenPosition{

	int Y;
	int X;

	public ChickenPosition(int Y, int X) {

		this.Y = Y;
		this.X = X;
	}

	@Override
	public String toString() {
		return "ChickenPosition [Y=" + Y + ", X=" + X + "]";
	}

}