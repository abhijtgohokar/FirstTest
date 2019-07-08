import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class TestList implements TestInterface{

	public static void main(String[] args) {
	
		PriorityQueue<String> queue = new PriorityQueue<String>(10);
		queue.add("a");		queue.add("a");		queue.add("a");
		queue.add("a");		queue.add("a");		queue.add("a");
		queue.add("a");		queue.add("a");		queue.add("a");
		queue.add("a");		queue.add("a");		queue.add("a");
		System.out.println(queue);
	}

	@Override
	public void add() {
		System.out.println("add");
	}
}
