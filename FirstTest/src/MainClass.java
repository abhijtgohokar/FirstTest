import com.learning.abhijit.threads.TestRunnable;
import com.learning.abhijit.threads.TestThread;


public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		TestThread t11 = new TestThread();
		t11.start();
		//t1.wait(10000);
		Thread t1 = new Thread(new TestRunnable("1"));
		Thread t2 = new Thread(new TestRunnable("2"));
		Thread t3 = new Thread(new TestRunnable("3"));
		
		t1.start();
		t2.join();
		t2.start();
		
		t3.join();
		t3.start();
	
		
		
	}
}
