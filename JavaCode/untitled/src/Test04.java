import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Test04 {

	public static void main(String[] args) throws IOException {
		/* 编写一个程序，从二进制文件中读取单词，并将所有不重复的单词按升序显示。
		 * 文本文件被作为命令行参数传递。 */
		File file = new File("src/Test.bat");
		FileReader ips = new FileReader(file);
		Set<String> set = new HashSet<String>();
		int c = 0;
		StringBuffer words = new StringBuffer();
		while((c=ips.read())!=-1) {
			words.append((char)c);
		}
		String word = words.substring(0, words.length());
		String[] word1 = word.split("[\\s+\\p{Punct}]");
		for(String x : word1) {
			set.add(x);
		}
		System.out.println(set);
	}
}
