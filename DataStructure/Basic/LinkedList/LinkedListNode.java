
/**
 * Implement a basic singly linked list
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
	public void appendToTail(int data){ 
		//使用一個node輔助，先移動到串列尾端
		LinkedListNode current = this;	 
		while(current.nextNode != null){ 
			current = current.nextNode;
		}
		//把最尾端節點的下一個節點位址指向新的，而新節點的nextNode預設就會是null(代表結束)
		current.nextNode = new LinkedListNode(data);
	}
	
	/**
	 * 刪除節點
	 * @param head 鏈結串列的頭(起始的節點)
	 * @param data 要刪除的資料值
	 * @return LinkedListNode 鏈結串列的頭(起始的節點)
	 */
	public static LinkedListNode deletNode(LinkedListNode head, int data){
		LinkedListNode current = head;
		
		if(current.data == data)//先檢查串列的頭，是否就是要被刪除的節點
			return head.nextNode;//若是，回傳head的下一個節點(作為該串列的新開頭)
		while(current.nextNode != null){
			//先檢查下一個節點是否是要被刪除的節點，若是，把"此節點的下一個節點"指向"下下個節點"
			if(current.nextNode.data == data){
				current.nextNode = current.nextNode.nextNode;
				return head;//因為開頭沒改變，所以回傳head
			}
			current = current.nextNode;
		}
		return head;//都沒找到要刪除的值，但開頭還是沒改變，所以回傳head
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
