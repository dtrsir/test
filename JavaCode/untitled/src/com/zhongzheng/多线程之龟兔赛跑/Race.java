package com.zhongzheng.���߳�֮��������;

public class Race implements Runnable {
	
	//ʤ��
	private static String winner;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<=100;i++) {
			
			
			if(gameOver(i)) {
				break;
			}
			
			if(Thread.currentThread().getName().equals("����") && i%10==0) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->����"+i+"��");
			
		}
	}
	
	//�жϱ����Ƿ����
	public boolean gameOver(int stets) {
		if(winner!=null) {
			return true;
		}{
			if(stets>=100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner is"+winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Race race = new Race();
		new Thread(race,"����").start();
		new Thread(race,"�ڹ�").start();
	}

}
