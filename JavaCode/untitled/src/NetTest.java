import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NetTest {
	public static void main(String[] args) throws IOException {
		InetAddress serivesIP = InetAddress.getByName("127.0.0.1");
		int port = 9999;
		Socket socket = new Socket(serivesIP, port);
		OutputStream os = socket.getOutputStream();
		Scanner sc = new Scanner(System.in);
		String st = null;
		
		 while(!(st = sc.nextLine()).equals("0")) {
			 os.write(st.getBytes());
		 }
		 
		sc.close();
		os.close();
		socket.close();
	}

}

