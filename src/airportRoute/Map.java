package airportRoute;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * 
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class Map {
	private EdgeWeightedGraph map;
	
	
	/**
	 * Map represents the map for the project
	 */
	public Map() {
		this.map = new EdgeWeightedGraph(new In("src/airportRoute/Resources/Airports.txt"));
	}
	
	/**
	 * mostDirect gets the most direct path from an origin
	 * 
	 * @param origin
	 * @return the most direct path
	 */
	public BreadthFirstPaths mostDirect(int origin) {
		Graph graph = new Graph(map.V()); 

		for (Edge e : map.edges()) {
		    int v = e.either();
		    int w = e.other(v);
		    graph.addEdge(v, w);
		}
		
		return new BreadthFirstPaths(graph, origin);
	}
	
	/**
	 * cheapest gets the cheapest path from an origin
	 * 
	 * @param origin
	 * @return the cheapest path
	 */
	public DijkstraUndirectedSP cheapest(int origin) {
		return new DijkstraUndirectedSP(map, origin);
	}
	
	/**
	 * coordinates gets the coordinates of the airport to
	 * then display.
	 * 
	 * @param x
	 * @param y
	 * @return the airport coordinates
	 */
	public int coordinates(int x, int y) {
		return 0;
	}
	
	/**
	 * main is out test method for map
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Map map = new Map();
		
	}
}
