package samsungSW;

import java.util.Scanner;

public class Dragoncurve15685 {

	static int N;
	static int x,y,d,g;
	static int endX, endY;
	static int startX, startY;
	static int standardY, standardX;
	static int[][] map, history;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		map = new int[101][101];
		history = new int[101][101];
		int[] standard = new int [2];
		N = sc.nextInt();

		while(N>0) {
			x = sc.nextInt();
			y = sc.nextInt();
			d = sc.nextInt();
			g = sc.nextInt();

			startY = y;
			startX = x;

			start(d,startY,startX);

			//2세대~
			int count = 0;
			while(count<g) {

				//0세대
					map[startY][startX] = 1;
					map[endY][endX] = 1;

				
				//1세대
				
					map[2][4] = 2;	
				
				
				for (int y = 0; y < 101; y++) {
					for (int x = 0; x < 101; x++) {
						if(map[y][x] == 2) {
							standardY = y;
							standardX = x;
						}
					}
				}

				getStandard(endY, endX);

				for (int y = 0; y < 101; y++) {
					for (int x = 0; x < 101; x++) {
						if(map[y][x] == 1) {
							//	System.out.println("rotate");
							//	System.out.println("r(x,y)"+"("+x+","+y+")");
							rotate(y, x);			
						}
					}
				}

				count++;
			}

			for (int y = 0; y < 101; y++) {
				for (int x = 0; x < 101; x++) {
					if(map[y][x] == 2 || map[y][x] == 1) {
						history[y][x] = 1;
						map[y][x] = 0;
					}
				}
			}


		}

		for (int y = 0; y < 101; y++) {
			for (int x = 0; x < 101; x++) {
				if(history[y][x] == 1 ) {
					System.out.println("(x,y)"+"("+x+","+y+")");
				}
			}
		}

		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				System.out.print(history[y][x]);
			}
			System.out.println();
		}
		print();
	}



	static void print() {
		int count = 0;
		for (int y = 0; y < 101; y++) {
			for (int x = 0; x < 101; x++) {
				if(y+1<102 && x+1<102) {
					if(history[y][x] == 1 && history[y][x+1] == 1 && history[y+1][x] ==1 && history[y+1][x] == 1) {
						count++;
					}	
				}


			}
		}

		System.out.println(count);
	}

	static void start(int dir, int currentY, int currentX) {


		if(dir == 0) {
			endY = currentY;
			endX = currentX+1;
		}
		else if(dir == 1) {
			endY = currentY-1;
			endX = currentX;
		}
		else if(dir == 2) {
			endY = currentY;
			endX = currentX-1;			
		}
		else {
			endY = currentY+1;
			endX = currentX;
		}

	}

	static void getStandard(int currentY, int currentX) {

		int standard[] = new int[2];

		System.out.println("gets");
		System.out.println("2:(sx,sy)"+"("+standardX+","+standardY+")");

		map[standardY][standardX] = 1;
		standardY = standardY + (currentX - standardX);
		standardX = standardX + (standardY - currentY);
		map[standardY][standardX] = 2;
		System.out.println("2:(tx,ty)"+"("+standardX+","+standardY+")");
		//return standard;
	}

	static void rotate(int currentY, int currentX) {

		int targetY;
		int targetX;

		targetX = standardX + (standardY - currentY);
		targetY = standardY + (currentX - standardX);

		if(targetY >=0 && targetX>=0 && targetY<= 100 && targetX<=100) 
		{
			map[targetY][targetX] = 1;
		}
	}


}
