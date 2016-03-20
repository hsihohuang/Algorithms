package Generics;

/**
 * Implement a generic Stack<T>
 * 
 * Stack是一種後進先出(Last-In-First-Out)的資料結構，
 * 它只允許在頂端(top)進行加入(push)及刪除資料(pop)。
 * 
 * @author HsiHo Huang
 * @version 1.1
 * 
 * @param <T> the type of the value
 */
public class Stack<T> {
	private Node<T> top;
	
	/**
	 * Creates an empty Stack.
	 */
	public Stack(){
	}
	
	/**
	 * Creates a Stack and pushes an item.
	 * @param data the value to be pushed onto this stack.
	 */
	public Stack(T data){
		this.push(data);
	}
	
	/**
	 * Pushes an item onto the top of this stack.
	 * @param data the value to be pushed onto this stack.
	 */
	public void push(T data){
		Node<T> item = new Node<T>(data);
		item.nextNode = top;//從頂端加入，新的節點的nextNode設定成頂端節點
		top = item;//新節點變成頂端
	}
	
	/**
	 * Deletes the item at the top of this stack and returns the
	 * value of that item.
	 * @return the value of the item at the top
	 */
	public T pop(){
		if(top != null){
			T topData = top.data;
			top = top.nextNode;//第二個節點變成頂端
			return topData;
		}
		return null;
	}
	
	/**
	 * Peeks the value of the item at the top.
	 * @return 回傳top節點資料值的字串，若stack為空則回傳"It's empty!" 
	 */
	public String peek(){ 
		if(top != null)
			return top.data.toString();
		else
			return "It's empty!";
	}
}
