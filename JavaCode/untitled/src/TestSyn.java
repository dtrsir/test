import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSyn {
	public static void main(String[] args) {
		ex31 ex31 = new ex31();
		new Thread(ex31, "1").start();
		new Thread(ex31, "2").start();
		new Thread(ex31, "3").start();
		ex21 ex21 = new ex21();
		ex21.start();
	}

}
class ex21 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ex21");
	}
}

class ex31 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ex31");
	}
}
