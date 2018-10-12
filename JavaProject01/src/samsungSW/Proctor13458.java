package samsungSW;

import java.util.Scanner;

public class Proctor13458 {

	static int N;//시험장 수
	static int[] A; //각 시험장 사람 수
	static int B ,C;

	static long answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = new int[N];

		int temp = 0;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			temp = A[0];
			if(temp<A[i]) {
				temp = A[i];
			}
		}

		B = sc.nextInt();
		C = sc.nextInt();

		for (int i = 0; i < N; i++) {

			if((A[i]-B) >= 0) {
				
				answer += ((A[i]-B) / C);
				if(((A[i]-B) % C) != 0) {
					answer ++;
				}
				//	System.out.println(answer);
			}	
		}

		System.out.println(answer+N);	

	}


}


