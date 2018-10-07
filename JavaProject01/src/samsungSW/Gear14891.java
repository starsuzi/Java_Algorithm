package samsungSW;

import java.util.Scanner;

public class Gear14891 {

	static int[] g1;
	static int[] g2;
	static int[] g3;
	static int[] g4;
	static int K;
	static int gNum;
	static int d;
	static int score =0;
	static int[] flag;

	public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);

		g1 = new int[8];
		g2 = new int[8];
		g3 = new int[8];
		g4 = new int[8];

		flag = new int[5];

		String temp;

		temp = sc.nextLine();
		gInput(g1, temp);
		temp = sc.nextLine();
		gInput(g2, temp);
		temp = sc.nextLine();
		gInput(g3, temp);
		temp = sc.nextLine();
		gInput(g4, temp);

		K = sc.nextInt();

		for (int i = 0; i < 8; i++) {
			//	System.out.print(g1[i]);
		}
		for (int i = 0; i < 8; i++) {
			//	System.out.print(g2[i]);
		}

		while(K>0) {
			
			//flag 초기화
			for (int i = 0; i < flag.length+1; i++) {
				flag[i] = 0;
			}
			
			gNum = sc.nextInt();
			d = sc.nextInt();

			rotate(d,select(gNum));
			isRotate(gNum);
			


			K--;
		}

		//System.out.println(score);
	}

	static void isRotate(int num) {
		if(num == 1) {
			flag[2] = 1;
		}
		else if(num == 4) {
			flag[3] = 1;
		} 
		else if(num == 2) {
			flag[1] = 1;
			flag[3] = 1;
		}
		else if(num == 3) {
			flag[2] = 1;
			flag[4] = 1;
		}
	}
	
	static void gInput (int[] g,String temp){
		for (int i = 0; i < 8; i++) {
			if(temp.charAt(i) == '0') {
				g[i] = 0;	
			}
			else {
				g[i] = 1;
			}

		}
	}

	static void rotate(int dir, int[] g) {
		
		if(dir == 1) {
			//시계방향
			g[0] = g[7];
			for (int i = 0; i < g.length -1; i++) {
				g[i+1] = g[i];
			}
		}
		else {
			//반시계방향
			g[7] = g[0];
			for (int i = 0; i < g.length; i++) {
				g[i]=g[i+1];
			}
		}
	}

	static void calculate() {
		if(g1[0] == 1) {
			score += 1;
		}
		else if(g2[0] == 1) {
			score += 2;
		}
		else if(g3[0] == 1) {
			score += 4;
		}
		else if(g4[0] == 1) {
			score += 8;
		}

	}

	static boolean checkSame(int[] g_a, int[] g_b) {
		if(g_a[2] == g_b[2]) {
			// 같은 극이면  false
			return false;
		}
		else {
			//다른 극
			return true;
		}
	}

	static int[] select(int num) {
		if(num == 1) {
			return g1;
		}
		else if(num == 2) {
			return g2;
		}
		else if(num == 3) {
			return g3;
		}
		else {
			return g4;
		}
	}

}
