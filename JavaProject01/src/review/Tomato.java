package review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 7576 
//https://www.acmicpc.net/problem/7576

public class Tomato {
	
	static int N,M;
	static Queue<TPosition> queue;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1,+1,0,0};
	static int[] dy = {0,0,-1,+1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		M = sc.nextInt();
		N =sc.nextInt();
	
		queue = new LinkedList<>();
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}
		//시작할수있는곳 모두 큐에 넣기
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				//System.out.print(map[y][x]);
				if(map[y][x] == 1) {
					TPosition a = new TPosition(y,x);
					queue.add(a);
					
					
				}
			}
			//System.out.println();
		}		
		
		int depth = 0;
		
		while(queue.isEmpty() == false) {
			
			//1.큐에서 꺼내옴
			TPosition current = queue.poll();
			depth = map[current.y][current.x];
			//System.out.println(current);
			//System.out.println("depth: "+depth);
			
			//2.연결된길
			for (int i = 0; i < 4; i++) {
				int targetY = current.y + dy[i];
				int targetX = current.x + dx[i];
				//3.갈수있는길
				if (targetY>= 0 && targetX >= 0 && targetY <N && targetX <M) {
					if(map[targetY][targetX] == 0) {
						
						//4.큐에넣음
						
						queue.add(new TPosition(targetY, targetX));
						//5.방문기록
						map[targetY][targetX] = map[current.y][current.x] + 1;
					}
				}
			}
			
		}
	
		
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(depth-1);
		
	}

}

class TPosition{
	int y;
	int x;
	public TPosition(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	@Override
	public String toString() {
		return "TPosition [y=" + y + ", x=" + x + "]";
	}
	
}
