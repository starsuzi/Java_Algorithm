package review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 2178 bfs
public class Maze_bfs {

	static int N,M;
	static int[][] map;
	static Queue<Position> queue;
	static int[] dx = {-1,+1,0,0};
	static int[] dy = {0,0,-1,+1};
	static int[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M=sc.nextInt();

		map = new int[N][M];
		queue = new LinkedList<>();
		visited = new int[N][M];

		for (int y = 0; y < N; y++) {
			String temp = sc.next();
			for (int x = 0; x < M; x++) {
				if(temp.charAt(x) == '1') {
					map[y][x] = 1;
				}else {
					map[y][x] = 0;
				}
			}
		}

		Position a = new Position(0,0);
		queue.add(a);
		
		int depth = 1;
		
		while(queue.isEmpty() == false) {
			
			//1.poll
			Position current = queue.poll();
			depth = visited[current.y][current.x];
			
			if(current.y == N-1 && current.x == M-1) {
				//System.out.println("end");
				System.out.println(depth+1);
				break;
			}
			
			//System.out.println(current);
			//System.out.println(depth);
			//2.연결된길
			for (int i = 0; i < 4; i++) {
				int targetY = current.y + dy[i];
				int targetX = current.x + dx[i];
				//3.갈수있는길
				if(targetY>= 0 && targetY<N && targetX>=0 && targetX<M) {
					if(map[targetY][targetX] == 1 && visited[targetY][targetX] == 0) {
						//4.add
						queue.add(new Position(targetY,targetX));
						//5.방문체크
						visited[targetY][targetX] = depth+1;
					}
				}
			}
		}

	}

}

class Position{
	int y;
	int x;

	public Position(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	@Override
	public String toString() {
		return "Position [y=" + y + ", x=" + x + "]";
	} 

}
