package com.zhongzheng.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
	DatagramSocket socket = null;
	private BufferedReader reader = null;
	private int fromPort;
	private String toIP;
	private int toPort;
	
	public TalkSend(int fromPort, String toIP, int toPort) {
		super();
		this.fromPort = fromPort;
		this.toIP = toIP;
		this.toPort = toPort;
		try {
			socket = new DatagramSocket(fromPort);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				String data = reader.readLine();
				byte[] datas = data.getBytes();
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));
				socket.send(packet);
				if("bye".equals(data)) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		socket.close();
	}
}
