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
		
		//��һ������
		ServerSocket serverSocket = new ServerSocket(12345);//���ܶ˿�12345����������
		Socket socket = serverSocket.accept();//������������
		InputStream is = socket.getInputStream();//����������
		//����·���´����ļ��������ڽ����ļ�����
		String lastName;//�ļ���׺��
		//�ܵ���
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//ȡ����׺��
		byte[] nameBuffer = new byte[1024];
		int nameLen;
		while((nameLen = is.read(nameBuffer))!=-1) {
			baos.write(nameBuffer, 0, nameLen);
		}
		lastName = baos.toString();
		//ʹ�ú�׺�������ļ�����
		File file = new File("Server"+"."+lastName);
		file.createNewFile();
		
		//�ر���Դ
		baos.close();
		is.close();
		socket.close();
		serverSocket.close();
		
		//�ڶ�������
		//�������Ӳ�ʹ���¶˿ڽ����ļ�����
		serverSocket = new ServerSocket(12346);//���ܶ˿�12346����������
		socket = serverSocket.accept();//������������
		is = socket.getInputStream();//����������
		FileOutputStream fileos = new FileOutputStream(file);
		//����������������Ȼ������Դ�ж�ȡ����
		byte[] buffer = new byte[1024];
		int len;
		while((len = is.read(buffer))!=-1) {
			//���������е�������������ǰ׼���õ��ļ�������д��
			fileos.write(buffer, 0, len);
		}
		System.out.println("�ɹ����գ�");
		//�ر���Դ
		fileos.close();
		is.close();
		socket.close();
		serverSocket.close();
	}

}
