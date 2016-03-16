package Generics;

/**
 * Implement a generic Stack<T>
 * 
 * Stack是一種後進先出(Last In First Out)的資料結構，
 * 它只允許在頂端(top)進行加入(push)及刪除資料(pop)。
 * 
 * @author HsiHo Huang
 * @version 1.1
 * 
 * @param <T> the type of the value
 */
public class Stack<T> {
	private Node<T> top;
	
	public Stack(){
	}
	
	public Stack(T data){
		top = new Node<T>();
	}
	
	/**
	 * Add data
	 * @param data 要加入的資料
	 */
	public void push(T data){
		Node<T> item = new Node<T>(data);
		item.nextNode = top;//從頂端加入，新的節點的nextNode設定成頂端節點
		top = item;//新節點變成頂端
	}
	
	/**
	 * Delete data
	 * @return T 被刪除的資料
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
	 * 看top節點的資料
	 * @return String top節點的資料值 
	 */
	public String peek(){ 
		if(top != null)
			return top.data.toString();
		else
			return "It's empty!";
	}
}
