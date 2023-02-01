import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class selaTitck {

	public static void main(String[] args) {
		TicketWindow tw = new TicketWindow();
		new Thread(tw, "window1").start();
		new Thread(tw, "window2").start();
		new Thread(tw, "window3").start();
	}
}

class TicketWindow implements Runnable{
	private int ticket = 20;
	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		while(ticket > 0) {
			sellTicket();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void sellTicket() {
		lock.lock();
		if(ticket > 0) {
			System.out.println(Thread.currentThread().getName() + ":" + ticket-- + " ticket");
		}
		lock.unlock();
	}
}