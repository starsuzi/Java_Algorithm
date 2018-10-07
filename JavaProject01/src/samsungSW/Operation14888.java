package samsungSW;

import java.util.Scanner;

public class Operation14888 {

	static int N;
	static int[] number;
	static int[] oper;
	static int indexOfOper;
	static boolean[] visited;
	static int[] arrayOfoper;
	static int[] history;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		number = new int[N];
		oper = new int[4];
		visited = new boolean[N-1];
		arrayOfoper = new int[N-1];
		history = new int[N-1];


		//숫자
		for (int i = 0; i < N; i++) {
			
				number[i] = sc.nextInt();	
			
			
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
						//arrayOfoper[i] = intToOper(j);
						arrayOfoper[i] = j;
						count--;
					//	System.out.println(arrayOfoper[i]);
					//	System.out.println(count);
					}	
					sum = sum+oper[j];
				}
				
		}


		//print
		for (int i = 0; i < 2*N-1; i++) {
			//System.out.print(map[i]);
		}
		//System.out.println();

		for (int i = 0; i < 4; i++) {
			//System.out.print(oper[i]);
		}

		for (int i = 0; i < arrayOfoper.length; i++) {
		//	System.out.print(arrayOfoper[i]);
		}

		//dfs
		for (int i = 0; i < arrayOfoper.length; i++) {
			dfs(i,0); //i는 연산자
		}

		for (int i = 0; i < history.length; i++) {
		//	System.out.print(history[i]);
		}
		
		System.out.println(max);
		System.out.println(min);
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
		int a, b , result =0;
		//0.도달했는지
		if(depth == arrayOfoper.length-1) {
			
			history[depth] = arrayOfoper[current];
			
			for (int i = 0; i < history.length; i++) {
			//	System.out.print(history[i]+" ");
			}
			
			//System.out.println();
			
			for (int i = 0; i < number.length-1; i++) {
				a = number[i];
				if(i==0) {
					result = a;
				}
				
				b = number[i+1];
				result = calculate(history[i], result, b);
				
			}
			
			//System.out.println(result);
			
			if(result < min) {
				min = result;
			}
			
			if(result > max) {
				max = result;
			}
			
			return;
		}
		//1.방문체크
		//System.out.println();
		
		for (int i = 0; i < history.length; i++) {
	 //	System.out.print(history[i]);
		}
		
		visited[current]= true;
		history[depth] = arrayOfoper[current];
	//	System.out.println(current+"current"+arrayOfoper[current]+"arr[current]"+depth+"depth");
		
		//2.연결된길
		for (int i = 0; i < arrayOfoper.length; i++) {
			//3.갈수있는길
			if(visited[i] == false) {
				//4.간다
				dfs(i,depth+1);
			}
		}
		//5.방문해지
		visited[current] = false;
	}


}
