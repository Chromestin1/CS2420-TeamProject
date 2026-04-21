package airportRoute;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * 
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class Map {
	private EdgeWeightedSymbolGraph map;
	private int size;
	
	private ST<String, Integer> codeToIndex;
	private String[] indexToCode;
	private Airport[] airports;
	private EdgeWeightedDigraph graph;
	//private Digraph graph;
	
	
	/**
	 * Constructs the map from a route file
	 */
	public Map(String fileName) {
		codeToIndex = new ST<String, Integer>();
		indexToCode = new String[100];//ArrayList<String>();
		airports = new Airport[100];
		size = 0;//indexToCode.size();
		
		buildSymbolTable(fileName);
		buildGraph(fileName);
		
		//String fileName = "src/airportRoute/Resources/Airports.txt";
		//this.map = new EdgeWeightedSymbolGraph("src/airportRoute/Resources/Airports.txt", ",");
		//this.size = size;
		
	}
	
	/////////////////////New methods added////////////////////////////////////
	private void buildSymbolTable(String fileName) {
		System.out.println("Reading file....");
		In in = new In(fileName);
		
		while (!in.isEmpty()) {
			String line = in.readLine().trim();
			
			if (line.isEmpty())
				continue;
			
			String[] parts = line.split(",");
			
			if (parts.length < 3)
				continue;
			
			String from = parts[0];//in.readString();
			String to = parts[1];//in.readString();
			//in.readDouble();
			
			addCode(from);
			addCode(to);
		}
	}
	
	private void addCode(String code) {
		System.out.println("Adding airport " + code);
		if (!codeToIndex.contains(code)) {
			//int index = indexToCode.size();
			codeToIndex.put(code, size);
			indexToCode[size] = code;
			airports[size] = new Airport(code);
			size++;
		}
	}
	
	private void buildGraph(String fileName) {
		graph = new EdgeWeightedDigraph(size);
		//graph = new Digraph(indexToCode.size());
		
		In in = new In(fileName);
		
		while (in.hasNextLine()) {
			String line = in.readLine().trim();
			
			if (line.isEmpty())
				continue;
			
			String[] parts = line.split(",");
			
			if (parts.length < 3)
				continue;
			
			String from = parts[0];//in.readString();
			String to = parts[1];//in.readString();
			double cost = Double.parseDouble(parts[2].trim());
			
			
			int fromIndex = codeToIndex.get(from);
			int toIndex = codeToIndex.get(to);
			
			graph.addEdge(new DirectedEdge(fromIndex, toIndex, cost));
			//addCode(from);
			//addCode(to);
			//graph.addEdge(new DirectedEdge(fromIndex, toIndex, cost));
		}
		
	}
	
	public Airport getAirport(int index) {
		return airports[index];
	}
	
	public boolean contains(String code) {
		return codeToIndex.contains(code);
	}
	
	public int indexOf(String code) {
		return codeToIndex.get(code);
	}
	
	public String codeOf(int index) {
		return indexToCode[index];
	}
	
	public EdgeWeightedDigraph getGraph() {
		return graph;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * mostDirect gets the most direct path from an origin
	 * 
	 * @param origin
	 * @return the most direct path
	 */
	public BreadthFirstPaths mostDirect(int origin) {
		Graph graph = new Graph(map.graph().V()); 

		//for (Edge e : map.graph().adj(origin)) {
		 //   int v = e.either();
		   // int w = e.other(v);
		    //graph.addEdge(v, w);
		//}
		
		return new BreadthFirstPaths(graph, origin);
	}
	
	/**
	 * cheapest gets the cheapest path from an origin
	 * 
	 * @param origin
	 * @return the cheapest path
	 */
	
	public DijkstraUndirectedSP cheapest(int origin) {
		return new DijkstraUndirectedSP(map.graph(), origin);
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
		return x * 1000 + y;
	}
	
	
	public int getSize() {
		return size;
	}
	
	
}