package Generics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 test case for Stack<T>
 * @author HsiHo Huang
 * @version 1.1
 */
public class StackTest {
	private Stack<Integer> intStack;
	private Stack<String> strStack;
	private Stack<Double> doubleStack;

	@Before
	public void setUp() throws Exception {
		intStack = new Stack<Integer>(5);
		intStack.push(-4);
		intStack.push(2);
		intStack.push(0);
		
		strStack = new Stack<String>("I");
		strStack.push("am");
		strStack.push("HsiHo");
		strStack.push("Huang");
		
		doubleStack = new Stack<Double>();
	}

	@After
	public void tearDown() throws Exception {
		intStack = null;
		strStack = null;
		doubleStack = null;
	}

	@Test
	public void testPush() {
		assertEquals("0", intStack.peek());
		assertEquals("Huang", strStack.peek());
		assertEquals("It's empty!", doubleStack.peek());
	}
	
	@Test
	public void testPop() {
		intStack.pop();
		assertEquals("2", intStack.peek());
		strStack.pop();
		assertEquals("HsiHo", strStack.peek());
		doubleStack.pop();
		assertEquals("It's empty!", doubleStack.peek());
	}
}
