import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 測試單向鏈結
 * @author HsiHo Huang
 * @version 1.1
 */
public class LinkedListTest {
	private LinkedListNode linkedList ;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		linkedList = new LinkedListNode(2);
		linkedList.appendToTail(6);
		linkedList.appendToTail(8);
		linkedList.appendToTail(5);
		linkedList.appendToTail(-5);
		linkedList.appendToTail(0);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		linkedList = null;
	}

	@Test
	public void test() {
		assertEquals("2 6 8 5 -5 0 ", linkedList.toString());
	}

}
