package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Mainer {

	 private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(15);

	    public static void main(String[] args) {
	        Thread t = new Thread(() -> {
	        	System.out.println("1");
	            while (true) {
	            	System.out.println("true");
	                try {
	                    queue.take().run();
	                    System.out.println("hell");
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }

	            }
	        });
	        System.out.println("startiing");
	        t.start();

	        for (int i = 0; i < 2; i++) {
	          queue.add(()-> {
	        	  System.out.println("hi");
	          });
	        }
	    }
}
