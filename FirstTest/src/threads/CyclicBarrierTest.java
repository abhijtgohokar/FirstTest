package threads;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to demonstrate how to use CyclicBarrier in Java. CyclicBarrier is a
 * new Concurrency Utility added in Java 5 Concurrent package.
 *
 * @author Javin Paul
 */
public class CyclicBarrierTest {

    //Runnable task for each thread
    private static class Task implements Callable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public Object call() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclicBarrierTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(CyclicBarrierTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 1;
        }
    }

    public static void main(String args[]) {

    	FutureTask[] fTask = new FutureTask[4]; 
    
        //creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
        final CyclicBarrier cb = new CyclicBarrier(4, new Runnable(){
            @Override
            public void run(){
                //This task will be executed once all thread reaches barrier
                System.out.println("All parties are arrived at barrier, lets play :"+Thread.currentThread().getName());
                try {
					System.out.println(fTask[0].get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        fTask[0] = new FutureTask<Callable>(new Task(cb));
        fTask[1] = new FutureTask<Callable>(new Task(cb));
        fTask[2] = new FutureTask<Callable>(new Task(cb));
        fTask[3] = new FutureTask<Callable>(new Task(cb));
        
        //starting each of thread
        Thread t1 = new Thread(fTask[0]);
        Thread t2 = new Thread(fTask[1]);
        Thread t3 = new Thread(fTask[2]);
        Thread t4 = new Thread(fTask[3]);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("All parties are arrived at barrier, lets play all:"+Thread.currentThread().getName());
    }
}