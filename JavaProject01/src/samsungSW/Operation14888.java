package samsungSW;

import java.util.Scanner;

public class Operation14888 {

	static int N;
	static int[] map;
	static int[] oper;
	static char[] finalOper;
	static String opers = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N];
		oper = new int[4];
		finalOper = new char[N-1];

		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}


		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < oper[j]; i++) {

			}	

		}

		System.out.println(opers);

	}

	
	static int calculate(int n, int a, int b) {

		if(n == 0) {
			return a+b;
		}
		else if(n==1) {
			return a-b;
		}
		else if(n==2) {
			return a*b;
		}
		else {
			return a/b;
		}
	
	}

}
