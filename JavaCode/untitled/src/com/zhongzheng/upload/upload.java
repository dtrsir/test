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
		/*��ʼ��1������*/
		String fileType;
		//���ӵ�ָ��������
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
		//���������
		OutputStream ops = socket.getOutputStream();
		//����һ���ļ�����
		File file = new File("local.jpg");
		//�õ��ļ�������
		if(file.exists()) {
			fileType = getLastName(file);
		}else {
			System.out.println("·���¸��ļ������ڣ�");
			return ;
		}
		//���߷������ļ������ͣ��÷�������ǰ׼���ú���
		ops.write(fileType.getBytes());
		//�ر���Դ
		ops.close();
		socket.close();
		
		
		/*��ʼ��2������*/
		//���ӵ�ָ��������
		socket = new Socket(InetAddress.getByName("127.0.0.1"), 12346);
		//���������
		ops = socket.getOutputStream();
		//��ȡ�ļ�
		FileInputStream fis = new FileInputStream(file);
		//�ж��ļ��Ƿ����
		if(file.exists()) {
			//�ϴ�
			byte[] buffer = new byte[1024];
			int len;
			while((len=fis.read(buffer))!=-1) {
				ops.write(buffer, 0, len);
			}
			System.out.println("�ϴ��ɹ���");
		}else {
			System.out.println("·���¸��ļ������ڣ�");
		}
		//�ر���Դ
		fis.close();
		ops.close();
		socket.close();
		
	}
	//�õ��ļ��ĺ�׺��
	public static String getLastName(File file) {
		String name = file.getName();
		String[] nameAndLastName = name.split("\\.");
		return nameAndLastName[1];
	}
}
