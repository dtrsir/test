package lanqiao;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// �ڴ��������Ĵ���...
		char[][] number = new char[30][30];
		for (int i = 0; i < number.length; i++) {
			number[i] = scan.nextLine().toCharArray();
		}
		scan.close();
		System.out.println((int) ' ');
		
		  //������� 
		for(int i = 0;i<number.length;i++) { for(int j =
		  0;j<number[i].length;j++) { System.out.print(number[i][j]+" "); }
		  System.out.println(); }
		  
		 

	}
}