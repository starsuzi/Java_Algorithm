package review;

import java.util.Arrays;
import java.util.Scanner;


//���� 1759
//https://www.acmicpc.net/problem/1759

public class Password {
	
	static int L, C;
	static char[] pass;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		 L = sc.nextInt();
		 C = sc.nextInt();
		 
		 pass = new char[C];
		 visited = new boolean[C];
		 
		 for (int i = 0; i < C; i++) {
			String temp = sc.next();
			pass[i] = temp.charAt(0);
		}
		// System.out.println(pass);
		 Arrays.sort(pass);
		// System.out.println(pass);

			 dfs(' ', 0, "", 0, 0);

		
	}
	
	static public void dfs(char current, int depth, String answer, int mo, int ja) {
		
		if(depth==L) {
			if(mo >= 1 && ja >= 2) {
				System.out.println(answer);
				return;				
			}

		}
		
		//1.�湮üũ
	
		//2.����ȱ�
		for (int i = 0; i < C; i++) {
			//3.�����ִ±�
			if(pass[i]>current) {
				//4.����
				if(pass[i] == 'a'||pass[i] == 'e'|| pass[i] == 'o'|| pass[i] == 'u'|| pass[i] == 'i') {
					dfs(pass[i], depth+1, answer+pass[i], mo+1, ja);					
				} else {
					dfs(pass[i], depth+1, answer+pass[i], mo ,ja+1);
				}

			}
		}
		
		//5.�湮����
		
		

	}

}
