import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 test case for Graph<T>
 * @author HsiHo Huang
 * @version 1.1
 */
public class GraphTest {
	private Graph<String> strGraph = new Graph<String>();

	@Before
	public void setUp() throws Exception {
		strGraph.buildGraph();
	}

	@After
	public void tearDown() throws Exception {
		strGraph = null;
	}

	@Test
	public void testTraversal_BFS() {
		assertEquals("A B C D E F G H ", strGraph.Traversal_BreadthFirstSearch(strGraph.getRoot(0)));
	}
	
	@Test
	public void testTraversal_DFS() {
		assertEquals("A C G F E B D H ", strGraph.Traversal_DepthFirstSearch_Stack(strGraph.getRoot(0)));
	}

}
