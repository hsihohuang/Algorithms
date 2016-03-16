package Generics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit 4 test case for Queue<T>
 * @author HsiHo Huang
 * @version 1.1
 */
public class QueueTest {
	private Queue<Integer> intQueue;
	private Queue<String> strQueue;
	private Queue<Double> doubleQueue;

	@Before
	public void setUp() throws Exception {
		intQueue = new Queue<Integer>(66);
		intQueue.enqueue(-43);
		intQueue.enqueue(25);
		intQueue.enqueue(10);
		
		strQueue = new Queue<String>("I");
		strQueue.enqueue("am");
		strQueue.enqueue("HsiHo");
		strQueue.enqueue("Huang");
		
		doubleQueue = new Queue<Double>();
	}

	@After
	public void tearDown() throws Exception {
		intQueue = null;
		strQueue = null;
		doubleQueue = null;
	}

	@Test
	public void testEnqueue() {
		assertEquals("66", intQueue.peek());
		assertEquals("I", strQueue.peek());
		assertEquals("It's empty!", doubleQueue.peek());
	}
	
	
	@Test
	public void testDequeue() {
		intQueue.dequeue();
		assertEquals("-43", intQueue.peek());
		strQueue.dequeue();
		assertEquals("am", strQueue.peek());
		doubleQueue.dequeue();
		assertEquals("It's empty!", doubleQueue.peek());
	}

}
