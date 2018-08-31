package review;

import java.util.Scanner;

//10819
//https://www.acmicpc.net/problem/10819

public class Max {
	
	static int N;
	static int[] arr;
	static int[] history;
	static boolean[] visited;
	static int MinNum = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		history = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			//System.out.print(arr[i] +" ");
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i,0);
		}
		
		System.out.println(MinNum);
		
	}
	
	public static void dfs(int current,int depth) {	
		//0.도달했는지
		if(depth == N-1) {
			
			history[depth] = arr[current]; 
			
			int sum = 0;
			
			
			for (int i = 0; i < history.length; i++) {
				//System.out.print(history[i]+" ");
			}//System.out.println();
			
			for (int i = 0; i < N-1; i++) {
				int diff = Math.abs(history[i]-history[i+1]);
				sum = sum+diff;
			}
			
			if(sum>MinNum) {
				MinNum = sum;
			}
			else {
				return;
				
			}
		}
		
		//1.방문체크
		
		visited[current] = true;
		history[depth] = arr[current]; 
		//System.out.println("current: "+current + ", "+ arr[current]);
		
		//2.연결된길
		for (int i = 0; i < N; i++) {
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
