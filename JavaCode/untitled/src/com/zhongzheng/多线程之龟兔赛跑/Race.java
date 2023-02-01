package com.zhongzheng.多线程之龟兔赛跑;

public class Race implements Runnable {
	
	//胜者
	private static String winner;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<=100;i++) {
			
			
			if(gameOver(i)) {
				break;
			}
			
			if(Thread.currentThread().getName().equals("兔子") && i%10==0) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
			
		}
	}
	
	//判断比赛是否结束
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
		new Thread(race,"兔子").start();
		new Thread(race,"乌龟").start();
	}

}
