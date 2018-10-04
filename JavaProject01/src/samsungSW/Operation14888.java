package samsungSW;

import java.util.Scanner;

public class Operation14888 {

	static int N;
	static int[] map;
	static int[] oper;
	static int indexOfOper;
	static boolean[] visited;
	static char[] arrayOfoper;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[2*N-1];
		oper = new int[4];
		visited = new boolean[2*N-1];
		arrayOfoper = new char[N-1];


		//숫자
		for (int i = 0; i < 2*N-1; i++) {
			if(i%2==0) {
				map[i] = sc.nextInt();	
				visited[i] = true;
			}
		}

		//연산자

		int count = 0;
		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();

		}

		//연산자 새로운 배열
		int sum = 0;
		for (int j = 0; j < 4; j++) { 
				count = oper[j];
				while(count>0) {
					for (int i = sum ; i < N-1; i++) {
						arrayOfoper[i] = intToOper(j);
						count--;
						System.out.println(arrayOfoper[i]);
						System.out.println(count);
					}	
					sum = sum+oper[j];
				}
				
		}


		//print
		for (int i = 0; i < 2*N-1; i++) {
			System.out.print(map[i]);
		}
		System.out.println();

		for (int i = 0; i < 4; i++) {
			System.out.print(oper[i]);
		}

		for (int i = 0; i < arrayOfoper.length; i++) {
			System.out.print(arrayOfoper[i]);
		}


	}

	static char intToOper (int n) {

		if(n == 0) {
			return '+';
		}
		else if(n==1) {
			return '-';
		}
		else if(n==2) {
			return '*';
		}
		else {
			return '/';
		}


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

	static void dfs(int current, int depth) {
		//0.도달했는지
		if(depth == map.length) {

		}
		//1.방문체크

		//2.연결된길
		for (int i = 0; i < map.length; i++) {
			//3.갈수있는길
			if(visited[i] == false) {
				//4.간다
				//dfs();
			}

		}

		//5.방문해지
	}


}
