package samsungSW;

import java.util.Scanner;

public class Gear14891 {

	static int[] g1;
	static int[] g2;
	static int[] g3;
	static int[] g4;

	static int[] rg1;
	static int[] rg2;
	static int[] rg3;
	static int[] rg4;
	static int K;
	static int gNum;
	static int d;
	static int score =0;

	public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);

		g1 = new int[8];
		g2 = new int[8];
		g3 = new int[8];
		g4 = new int[8];

		rg1 = new int[8];
		rg2 = new int[8];
		rg3 = new int[8];
		rg4 = new int[8];

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

		rg1 = g1;
		rg2 = g2;
		rg3 = g3;
		rg4 = g4;

		for (int i = 0; i < 8; i++) {
			//	System.out.print(g1[i]);
		}
		for (int i = 0; i < 8; i++) {
			//	System.out.print(g2[i]);
		}

		while(K>0) {

			//System.out.println();

			gNum = sc.nextInt();
			d = sc.nextInt();

			canRotate(gNum, d);

			g1 = rg1;
			g2 = rg2;
			g3 = rg3;
			g4 = rg4;

			K--;
			
	/*		
			for (int i = 0; i < 8; i++) {	
			System.out.print(g1[i]);
			}
			System.out.println();
			for (int i = 0; i < 8; i++) {
				System.out.print(g2[i]);
			}
			System.out.println();
			for (int i = 0; i < 8; i++) {
				System.out.print(g3[i]);
			}
			System.out.println();
			for (int i = 0; i < 8; i++) {
				System.out.print(g4[i]);
			}
			System.out.println();*/
			
		}

		calculate();


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

	static void canRotate(int num, int dir) {
		
		int g1_2 = g1[2]; 
		int g1_6 = g1[6];
		int g2_2 = g2[2];
		int g2_6 = g2[6];
		int g3_2 = g3[2];
		int g3_6 = g3[6];
		int g4_2 = g4[2];
		int g4_6 = g4[6];
		
		//배열 값을 바로 비교하지 말자
		
		if(num == 1) {

			if(g1_2!= g2_6) {
	
				rg2 = rotate((-1*dir), rg2);
				if(g2_2!= g3_6) {
					

					rg3 = rotate((dir), rg3);
					if(g3_2!= g4_6) {

						rg4 = rotate((-1*dir), rg4);	
					}
				}
			}

			rg1 = rotate(dir, rg1);

		}
		else if(num ==2) {

			if(g2_2!= g3_6) {
				rg3 = rotate((-1*dir), rg3);
				if(g3_2!= g4_6) {
					rg4 = rotate((dir), rg4);	
				}
			}
			if(g2_6!= g1_2) {
				rg1 = rotate((-1*dir), rg1);
			}
			rg2 = rotate(dir, rg2);
		}

		else if(num == 3) {

			if(g3_6!= g2_2) {
				rg2 = rotate((-1*dir), rg2);
				if(g2_6!= g1_2) {
					rg1 = rotate((dir), rg1);
				}
			}
			if(g3_2!= g4_6) {
				rg4 = rotate((-1*dir), rg4);	
			}
			rg3 = rotate(dir, rg3);
		}

		else if(num == 4) {

			if(g4_6!= g3_2) {
				rg3 = rotate((-1*dir), rg3);
				if(g3_6!= g2_2) {
					rg2 = rotate((dir), rg2);
					if(g2_6!= g1_2) {
						rg1 = rotate((-1*dir), rg1);	
					}
				}
			}
			rg4 = rotate(dir, rg4);
		}
	}

	static int[] rotate(int dir, int[] g) {
		int temp;
		int[] rg = new int[8];
		if(dir == 1) {
			//시계방향
			temp = g[7];
			for (int i = 0; i < g.length -1; i++) {
				rg[i+1] = g[i];
			}

			for (int i = 0; i < rg.length; i++) {
				g[i] = rg[i];
			}

			g[0] = temp;
		}
		else if(dir == -1) {
			//반시계방향
			temp = g[0];
			for (int i = 0; i < g.length -1 ; i++) {
				rg[i]=g[i+1];
			}

			for (int i = 0; i < rg.length; i++) {
				g[i] = rg[i];
			}
			g[7] = temp;
		}

		//System.out.println("print");
		//System.out.println("rotate");
		for (int i = 0; i < 8; i++) {
		//	System.out.print(g[i]);
		}
		//System.out.println();
		//	System.out.println("print");

		return g;

	}

	static void calculate() {
		if(g1[0] == 1) {
			score += 1;
		}
		if(g2[0] == 1) {
			score += 2;
		}
		if(g3[0] == 1) {
			score += 4;
		}
		if(g4[0] == 1) {
			score += 8;
		}

		System.out.println(score);

	}


}
