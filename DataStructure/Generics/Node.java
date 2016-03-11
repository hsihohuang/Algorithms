package Generics;

/**
 * A generic class Node<T>
 * @author HsiHo Huang
 * @version 1.1
 * 
 * @param <T> the type of the value
 */
public class Node<T> {
	protected T data;
	protected Node<T> nextNode = null;
	
	public Node(T data){
		this.data = data;
	}
}
