package airportRoute;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Represents the airport network as a graph
 * 
 * Stores airport codes, builds directed graphs for routes, and provides
 * algorithms for route computation.
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class Map {
	private int size;

	private ST<String, Integer> codeToIndex;
	private String[] indexToCode;
	private Airport[] airports;
	private EdgeWeightedDigraph graph;
	private Digraph directGraph;

	/**
	 * Constructs the airport map from a route file
	 * 
	 * @param fileName the input file containing routes
	 */
	public Map(String fileName) {
		codeToIndex = new ST<String, Integer>();
		indexToCode = new String[100];
		airports = new Airport[100];
		size = 0;

		buildSymbolTable(fileName);
		buildGraph(fileName);

	}

	/*
	 * Reads airport codes from the file and assigns indices
	 */
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

			String from = parts[0];
			String to = parts[1];

			addCode(from);
			addCode(to);
		}
	}

	/*
	 * Adds the airport code if it does not already exist.
	 * 
	 * @param code the airport code
	 */
	private void addCode(String code) {
		StdOut.println("Adding airport " + code);
		if (!codeToIndex.contains(code)) {
			codeToIndex.put(code, size);
			indexToCode[size] = code;
			airports[size] = new Airport(code);
			size++;
		}
	}

	/*
	 * Builds both weighted and unweighted graphs from the input file.
	 * 
	 * Weighted graph is used for cost calculations. Unweighted graph is used for
	 * BFS (least connections).
	 */
	private void buildGraph(String fileName) {
		graph = new EdgeWeightedDigraph(size);
		directGraph = new Digraph(size);

		In in = new In(fileName);

		while (in.hasNextLine()) {
			String line = in.readLine().trim();

			if (line.isEmpty())
				continue;

			String[] parts = line.split(",");

			if (parts.length < 3)
				continue;

			String from = parts[0];
			String to = parts[1];
			double cost = Double.parseDouble(parts[2].trim());

			int fromIndex = codeToIndex.get(from);
			int toIndex = codeToIndex.get(to);

			graph.addEdge(new DirectedEdge(fromIndex, toIndex, cost));
			directGraph.addEdge(fromIndex, toIndex);
		}

	}

	/*
	 * Returns the Aiport object at the given index.
	 * 
	 * @param index the airport index
	 * 
	 * @return the corresponding Airport
	 */
	public Airport getAirport(int index) {
		return airports[index];
	}

	/*
	 * Checks whether the given airport code exists in the map
	 * 
	 * @param code the airport code
	 * 
	 * @return true if the airport exists, otherwise false
	 */
	public boolean contains(String code) {
		return codeToIndex.contains(code);
	}

	/*
	 * Returns the index associated with an airport code.
	 * 
	 * @param code the airport code
	 * 
	 * @return the corresponding index
	 */
	public int indexOf(String code) {
		return codeToIndex.get(code);
	}

	/*
	 * Returns the airport code stored at the given index.
	 * 
	 * @param index the airport index
	 * 
	 * @return the airport code
	 */
	public String codeOf(int index) {
		return indexToCode[index];
	}

	/*
	 * Returns the weighted graph representing airport routes.
	 * 
	 * This graph is used for cost-based algorithms such as Dijkstra.
	 * 
	 * @return the weighted directed graph
	 */
	public EdgeWeightedDigraph getGraph() {
		return graph;
	}

	/**
	 * mostDirect gets the most direct path from an origin
	 * 
	 * @param origin
	 * @return the most direct path
	 */
	public BreadthFirstDirectedPaths mostDirect(int origin) {

		return new BreadthFirstDirectedPaths(directGraph, origin);
	}

	/**
	 * cheapest gets the cheapest path from an origin
	 * 
	 * @param origin
	 * @return the cheapest path
	 */

	public DijkstraSP cheapest(int origin) {
		return new DijkstraSP(graph, origin);
	}

	/**
	 * coordinates gets the coordinates of the airport to then display.
	 * 
	 * @param x
	 * @param y
	 * @return the airport coordinates
	 */
	public int coordinates(int x, int y) {
		return x * 1000 + y;
	}

	/*
	 * Returns the number of airports in the map
	 * 
	 * @returns the total number of airports
	 */
	public int getSize() {
		return size;
	}

}