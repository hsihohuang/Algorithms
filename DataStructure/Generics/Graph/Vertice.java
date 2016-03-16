import java.util.ArrayList;
import java.util.List;

/**
 * @author HsiHo Huang
 * @version 1.1
 */
public class Vertice<T>{
	protected T data;
	protected boolean visited = false;
	protected List<Vertice<T>> adjacent;

	public Vertice(){
	}
	
	public Vertice(T data){
		this.data = data;
		this.adjacent = new ArrayList<Vertice<T>>();
	}
	
	public void setAdjacent(Vertice<T> adjacentVertice){
		this.adjacent.add(adjacentVertice);
	}
	
	public String visit(){
		this.visited = true;
		return this.data + " ";
	}
}
