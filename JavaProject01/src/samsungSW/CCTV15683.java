package samsungSW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CCTV15683 {

	static int N,M;
	static int[][] map;
	static int[][] copiedMap;
	static int[][] originMap;
	static int allNum;
	static ArrayList<Integer> node = new ArrayList<>();
	static boolean[] visited;
	static int[] history;
	static int[] nodeint;
	static int result = Integer.MAX_VALUE;
	static int tempResult;
	static int[][] dfsmap;
	static int[][] tempCopiedMap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copiedMap = new int[N][M];
		originMap = new int[N][M];
		dfsmap = new int[N][M];
		tempCopiedMap = new int[N][M];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		allNum = countAll(map);
		

		visited = new boolean[allNum];
		history = new int[allNum];
		nodeint = new int[allNum];


		copiedMap = copy(map);
		call5(map);
		if(countAll(map) == 0) {
			result = squaredArea(map);
			System.out.println(result);
			return;
		}
		
		originMap = copy(map);

		for (int i = 0; i < allNum; i++) {
			nodeint[i] = node.get(i);
		}
		for (int i = 0; i < allNum; i++) {
			dfs(i,0);
		}
		System.out.println(result);
	}

	static void CCTV1(int current, int temp) {

		int currentY = current/M;
		int currentX = current%M;

		//2.연결된길
		for (int i = 0; i < 4; i++) {

			//3.갈수있는길

			if(i==0) {
				//동
				copiedMap = copy(map);
				east(currentY, currentX);
				temp = squaredArea(copiedMap);
				tempCopiedMap = copy(copiedMap);
				copiedMap = copy(map);
			}
			if(i==1) {
				//남
				south(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}

				copiedMap = copy(map);
			}
			if(i==2) {
				//서
				west(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}

				copiedMap = copy(map);
			}
			if(i==3) {
				//북
				north(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}

				copiedMap = copy(map);
			}

		}

		//1.방문체크
		copiedMap[currentY][currentX] = 1;
		//System.out.println();
		map = copy(tempCopiedMap);
		print(map);
	}

	static void CCTV2(int current, int temp) {

		int currentY = current/M;
		int currentX = current%M;

		for (int i = 0; i < 2; i++) {

			if(i==0) {
				//북
				copiedMap = copy(map);
				north(currentY, currentX);
				south(currentY, currentX);

				temp = squaredArea(copiedMap);
				tempCopiedMap = copy(copiedMap);

				copiedMap = copy(map);
			}
			if(i==1)  {
				//동
				east(currentY, currentX);
				west(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}
				copiedMap = copy(map);
			}



		}
		//1.방문체크
		copiedMap[currentY][currentX] = 2;
		//System.out.println();
		map = copy(tempCopiedMap);
		print(map);
	}

	static void CCTV3(int current,  int temp) {


		int currentY = current/M;
		int currentX = current%M;

		//2.연결된길
		for (int i = 0; i < 4; i++) {

			//3.갈수있는길

			if(i==0) {
				//북
				copiedMap = copy(map);
				north(currentY, currentX);
				east(currentY, currentX);

				temp = squaredArea(copiedMap);
				tempCopiedMap = copy(copiedMap);
				copiedMap = copy(map);
			}

			if(i==1)  {
				//동
				east(currentY, currentX);
				south(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}

				copiedMap = copy(map);

			}

			if(i == 2) {
				//남
				south(currentY, currentX);
				west(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}

				copiedMap = copy(map);
			}

			if(i==3) {
				//서
				west(currentY, currentX);
				north(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}
				copiedMap = copy(map);
			}


		}

		//1.방문체크
		copiedMap[currentY][currentX] = 3;
		//System.out.println();
		map = copy(tempCopiedMap);
		print(map);

	}

	static void CCTV4(int current, int temp) {

		int currentY = current/M;
		int currentX = current%M;

		//2.연결된길
		for (int i = 0; i < 4; i++) {

			//3.갈수있는길

			if(i==0) {
				//북
				copiedMap = copy(map);
				north(currentY, currentX);
				//동,서
				east(currentY, currentX);
				west(currentY, currentX);

				temp = squaredArea(copiedMap);
				tempCopiedMap = copy(copiedMap);
				copiedMap = copy(map);

			}
			if(i==1) {
				//남
				south(currentY, currentX);
				//동,서
				east(currentY, currentX);
				west(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}
				copiedMap = copy(map);
			}
			if(i==2) {
				//동
				east(currentY, currentX);
				//남, 북
				north(currentY, currentX);
				south(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}
				copiedMap = copy(map);
			}

			if(i==3) {
				//서
				west(currentY, currentX);
				//남,북
				north(currentY, currentX);
				south(currentY, currentX);

				if(temp>squaredArea(copiedMap)) {
					temp = squaredArea(copiedMap);
					tempCopiedMap = copy(copiedMap);
				}
				copiedMap = copy(map);
			}
		}

		//1.방문체크
		copiedMap[currentY][currentX] = 4;
		//System.out.println();
		map = copy(tempCopiedMap);
		print(map);
	}

	static void CCTV5(int current) {

		int currentY = current/M;
		int currentX = current%M;

		//2.연결된길
		for (int i = 0; i < 4; i++) {

			//3.갈수있는길

			if(i==0) {
				//동
				copiedMap = copy(map);
				east(currentY, currentX);
				map = copy(copiedMap);
			}
			if(i==1) {
				//남
				south(currentY, currentX);
				map = copy(copiedMap);
			}
			if(i==2) {
				//서

				west(currentY, currentX);
				map = copy(copiedMap);
			}
			if(i==3) {
				//북

				north(currentY, currentX);
				map = copy(copiedMap);
			}

		}

		//1.방문체크
		copiedMap[currentY][currentX] = 5;
		//	print(copiedMap);
		result = squaredArea(copiedMap);
		map = copy(copiedMap);

	}

	//dfs
	static void dfs(int current, int depth) {

		int temp;
		//0.도달
		if(depth == nodeint.length-1) {
			
			history[depth] = nodeint[current];

			for (int i = 0; i < history.length; i++) {
				if(map[(history[i])/M][(history[i])%M] == 1) {
					
					CCTV1((history[i]), 0);
				}
				else if(map[(history[i])/M][(history[i])%M] == 2) {
					
					CCTV2((history[i]), 0);
				}
				else if(map[(history[i])/M][(history[i])%M] == 3) {
				
					CCTV3((history[i]), 0);
				}
				else if(map[(history[i])/M][(history[i])%M] == 4) {
					
					CCTV4((history[i]), 0);
				}
			}
			
			temp = squaredArea(map);
			if(temp < result) {
				result = temp;
			}
			
			map = copy(originMap);

			return;


		}
		//1.방문체크
		visited[current] = true;
		history[depth] = nodeint[current];
		//2.연결된길
		for (int i = 0; i <nodeint.length; i++) {
			//3.갈수있는길	
			if(visited[i] == false) {
				//4.간다
				dfs(i, depth+1);
			}
		}
		//5.방문해제
		visited[current] = false;
	}

	static int countAll(int[][] temp) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j] == 1 || temp[i][j] == 2 || temp[i][j] == 3 || temp[i][j] == 4 ) {
					node.add(i*M+j);
					count++;
				}
			}
		}
		return count;
	}

	static void east(int currentY, int currentX) {
		int tempX = currentX;
		int tempY = currentY;
		//동
		//System.out.println("동");
		while(true) {

			if(copiedMap[tempY][tempX] == 6 || tempX > M-2) {
				if(copiedMap[tempY][tempX] == 0) {
					copiedMap[tempY][tempX] = 7;	
				}
				break;
			}


			if(copiedMap[tempY][tempX] == 0) {
				copiedMap[tempY][tempX] = 7;		
			}

			tempX++;

		}
		print(copiedMap);

	}

	static void south(int currentY, int currentX) {
		//System.out.println("남");
		int tempX = currentX;
		int tempY = currentY;
		while(true) {
			if(copiedMap[tempY][tempX] == 6 || tempY > N - 2) 
			{
				if(copiedMap[tempY][tempX] == 0) {
					copiedMap[tempY][tempX] = 7;	
				}
				break;
			}
			if(copiedMap[tempY][tempX] == 0) {
				copiedMap[tempY][tempX] = 7;		
			}
			tempY++;
		}
		print(copiedMap);
	}


	static void west(int currentY, int currentX) {
		//서
		//System.out.println("서");
		int tempX = currentX;
		int tempY = currentY;
		while(true) {
			if(copiedMap[tempY][tempX] == 6 || tempX < 1) {
				if(copiedMap[tempY][tempX] == 0 ) {
					copiedMap[tempY][tempX] = 7;	
				}

				break;
			}
			if(copiedMap[tempY][tempX] == 0) {
				copiedMap[tempY][tempX] = 7;		
			}
			tempX --;
		}
		print(copiedMap);
	}

	static void north(int currentY, int currentX) {
		//북
		//System.out.println("북");
		int tempX = currentX;
		int tempY = currentY;
		while(true) {
			if(copiedMap[tempY][tempX] == 6 || tempY<1) {
				if(copiedMap[tempY][tempX] == 0) {
					copiedMap[tempY][tempX] = 7;
				}

				break;
			}
			if(copiedMap[tempY][tempX] == 0) {
				copiedMap[tempY][tempX] = 7;		
			}
			tempY -- ;
		}
		print(copiedMap);

	}

	static void print(int[][] temp) {
		//System.out.println();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				//System.out.print(temp[i][j]+" ");
			}
		//	System.out.println();
		}
	}

	static int[][] copy(int[][] temp) {
		int[][] cMap = new int[N][M];

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				cMap[i][j] = temp[i][j];
			}
		}
		return cMap;
	}

	static int squaredArea(int[][] temp) {
		int count = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static void call5 (int[][] temp){
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 5) {
					//queue.add(new CCTVPosition(i, j));
					CCTV5(i*M+j);
				}
			}
		}
	}

}
