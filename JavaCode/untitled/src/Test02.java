import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int c;
		while((c = sc.nextInt())!=0) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Integer>> it = set.iterator();
		int times = 0, times1 = 0;
		int number = 0, number1 = 0;
		while(it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			if(times<entry.getValue()) {
				times = entry.getValue();
				number = entry.getKey();
			}else if(times==entry.getValue()) {
				times1 = entry.getValue();
				number1 = entry.getKey();
			}
		}
		System.out.println(number+"出现"+times+"次");
		if(times==times1) {
			System.out.println(number1+"出现"+times1+"次");
		}	
	}
}