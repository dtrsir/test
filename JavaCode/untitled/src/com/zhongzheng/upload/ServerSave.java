package com.zhongzheng.upload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSave {

	public static void main(String[] args) throws IOException {
		
		//第一次连接
		ServerSocket serverSocket = new ServerSocket(12345);//接受端口12345的连接请求
		Socket socket = serverSocket.accept();//监听连接请求
		InputStream is = socket.getInputStream();//创建输入流
		//先在路径下创建文件盒子用于接收文件数据
		String lastName;//文件后缀名
		//管道流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//取出后缀名
		byte[] nameBuffer = new byte[1024];
		int nameLen;
		while((nameLen = is.read(nameBuffer))!=-1) {
			baos.write(nameBuffer, 0, nameLen);
		}
		lastName = baos.toString();
		//使用后缀名创建文件盒子
		File file = new File("Server"+"."+lastName);
		file.createNewFile();
		
		//关闭资源
		baos.close();
		is.close();
		socket.close();
		serverSocket.close();
		
		//第二次连接
		//更新连接并使用新端口接收文件数据
		serverSocket = new ServerSocket(12346);//接受端口12346的连接请求
		socket = serverSocket.accept();//监听连接请求
		is = socket.getInputStream();//创建输入流
		FileOutputStream fileos = new FileOutputStream(file);
		//创建缓冲区，方便等会从数据源中读取数据
		byte[] buffer = new byte[1024];
		int len;
		while((len = is.read(buffer))!=-1) {
			//将缓冲区中的数据向我们提前准备好的文件盒子中写入
			fileos.write(buffer, 0, len);
		}
		System.out.println("成功接收！");
		//关闭资源
		fileos.close();
		is.close();
		socket.close();
		serverSocket.close();
	}

}
