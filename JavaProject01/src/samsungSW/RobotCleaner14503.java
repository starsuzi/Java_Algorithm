package samsungSW;

import java.util.Scanner;

public class RobotCleaner14503 {

	static int N,M, r, c, d;
	static int[][] map;
	static int[] dx = {0,+1,0,-1};
	static int[] dy = {+1,0,-1,0};


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		r= sc.nextInt();
		c = sc.nextInt();
		d= sc.nextInt();

		map = new int[N][M];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				//	System.out.print(map[y][x]);
			}
			//System.out.println();
		}

		dfs(r,c,d);
	}

	static void dfs(int currentX, int currentY, int dir) {
		//1.�湮üũ
		if(map[currentY][currentX] == 0) {
			clean(currentX, currentY);
			System.out.println("(currentX, currentY) ("+currentX+","+currentY+") clean");
		}

		//2.����ȱ�

		//���ʹ������� ȸ��
		int newDir = left(currentX, currentY, dir);
		int targetY = currentY + dy[newDir];
		int targetX = currentX +dx[newDir];
		
		//3.�����ִ±�
		if(targetY >= 0 && targetY<N && targetX >= 0 && targetX <M ) {
			if(map[targetY][targetX] == 0 ) {

				//4.����	
				dfs(targetX, targetY, newDir);
			}
			//���� ���⿡ û���� ������ ���ٸ�
			else {

				int newnewDir = left(currentX, currentY, newDir);
				System.out.println(newnewDir);
				//�� ���� ��� û�Ұ� �̹� �Ǿ����� ���� ���
				if(search(currentX, currentY) == false) {
					
					System.out.println("�� ���� ��� û�Ұ� �̹� �Ǿ����� ���� ���");
					System.out.println("(currentX, currentY, dir) ("+currentX+","+currentY+","+newnewDir+")");
					dfs(currentX, currentY, newnewDir);
					
				} else {

					int newTargetX = currentX + dx[goBack(newnewDir)];
					int newTargetY = currentY + dy[goBack(newnewDir)];

					if(map[newTargetY][newTargetY] == 1) {
						//�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ���
						System.out.println("�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ��");
						return;

					} else {
						//�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ���
						//����
						System.out.println("����");
						dfs(newTargetX, newTargetY, newnewDir);
					}

				}


			}
		}			

	}

	static int goBack(int dir) {
		if(dir == 0) {
			return 2;
		}
		else if(dir ==1) {
			return 3;
		}
		else if(dir == 2) {
			return 4;
		}
		else {
			return 1;
		}
	}

	//�׹����� ��� û��||��
	static boolean search(int currentX, int currentY) {
		for (int i = 0; i < 4; i++) {
			int targetY = currentY + dy[i];
			int targetX = currentX + dx[i];

			if(targetY >= 0 && targetY<N && targetX >= 0 && targetX <M) {
				if(map[targetY][targetX] == 0) {
					return false;
				}
			}
		}
		return true;
	}


	//������ġ û��
	static void clean(int currentX, int currentY) {
		map[currentY][currentX] = 2;
	}

	//���ʹ������� ȸ��
	static int left(int currentX, int currentY, int dir) {

		//����
		if(dir == 0) {
			return 3;
		}
		//����
		else if(dir == 1) {
			return 0;
		}
		//����
		else if(dir == 2) {
			return 1;
		}
		//����
		else {
			return 2;
		}
	}

}
