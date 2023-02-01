package com.zhongzheng.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
	DatagramSocket socket = null;//发送端链接
	private int port;//接受端口
	private String msgFrom;//发送端姓名
	
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
		while(true) {//循环接受发送端发来的的消息
			byte[] buffer = new byte[1024];//缓冲区
			DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//将发送端的数据包裹放入缓冲区
			try {
				socket.receive(packet);//接受发送端发来的数据包裹
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
