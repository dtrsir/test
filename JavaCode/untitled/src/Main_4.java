import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main_4 {
	/*
	 * 选出1到200之间的素数，尾数相同的相乘得出结果后再和其他尾数的结果相加。
	 * （最好用大整型数计算、存储）
	 * 比如：1到20之间的素数相乘，11+2+3*13+5+7*17+19=195
	 */
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 1;i<=20;i++) {
			if(GCD(i)) {
				set.add(i);
			}
		}
		int re = 0;
		Iterator<Integer> its = set.iterator();
		for(Integer x : set) {
			int tmp;
			if(x<10) {
				tmp = x;
			}else if(x<100){
				tmp = x % 10;
			}else {
				tmp = x % 100;
			}
			Iterator<Integer> it = set.iterator();
			System.out.println("==========");
			for(Integer c:set) {
				if(x!=c) {
					if(c<10) {
						if(tmp==c) {re+=c*x;
						set.remove(c);}
					}else if(c<100){
						if(tmp==c%10) {re+=c*x;
						System.out.println(c+"+"+x+"+"+re);}
					}else {
						if(tmp==c%100) {re+=c*x;
						System.out.println(c+"+"+x+"+"+re);}
					}
				}
			}
		}
		System.out.println(re);
	}
	
	public static boolean GCD(int x) {
		for(int j = 2;j<=x/2;j++) {
			if(x%j==0) {
				return false;
			}
		}
		return true;
	}
}