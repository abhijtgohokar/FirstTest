package com.learning.abhijit.designpatterns.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Integer> queue;
	private static int maxSize;
	private static int counter=0;
	public static boolean nothingToProcess = false;
	public Consumer(BlockingQueue<Integer> queue2, int maxSize2){
		this.queue=queue2;
		this.maxSize = maxSize2;
	}
	public void run(){
		
		while(true){
			synchronized (queue) {
				while(queue.isEmpty()){
					System.out.println("Queue is empty. Wait");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while (nothingToProcess && queue.isEmpty() ) {
					//queue empty check is needed to process remaining items after
					//producer marked the flag as true
					System.out.println("nothing to process. End process.");
					return;
				}
				System.out.println("consuming : "+queue.remove());
				queue.notifyAll();
			}
		}
	}
}
