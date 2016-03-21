import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 test case for BST<T>
 * @author HsiHo Huang
 * @version 1.1
 */
public class BSTTest {
	private BST<Integer> intTree = new BST<Integer>();
	private BST<String> strTree = new BST<String>();
	

	@Before
	public void setUp() throws Exception {
		int[] nums = {29,13,35,6,19,38,4,10,12,11};
		for(int n: nums)
			intTree.insertNode(n);//intTree之圖形請看Readme
		
		String[] strs = {"F","D","A","I","H","G","J","K","E"};
		for(String s: strs)
			strTree.insertNode(s);//strTree之圖形請看Readme
	}

	@After
	public void tearDown() throws Exception {
		intTree.cleanTraversalHistory();
		intTree = null;
		
		strTree.cleanTraversalHistory();
		strTree = null;
	}

	@Test
	public void testPreorder() {
		intTree.preorder(intTree.root);
		assertEquals("29 13 6 4 10 12 11 19 35 38 ", intTree.getTraversalHistory());
		
		strTree.preorder(strTree.root);
		assertEquals("F D A E I H G J K ", strTree.getTraversalHistory());
	}
	
	/**
	 * 中序走訪，走訪結果剛好是資料從小排到大
	 */
	@Test
	public void testInorder() {
		intTree.inorder(intTree.root);
		assertEquals("4 6 10 11 12 13 19 29 35 38 ", intTree.getTraversalHistory());
		
		strTree.inorder(strTree.root);
		assertEquals("A D E F G H I J K ", strTree.getTraversalHistory());
	}
	
	@Test
	public void testPostorder() {
		intTree.postorder(intTree.root);
		assertEquals("4 11 12 10 6 19 13 38 35 29 ", intTree.getTraversalHistory());
		
		strTree.postorder(strTree.root);
		assertEquals("A E D G H K J I F ", strTree.getTraversalHistory());
	}
}
