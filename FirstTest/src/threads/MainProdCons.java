package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainProdCons {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		Producer prod = new Producer(queue, 10);
		Consumer con = new Consumer(queue,10);
		
		Thread producer = new Thread(prod);
		Thread consumer = new Thread(con);
		
		producer.start();
		consumer.start();
		try {
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
