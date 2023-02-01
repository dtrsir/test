
public class Test01 {
	public static void main(String[] args) {
		int num = putOut(10);
		System.out.println(num);
	}
	public static int putOut(int n) {
		Integer[] chileden = new Integer[n];
		for(int i = 0;i<n;i++) {
			chileden[i]=i+1;
		}
		int flag = 1;
		while(n!=1) {
			for(int i = 0;i<chileden.length;i++,flag++) {
				if(chileden[i]==0) {
					flag--;
					continue;
				}
				if(flag%3==0) {
					chileden[i] = 0;
					--n;
				}
			}
		}
		for(Integer x:chileden) {
			if(x!=0) {
				return x;
			}
		}
		return 0;
	}
}
