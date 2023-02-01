package com.zhongzheng.chat;

public class Stduent {
	public static int a;
	public static void main(String[] args) {
		new Thread(new TalkSend(7777, "localhost", 9000)).start();;
		new Thread(new TalkReceive(8000, "¿œ ¶")).start();
	}
}
