import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Test04 {

	public static void main(String[] args) throws IOException {
		/* ��дһ�����򣬴Ӷ������ļ��ж�ȡ���ʣ��������в��ظ��ĵ��ʰ�������ʾ��
		 * �ı��ļ�����Ϊ�����в������ݡ� */
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
