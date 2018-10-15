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

	//0�� �ִ� ĭ�� ���� 3�� �������Ѵ�-dfs
	//���̷����� bfs�� ����������
	//���� ������ ���� Max ���� ��

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

		//�������
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 0) {
					dfs(y*M+x,0);		
				}
			}
		}

		//���̷����� �������ִ� ��
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 2) {
					queue.add(new LabPosition(y,x));
				}
			}
		}
		//System.out.println(queue);
	}

	static void dfs(int current ,int wall) {
		
		int currentY = current/M;
		int currentX = current%M;
		
		//����?
		if(wall == 2) {
			
			map[currentY][currentX] = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			//5.�湮����
	//		map[currentY][currentX] = 0;
	//		visited[currentY][currentX] = 0;
		
			//return;
		}
		//1.�湮üũ
		map[currentY][currentX] = 1;
		//2.����ȱ�
		for (int i = current+1; i < M*N; i++) {
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

	static void bfs() {
		while(queue.isEmpty() == false) {
			//1.poll
			LabPosition current = queue.poll();
			//2.����ȱ�
			for (int i = 0; i < 4; i++) {
				int targetY;
				int targetX;

				targetY = current.y;
				targetX = current.x;
				//3.�����ִ±�
				if(targetY>=0 && targetY<N && targetX>=0 && targetX<M) {
					if(map[targetY][targetX] == 0 ) {
						//4.q�� �ִ´�
						queue.add(new LabPosition(targetY, targetX));
						//5.�湮üũ
						map[current.y][current.x] = 2;
					}
				}
			}		
		}
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
