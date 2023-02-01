import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetTest01 {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		ByteArrayOutputStream bais = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while((len=is.read(buffer))!=-1) {
			bais.write(buffer, 0, len);
		}
		System.out.println(bais.toString());
		
	}

}
