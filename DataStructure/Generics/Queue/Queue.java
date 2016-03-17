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
	
	/**
     * Creates an empty Queue.
     */
	public Queue(){
	}
	
	/**
     * Creates a Queue and adds the specified data into this queue.
     */
	public Queue(T data){
		this.enqueue(data);
	}
	
	/**
	 * Adds the specified data into this queue.
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
	 * Deletes the front of this queue.
	 * @return 被刪除的front資料
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
	 * Peeks the front of this queue.
	 * @return 回傳front節點資料值的字串，若queue為空則回傳"It's empty!"
	 */
	public String peek(){  
		if(front != null)
			return front.data.toString();
		else
			return "It's empty!";
	}
}
