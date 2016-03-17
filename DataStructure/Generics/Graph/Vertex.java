import java.util.ArrayList;
import java.util.List;

/**
 * @author HsiHo Huang
 * @version 1.1
 */
public class Vertex<T>{
	protected T data;
	protected boolean visited = false;
	protected List<Vertex<T>> adjacent;

	public Vertex(){
	}
	
	public Vertex(T data){
		this.data = data;
		this.adjacent = new ArrayList<Vertex<T>>();
	}
	
	public void setAdjacent(Vertex<T> adjacentVertex){
		this.adjacent.add(adjacentVertex);
	}
	
	public String visit(){
		this.visited = true;
		return this.data + " ";
	}
}
