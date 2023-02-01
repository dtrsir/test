package com.zhongzheng.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class upload {
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		/*开始第1次连接*/
		String fileType;
		//连接到指定服务器
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
		//创建输出流
		OutputStream ops = socket.getOutputStream();
		//创建一个文件对象
		File file = new File("local.jpg");
		//拿到文件的类型
		if(file.exists()) {
			fileType = getLastName(file);
		}else {
			System.out.println("路径下该文件不存在！");
			return ;
		}
		//告诉服务器文件的类型，让服务器提前准备好盒子
		ops.write(fileType.getBytes());
		//关闭资源
		ops.close();
		socket.close();
		
		
		/*开始第2次连接*/
		//连接到指定服务器
		socket = new Socket(InetAddress.getByName("127.0.0.1"), 12346);
		//创建输出流
		ops = socket.getOutputStream();
		//读取文件
		FileInputStream fis = new FileInputStream(file);
		//判断文件是否存在
		if(file.exists()) {
			//上传
			byte[] buffer = new byte[1024];
			int len;
			while((len=fis.read(buffer))!=-1) {
				ops.write(buffer, 0, len);
			}
			System.out.println("上传成功！");
		}else {
			System.out.println("路径下该文件不存在！");
		}
		//关闭资源
		fis.close();
		ops.close();
		socket.close();
		
	}
	//拿到文件的后缀名
	public static String getLastName(File file) {
		String name = file.getName();
		String[] nameAndLastName = name.split("\\.");
		return nameAndLastName[1];
	}
}
