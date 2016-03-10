
/**
 * A basic singly linked list
 * 
 * 一個單向鏈結串列的節點，包含兩個部分
 * (1)儲存該節點的資料值或者顯示關於節點的資訊，(2)儲存下一個節點的位址
 * 單向連結串列只可向一個方向遍歷，且最後一個節點指向一個空值，代表串列結束。
 * 
 * @author HsiHo Huang
 * @version 1.1
 */
public class LinkedListNode {
	int data;						//該節點的資料值	
	LinkedListNode nextNode = null;	//指到下一個節點的指標
	
	
	public LinkedListNode(int data){
		this.data = data;
	}
	
	/**
	 * 增加節點到尾端
	 * @param d 新增節點的資料值
	 */
	public void appendToTail(int d){ 
		LinkedListNode current = this;
		while(current.nextNode != null){
			current = current.nextNode;
		}
		
		current.nextNode = new LinkedListNode(d);
	}
	
	/**
	 * 將整個鏈結串列的資料值轉成字串
	 */
	@Override
	public String toString(){
		StringBuilder linkedListData = new StringBuilder();
		for(LinkedListNode current = this; current != null; current = current.nextNode)
			linkedListData.append(current.data + " ");
		
		return linkedListData.toString();
	}
	
}
