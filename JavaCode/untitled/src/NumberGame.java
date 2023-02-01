import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int count = 1;
		int total = 0;
		int tmp;
		int[][] matrix = new int[row][col];
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<col;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();

		for(int j =0;j<col;j++) {
			for(int i = 0, c1 = 0,c2 = matrix[i].length-1;i<row;i++) {
				
				while(matrix[i][c2]==0) {
					c2--;
				}
				while(matrix[i][c1]==0) {
					c1++;
				}
				if(matrix[i][c1]>matrix[i][c2]) {
					tmp = matrix[i][c2];
					matrix[i][c2] = 0;
					c2 = matrix[i].length-1;
				}else {
					tmp = matrix[i][c1];
					matrix[i][c1] = 0;
					c1 = 0;
				}
				total=total+tmp*(int)Math.pow(2, j+1);
			}
		}
		System.out.println(total);
	}
}
