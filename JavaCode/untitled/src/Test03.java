import java.util.LinkedHashSet;

public class Test03 {

	public static void main(String[] args) {
		LinkedHashSet<String> set1 = new LinkedHashSet<String>();
		LinkedHashSet<String> set2 = new LinkedHashSet<String>();
		set1.add("George");
		set1.add("Jim");
		set1.add("John");
		set1.add("Blake");
		set1.add("Kevin");
		set1.add("Michael");
		set2.add("George");
		set2.add("Katie");
		set2.add("Kevin");
		set2.add("Michael");
		set2.add("Ryan");
		LinkedHashSet<String> set11 = (LinkedHashSet<String>) set1.clone();
		LinkedHashSet<String> set22 = (LinkedHashSet<String>) set2.clone();
		set1.addAll(set2);
		System.out.println("并集"+set1);
		set1.clear();
		set1.addAll(set11);
		set1.removeAll(set2);
		System.out.println("差集"+set1);
		set1.clear();
		set1.addAll(set11);
		set1.retainAll(set2);
		System.out.println("交集"+set1);
	}
}
