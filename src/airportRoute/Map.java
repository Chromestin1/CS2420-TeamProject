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
 * 
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
	 * Constructs the map from a route file
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
	 * This method reads the file
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
	 * Adds the airport code
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

	public int getSize() {
		return size;
	}

}