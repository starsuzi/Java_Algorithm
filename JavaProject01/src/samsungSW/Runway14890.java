package samsungSW;

import java.util.Scanner;


public class Runway14890 {

	static int N,L;
	static int[][]map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();

		map = new int[N][N];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				map[y][x]=sc.nextInt();
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				//System.out.println(map[y][x]);
			}
			//System.out.println();
		}

		rowCheck(map);
		colCheck(map);

	}

	static int colCheck(int m[][]) {

		int colCount=0;
		int count =0 ;
		int[] row = new int[N];


		for (int x = 0; x < N; x++) {
			row[x] = map[0][x];
		}

		return colCount;

	}



	static int rowCheck(int m[][]) {
		int rowCount=0;
		int count =0 ;
		for (int y = 0; y < N; y++) {
			int mapY =map[y][0];
			count =0;
			for (int x = 0; x < N; x++) {
				if(mapY == map[y][x]) {
					count++;
					if(count==N) {
						rowCount++;
					}
				}
			}
		}
		return rowCount;
	}

}
