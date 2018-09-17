package samsungSW;

import java.util.Scanner;

public class Robot14503 {

	static int N,M, r, c, d;
	static int[][] map;
	static int[] dx = {0,-1,0,+1}; //�� �� �� ��
	static int[] dy = {-1,0,+1,0};

	public static void main(String[] args) {
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



		dfs(c,r,d,transfer(d));	
		
		int count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				//	System.out.print(map[y][x]);
				
				if(map[y][x] == 2) {
					count++;
				}
			}
			//System.out.println();
		}
		
		System.out.println(count);

	}

	static void dfs(int currentX, int currentY, int dir, int depth) {

		System.out.println(dir);
		dirCheck(dir);
		System.out.println("(currentx, currenty) ("+currentY+","+currentX+")");

		//1.�湮üũ
		if(map[currentY][currentX] == 0) {
			map[currentY][currentX] = 2;
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}

		//2.����ȱ�
		for (int i = d+1; i < d+5; i++) {
			int count = 0;
			int targetY = currentY + dy[i%4];
			int targetX = currentX + dx[i%4];
			//3.�����ִ±�
			if(targetY>=0 && targetX>=0 && targetX<M && targetY<N) {
				count++;
				if(map[targetY][targetX] == 0) {
					//4.����
					dfs(targetX, targetY, i%4, depth+1);
				}


				//else {
					if(count==3) {
						//�׹��� ��� ���̳� �̹� û��
						//��������
						//�ش��� �ȵǾ ������ ȸ�� ���� �߰�
						int newtargetY = currentY + dy[((i%4)+2)%4];
						int newtargetX = currentX + dx[((i%4)+2)%4];
						
						if(map[newtargetY][newtargetX] == 2) {
							dfs(newtargetX, newtargetY, ((i%4)+2)%4, depth+1);		
						}
						//���� �Ұ���
						else {
							return;
						}
					}
				//}

			}

		}
	}
	static int transfer(int dir) {
		if(dir == 1) {
			System.out.println("��");
			return 3;
		}
		else if(dir == 3) {
			System.out.println("��");
			return 1;
		}
		else if(dir == 0) {
			System.out.println("��");
			return 0;
		}
		else {
			System.out.println("��");
			return 2;
		}
	}

	static void dirCheck(int dir) {

		if(dir == 2) {
			System.out.println("��");
		}
		else if(dir == 1) {
			System.out.println("��");
		}
		else if(dir == 0) {
			System.out.println("��");
		}
		else {
			System.out.println("��");
		}

	}

}
