import java.util.ArrayList;
import java.util.List;

/**
 * A generic class Vertex<T>
 * @author HsiHo Huang
 * @version 1.1
 *
 * @param <T> the type of the value 
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
