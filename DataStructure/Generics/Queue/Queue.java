package Generics;

/**
 * Implement a generic Queue<T>
 * 
 * Queue是一種先進先出(First-In-First-Out)的資料結構，
 * 它只允許在後端(rear)進行插入，前端(front)進行刪除。
 * 
 * @author HsiHo Huang
 * @version 1.1
 * 
 * @param <T> the type of the value
 */
public class Queue<T> {
	private Node<T> front, rear;
	
	public Queue(){
	}
	
	public Queue(T data){
		this.enqueue(data);
	}
	
	/**
	 * Add data
	 * @param data 要加入的資料
	 */
	public void enqueue(T data){
		Node<T> item = new Node<T>(data);
		//判斷Queue是不是空的		
		if(front != null){ //不是空的 -> 在後端進行插入
			rear.nextNode = item;
			rear = item; // 新節點變成最後一個
		}else{
			//Queue是空的
			rear = item;
			front = rear ;
		}
	}
	
	/**
	 * Delete data
	 * @return T 被刪除的資料
	 */
	public T dequeue(){
		//判斷Queue是不是空的
		if(front != null){  //不是空的 -> 在前端進行刪除
			T frontData = front.data;
			front = front.nextNode;//第二個節點變成第一個(front)
			return frontData;
		}
		return null;
	}
	
	/**
	 * 看front節點的資料
	 * @return String front節點的資料值
	 */
	public String peek(){  
		if(front != null)
			return front.data.toString();
		else
			return "It's empty!";
	}
}
