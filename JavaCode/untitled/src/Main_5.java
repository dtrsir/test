import java.util.Scanner;
import java.util.Stack;

public class Main_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int count = sc.nextInt();
		int[] money = new int[count];
		for(int i = 0;i<money.length;i++) {
			money[i] = sc.nextInt();
		}
		int re=0;
		for(int x:money) {
			re+=x;
		}
		re-=total;
		int reTorget = 0;
		int i = 0;
		Stack<Integer> index = new Stack<Integer>();
		while(re!=reTorget) {
			reTorget+=money[i];
			if(reTorget<re) {
				index.push(i);
				System.out.println();
			}else if(reTorget>re) {
				index.pop();
				reTorget-=money[i];
				System.out.print(reTorget);
			}
			i++;
			if(i>=money.length) {
				i=0;
			}
		}
		System.out.println(index);

	}

}
