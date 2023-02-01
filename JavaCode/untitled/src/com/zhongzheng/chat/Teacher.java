package com.zhongzheng.chat;

public class Teacher {

	public static void main(String[] args) {
		new Thread(new TalkSend(5555, "localhost", 8000)).start();;
		new Thread(new TalkReceive(9000, "Ñ§Éú")).start();;
	}

}
