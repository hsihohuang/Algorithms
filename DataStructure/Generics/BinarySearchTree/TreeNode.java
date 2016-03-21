/**
 * A generic class TreeNode<T>
 * <p>
 * 二元樹的每一個樹節點會儲存該節點的資料，且最多擁有兩個子樹，左子樹、右子樹
 * 
 * @author HsiHo Huang
 * @version 1.1
 * 
 * @param <T> the type of the value
 */
public class TreeNode<T extends Comparable<T>> {
	T data;
	TreeNode<T> leftNode, rightNode;
	
	public TreeNode(T data){
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}
	
	/**
	 * Inserts data into this binary search tree
	 * <p>
	 * 二元搜尋樹的特性：對每個節點來說，它的左子樹所有的節點資料值都小於它的資料值，
	 * 右子樹所有節點資料值都大於它的資料值。
	 * <p>
	 * 這裡使用Comparable Interface的compareTo函式來比較兩個同型別的資料，
	 * 程式會以當時的資料型別的compareTo方法來做運算。
	 * 
	 * @param insertValue 要加入的資料值
	 */
	public void insert(T insertValue){
		/**小於0，代表insertValue順序上要在this.data前面。
		 * 以natural ordering來說，就是(insertValue - this.data) < 0, insertValue < this.data*/
		if(insertValue.compareTo(this.data) < 0){	//要加入的資料值比該節點資料值小，插入左子樹中
			if(this.leftNode == null)
				this.leftNode = new TreeNode<T>(insertValue);
			else
				this.leftNode.insert(insertValue);
		}else if(insertValue.compareTo(this.data) > 0){	//要加入的資料值比該節點資料值大，插入右子樹中
			if(this.rightNode == null)
				this.rightNode = new TreeNode<T>(insertValue);
			else
				this.rightNode.insert(insertValue);
		}
	}
}
