package Generics;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit 4 test case for singly LinkedList<T>
 * @author HsiHo Huang
 * @version 1.1
 */
public class LinkedListTest {
	private LinkedList<Integer> intLinkedList;
	private LinkedList<String> strlinkedList;

	@Before
	public void setUp() throws Exception {
		intLinkedList = new LinkedList<Integer>(2);
		intLinkedList.appendToTail(12);
		intLinkedList.appendToTail(8);
		intLinkedList.appendToTail(-5);
		
		strlinkedList = new LinkedList<String>("I");
		strlinkedList.appendToTail("am");
		strlinkedList.appendToTail("HsiHo");
		strlinkedList.appendToTail("Huang");
	}

	@After
	public void tearDown() throws Exception {
		intLinkedList = null;
		strlinkedList = null;
	}

	@Test
	public void testAppendToTail() {
		assertEquals("2 12 8 -5 ", intLinkedList.toString());
		assertEquals("I am HsiHo Huang ", strlinkedList.toString());
	}
	
	@Test
	public void testDeletNode() {
		intLinkedList.deletNode(2);
		assertEquals("12 8 -5 ", intLinkedList.toString());
		strlinkedList.deletNode("Huang");
		assertEquals("I am HsiHo ", strlinkedList.toString());
	}

}
