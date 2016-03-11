package Generics;

/**
 * A generic singly LinkedList<T>
 * @author HsiHo Huang
 * @version 1.1
 * 
 * @param <T> the type of the value
 */
public class LinkedList<T> {
	private Node<T> head;
	
	public LinkedList(T data){
		head = new Node<T>(data);
	}
	
	/**
	 * 增加節點到尾端
	 * @param data 新增節點的資料值
	 */
	public void appendToTail(T data){
		Node<T> current = head;
		while(current.nextNode != null){
			current = current.nextNode;
		}
		current.nextNode = new Node<T>(data);
	}
	
	/**
	 * 刪除節點
	 * @param data 要刪除的資料值
	 */
	public void deletNode(T data){
		Node<T> current = head;
		
		if(current.data == data){//先檢查串列的頭，是否就是要被刪除的節點
			head = head.nextNode;//若是，把head設定成head的下一個節點(作為該串列的新開頭)
			return;
		}
		while(current.nextNode != null){
			//先檢查下一個節點是否是要被刪除的節點，若是，把"此節點的下一個節點"指向"下下個節點"
			if(current.nextNode.data == data){
				current.nextNode = current.nextNode.nextNode;
				return ;
			}
			current = current.nextNode;
		}
		return;
	}
	
	/**
	 * 將整個鏈結串列的資料值轉成字串
	 */
	@Override
	public String toString(){
		StringBuilder linkedListData = new StringBuilder();
		for(Node<T> current = head; current != null; current = current.nextNode)
			linkedListData.append(current.data + " ");
		
		return linkedListData.toString();
	}
}
