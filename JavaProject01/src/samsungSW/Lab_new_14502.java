package samsungSW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab_new_14502 {

	static int N;
	static int M;
	static int[][]map;
	static int[][] visited;
	static int[][] virusVisit;
	static Queue<LabPosition> queue;
	static int[] dx = {0,0,-1,+1};
	static int[] dy = {-1,+1,0,0};
	static int result = -1;

	//0이 있는 칸에 벽을 3개 세워야한다-dfs
	//바이러스는 bfs로 퍼져나간다
	//남은 개수중 가장 Max 값이 답

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new int[N][M];
		queue = new LinkedList<>();
		virusVisit = new int [N][M];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		//벽세우기
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 0) {
					dfs(y*M+x,0);		
				}
			}
		}

		//System.out.println(queue);
		System.out.println(result);
	}

	static void dfs(int current ,int wall) {

		int currentY = current/M;
		int currentX = current%M;

		int[][] temp = new int [N][M];

		//System.out.println("wall: "+wall);

		//도달?
		if(wall == 2) {

			//	System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//			System.out.print(map[i][j]);
				}
				//		System.out.println();
			}

			//지금까지의 map을 temp에 담아줘야 한다.
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					temp[y][x] = map[y][x];
				}
			}
			//중요!!!!!!!!!!!!!!!
			map[currentY][currentX] = 1;

			//	System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
		//			System.out.print(map[i][j]);
				}
		//		System.out.println();
			}
			int cnt = bfs();
	//		System.out.println(cnt);

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					map[y][x] = temp[y][x];
				}
			}

			if(cnt>result) {
				result = cnt;
			}

			return;
		}
	
			//1.방문체크
			map[currentY][currentX] = 1;
			//2.연결된길
			for (int i = current+1; i < M*N; i++) {
				int targetY = i/M;
				int targetX = i%M;
				//3.갈수있는길		
				if(map[targetY][targetX] == 0) {
					//4.간다			
					dfs(i,wall+1);
				}
			}
			//5.방문해지
			map[currentY][currentX] = 0;
		}
	

	static int bfs() {
		//바이러스가 퍼질수있는 곳
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 2) {
					queue.add(new LabPosition(y,x));
				}
			}
		}
		while(queue.isEmpty() == false) {
			//1.poll
			LabPosition current = queue.poll();
			//2.연결된길
			for (int i = 0; i < 4; i++) {

				int targetY = current.y+dy[i];
				int targetX = current.x+dx[i];
				//3.갈수있는길
				if(targetY>=0 && targetY<N && targetX>=0 && targetX<M) {
					if(map[targetY][targetX] == 0 ) {
						//4.q에 넣는다
						queue.add(new LabPosition(targetY, targetX));
						//5.방문체크
						map[targetY][targetX] = 2;
					}
				}
			}		
		}

		int count =0 ;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 0) {
					count++;
				}
			}
		}
		return count;

	}


}

class LabPosition{
	int y;
	int x;
	public LabPosition(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	@Override
	public String toString() {
		return "LabPosition [y=" + y + ", x=" + x + "]";
	}

}
