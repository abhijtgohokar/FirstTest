package designPatternProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private static BlockingQueue<Integer> queue;
	private static int maxSize;
	private static int counter=0;
	private static int noOfRecords = 0;

	public Producer(BlockingQueue<Integer> queue2, int maxSize2) {
		this.queue=queue2;
		this.maxSize = maxSize2;
	}
	public void run(){
		
		while(true){
			synchronized (queue) {
				while(queue.size()==maxSize){
					System.out.println("max size reached. Wait");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("producing : ");
				queue.add(++counter);
				++noOfRecords;
				while(noOfRecords ==100){
					Consumer.nothingToProcess=true;
					queue.notifyAll();
					return;
				}
				queue.notifyAll();
			}
		}
	}
}
