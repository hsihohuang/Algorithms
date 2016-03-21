/**
 * Implement a generic BST<T>
 * @author HsiHo Huang
 * @version 1.1
 *
 * @param <T> the type of the value
 */
public class BST<T extends Comparable<T>> {
	TreeNode<T> root;
	private StringBuilder traversal;
	
	
	public BST(){
		root = null;
		traversal = new StringBuilder();
	}
	
	public void cleanTraversalHistory(){
		traversal = new StringBuilder();
	}
	
	public String getTraversalHistory(){
		return traversal.toString();
	}
	
	public void insertNode(T insertValue){
		if ( root == null )
			root = new TreeNode<T>( insertValue ); 
		else
			root.insert( insertValue );
	}
	
	/**
	 * Preorder traverse(前序走訪)
	 * <p>
	 * 概念: 先拜訪目前的節點，再拜訪左子樹，再拜訪右子樹。
	 * 拜訪左、右子樹時，都會以相同的順序(前序)來做拜訪。
	 * 
	 * @param root 出發節點
	 */
	public void preorder(TreeNode<T> root){
		if ( root == null )
			return; 
		else{
			traversal.append(root.data+" ");
			preorder(root.leftNode);
			preorder(root.rightNode);
		}			
	}
	
	/**
	 * Inorder traverse (中序走訪)
	 * <p>
	 * 概念: 先拜訪左子樹，再拜訪目前的節點，再拜訪右子樹。
	 * 拜訪左、右子樹時，都會以相同的順序(中序)來做拜訪。
	 * <p>
	 * Note: 中序走訪二元搜尋樹的結果剛好是資料從小排到大
	 * 
	 * @param root 出發節點
	 */
	public void inorder(TreeNode<T> root){
		if ( root == null )
			return; 
		else{
			inorder(root.leftNode);
			traversal.append(root.data+" ");			
			inorder(root.rightNode);
		}			
	}
	
	/**
	 * Postorder traverse (後序走訪)
	 * <p>
	 * 概念: 先拜訪左子樹，再拜訪右子樹，再拜訪目前的節點。
	 * 拜訪左、右子樹時，都會以相同的順序(後序)來做拜訪。
	 * 
	 * @param root
	 */
	public void postorder(TreeNode<T> root){
		if ( root == null )
			return; 
		else{
			postorder(root.leftNode);		
			postorder(root.rightNode);
			traversal.append(root.data+" ");	
		}			
	}
}
