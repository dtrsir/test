import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorDemo implements Runnable {
	private int torgetNum = 1;
	private char torgetchar = 'a';
//	private boolean flag = false; 
	private Lock lock = new ReentrantLock();
	private Condition conditionPrintNumber = lock.newCondition();
	private Condition conditionPrintCharacter = lock.newCondition();

	
	public static void main(String[] args) {
		ExecutorDemo ed = new ExecutorDemo();
		new Thread(ed, "打印数字").start();
		new Thread(ed, "打印字母").start();
	}

	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("打印数字"))
		printNumber();
		if(Thread.currentThread().getName().equals("打印字母"))
		printCharacter();
	}
	
	public void printNumber() {
		lock.lock();
		for(int i = 0;i < 26;i++) {
			
			System.out.print(torgetNum++);
			System.out.print(torgetNum++);
			conditionPrintCharacter.signal();
			try {
				conditionPrintNumber.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		conditionPrintCharacter.signal();
		lock.unlock();
		
	}

	public void printCharacter() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0;i < 26;i++) {
			lock.lock();
			System.out.print(torgetchar++);
			conditionPrintNumber.signal();
			try {
				conditionPrintCharacter.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.unlock();
		}
		
	}
}
