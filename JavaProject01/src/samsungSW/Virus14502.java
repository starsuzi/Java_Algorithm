package samsungSW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus14502 {

	static int M,N;
	static int[][] map;
	static Queue<Position> queue;
	static int[] dx = {0,0,-1,+1};
	static int[] dy = {-1,+1,0,0};
	static int max = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		queue = new LinkedList<>();

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				int sum = y*M+x;
				if(map[y][x] == 0) {
					dfs(sum,1);	
				}	
			}
		}


		System.out.println(max);

	}

	static int bfs() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 2) {
					queue.add(new Position(y, x));
					//history[y][x] = 1;
				}
			}
		}

		while(queue.isEmpty() == false) {

			//1. q���� ������
			Position current = queue.poll();

			//	System.out.println(current);
			//	System.out.println(depth);
			//2. ����ȱ�
			for (int i = 0; i < 4; i++) {
				int targetY = current.y + dy[i];
				int targetX = current.x + dx[i];
				//3. �����ִ±�
				if(targetY>=0 && targetY<N && targetX >=0 && targetX<M) {
					if(map[targetY][targetX] == 0) {
						//4. q�� �ִ´�
						queue.add(new Position(targetY, targetX));
						//5. �湮üũ
						map[targetY][targetX] = 2;
					}			
				}
			}
		}

		int count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 0) {
					count++;
				}
			}
		}
		return count;
	}


	static void dfs(int current, int wall) {
		//0. ����?
		//System.out.println(current%M+","+current/M+","+wall);
		if(wall==3) {		

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					//System.out.print(map[y][x]);
				}
				//System.out.println();
			}



			int temp[][];
			temp = new int[N][M];
			for (int mapy = 0; mapy < N; mapy++) {
				for (int mapx = 0; mapx < M; mapx++) {
					temp[mapy][mapx] = map[mapy][mapx];		
				}
			}

			int currentY = current/M;
			int currentX = current%M;

			map[currentY][currentX] = 1;


			//bfs ȣ��
			int result = bfs();
			for (int mapy = 0; mapy < N; mapy++) {
				for (int mapx = 0; mapx < M; mapx++) {
					map[mapy][mapx] = temp[mapy][mapx];		
				}
			}
			//ũ���
			if(max<result) {
				max = result;
			}
			
			return;

		} else {
			int currentY = current/M;
			int currentX = current%M;
			//1.�湮üũ
			map[currentY][currentX] = 1;
			//2.����ȱ�
			for (int i = current+1; i < N*M; i++) {
				int targetY = i/M;
				int targetX = i%M;
				//3.�����ִ±�
				if(map[targetY][targetX] == 0) {
					//4.����
					dfs(i,wall+1);	
				}
			}

			//5.�湮����
			map[currentY][currentX] = 0;

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
		return "Position [x=" + x + ", y=" + y + "]";
	}

}

