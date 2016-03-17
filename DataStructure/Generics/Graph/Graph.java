import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * Implement a generic Graph<T>
 * @author HsiHo Huang
 * @version 1.1
 */
public class Graph<T> {
	private List<Vertex<T>> vertices;
	
	/**
	 * Creates a Graph.
	 */
	public Graph(){
		vertices = new ArrayList<Vertex<T>>();
	}
	
	/**
	 * Adds vertex into this Graph.
	 */
	public void insertVertex(T d){
		vertices.add(new Vertex<T>(d));
	}
	
	/**
	 * 取得出發點
	 * @return 該index的節點
	 */
	public Vertex<T> getRoot(int index){
		return vertices.get(index);
	}
	
	/**
	 * Graph traversal: Breadth-first search
	 * <p>
	 * 廣度優先走訪：概念是由內而外，一層一層走訪<br>
	 * 以tree的架構來說，即把同一深度(level)的節點走訪完，
	 * 再繼續向下一個深度做走訪，直到遍歷完全部節點。<br>
	 * 此概念可以用Queue來實作，用Queue來存走訪完的點
	 * 再從Queue中抓出走訪完的點，繼續走訪此點的下一個深度之節點(也就是相鄰的節點)，
	 * 一直依此概念循環直到全部都被走訪完為止。
	 * 
	 * @param root 出發節點
	 * @return 走訪順序的字串
	 */
	public String Traversal_BreadthFirstSearch(Vertex<T> root){
		StringBuilder traversal = new StringBuilder();
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		traversal.append(root.visit());//先走訪出發節點
		queue.offer(root);//把出發節點放入queue
		while(!queue.isEmpty()){
			Vertex<T> v = queue.poll();//從queue抓出點
			v.adjacent.forEach((vertex) -> { //走訪該點所有的相鄰節點，並放入queue
				if(!vertex.visited){ //如果拜訪過，就不需要拜訪了
					traversal.append(vertex.visit());
					queue.offer(vertex);
				}
			});
		}
		return traversal.toString();
	}
	
	/**
	 * Graph traversal: Depth-first search
	 * <p>
	 * 深度優先走訪: 概念是會先拜訪到最遠的點，再慢慢回來<br>
	 * 舉例來說，會先拜訪出發節點root，然後逐一拜訪與root相鄰的每個節點，
	 * 當拜訪相鄰於root的節點n時，先拜訪n的所有相鄰節點，然後再拜訪其它相鄰root的節點。
	 * 也就是說，n會先被完全地走訪過，然後才讓root接著走訪它的其他相鄰節點。<br>
	 * 此概念可以用Stack來實作，用Stack來存"要被拜訪但還沒訪的點"，
	 * 然後從Stack中抓出準備要拜訪的點，拜訪完之後，把該節點的所有相鄰節點放入Stack，
	 * 由於Stack是後進先出的資料結構，後放進去的點會被先拜訪，所以走訪順序剛好是深度優先。
	 * 
	 * @param root 出發節點
	 * @return 走訪順序的字串
	 */
	public String Traversal_DepthFirstSearch_Stack(Vertex<T> root){
		StringBuilder traversal = new StringBuilder();
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		stack.push(root);//先存入出發節點
		while(!stack.isEmpty()){
			Vertex<T> v = stack.pop();
			if(!v.visited){
				//拜訪完之後，把該節點的所有相鄰節點放入Stack
				traversal.append(v.visit());
				v.adjacent.forEach((vertex) -> {
					if(!vertex.visited)					
						stack.push(vertex);
				});
			}			
		}
		return traversal.toString();
	}
	
	/**
	 * 遞迴版的DFS走訪
	 * @param root 出發節點
	 */
	public void Traversal_DepthFirstSearch_Recursion(Vertex<T> root){
		if(root == null) return;
		System.out.print(root.visit());
		root.adjacent.forEach((vertex) -> {
			if(!vertex.visited){
				Traversal_DepthFirstSearch_Recursion(vertex);
			}
		});	
	}
	
	/**
	 * 讀檔建圖，格式如下：<p>
	 * <ol>1. 檔案的第一行是每個節點的值，以" "空白字元做區隔</ol>
	 * <blockquote>舉例來說: testFile/strGraph.txt中第一行是A B C D E F G H，代表要插入8個節點，值分別為A B C D E F G H，
	 * <br>會按照檔案中值的順序依序被加入vertices list中</blockquote>
	 * <ol>2. 第一行以下，每行代表vertices中某index的節點(第一個數字)和哪些index的點相鄰(第二與之後的數字)，一樣以" "空白字元做區隔</ol>
	 * <blockquote>舉例來說: testFile/strGraph.txt中第二行是0 1 2，代表vertices中，index 0的點和index 1、index 2相鄰，
	 * <br>也就是，A與B、C相鄰</blockquote>
	 * @throws FileNotFoundException 如果找不到input file
	 */
	@SuppressWarnings("unchecked")
	public void buildGraph()throws Exception{
		String getFilePath,line;
		String [] dataStr;
		BufferedReader inputPath = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please Input the file path: ");
		getFilePath = inputPath.readLine();
				
		try {
			FileReader testFile= new FileReader(getFilePath);
			BufferedReader bufferedStream = new BufferedReader(testFile);
			line = bufferedStream.readLine();
			dataStr = line.split(" ");
			
			for(String s: dataStr)
				this.insertVertex((T)s);

			while((line = bufferedStream.readLine())!= null){
				dataStr = line.split(" ");
				for(int i=1; i<dataStr.length; i++)
					this.vertices.get(Integer.parseInt(dataStr[0])).setAdjacent(this.vertices.get(Integer.parseInt(dataStr[i])));
			}
			bufferedStream.close();
		}catch (FileNotFoundException e1) {
			System.out.println("file not found\n" + e1);
			return;
		}
	}
}
