package com.zhongzheng.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
	DatagramSocket socket = null;//���Ͷ�����
	private int port;//���ܶ˿�
	private String msgFrom;//���Ͷ�����
	
	public TalkReceive(int port, String msgFrom) {
		super();
		this.port = port;
		this.msgFrom = msgFrom;
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {//ѭ�����ܷ��Ͷ˷����ĵ���Ϣ
			byte[] buffer = new byte[1024];//������
			DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//�����Ͷ˵����ݰ������뻺����
			try {
				socket.receive(packet);//���ܷ��Ͷ˷��������ݰ���
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] data = packet.getData();
			String receviteData = new String(data, 0, data.length);
			System.out.println(receviteData.equals("bye"));
			System.out.println(msgFrom+":"+receviteData);
			if(receviteData.contains("bye")) {
				break;
			}
		}	
		socket.close();
	}
}
