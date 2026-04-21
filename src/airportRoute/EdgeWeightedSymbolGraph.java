package airportRoute;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class EdgeWeightedSymbolGraph {
	/**
	 *  The {@code SymbolGraph} class represents an undirected graph, where the
	 *  vertex names are arbitrary strings.
	 *  By providing mappings between string vertex names and integers,
	 *  it serves as a wrapper around the
	 *  {@link Graph} data type, which assumes the vertex names are integers
	 *  between 0 and <em>V</em> - 1.
	 *  It also supports initializing a symbol graph from a file.
	 *  <p>
	 *  This implementation uses an {@link ST} to map from strings to integers,
	 *  an array to map from integers to strings, and a {@link Graph} to store
	 *  the underlying graph.
	 *  The <em>indexOf</em> and <em>contains</em> operations take time
	 *  proportional to log <em>V</em>, where <em>V</em> is the number of vertices.
	 *  The <em>nameOf</em> operation takes constant time.
	 *  <p>
	 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a> of
	 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
	 *
	 *This class is based on {@code SymbolGraph} from R. Sedgewick and Kevin Wayne
	 *  @author Ian Shoell
	 */
	//public class SymbolGraph {
	    private ST<String, Integer> st;  // string -> index
	    private String[] keys;           // index  -> string
	    private EdgeWeightedGraph graph;             // the underlying graph

	    /**
	     * Initializes a edge-weight graph from a file using the specified delimiter.
	     * Each line in the file contains
	     * the name of a vertex, followed by a list of the names
	     * of the vertices adjacent with that vertex, separated by the delimiter.
	     * @param filename the name of the file
	     * @param delimiter the delimiter between fields
	     */
	    public EdgeWeightedSymbolGraph(String filename, String delimiter) {
	        st = new ST<String, Integer>();

	        // First pass builds the index by reading strings to associate
	        // distinct strings with an index
	        // Each line in CSV file includes two vertex names
	        // followed by an edge weight, which will be ignored in the first pass.
	        In in = new In(filename);
	        while (!in.isEmpty()) {
	            String[] a = in.readLine().split(delimiter);
	            for (int i = 0; i < 2; i++) {
	                if (!st.contains(a[i]))
	                    st.put(a[i], st.size());
	            }
	        }

	        // inverted index to get string keys in an array
	        keys = new String[st.size()];
	        for (String name : st.keys()) {
	            keys[st.get(name)] = name;
	        }

	        // second pass builds the edge weighted graph by 
	        //creating edges based on the information provided in each line.
	        graph = new EdgeWeightedGraph(st.size());
	        in = new In(filename);
	        while (in.hasNextLine()) {
	            String[] a = in.readLine().split(delimiter);
	            int v = st.get(a[0]);
	            for (int i = 1; i < a.length; i++) {
	                int w = st.get(a[i]);
	                Edge edge = null;//TODO;
	                graph.addEdge(edge);
	            }
	        }
	    }

	    /**
	     * Does the graph contain the vertex named {@code s}?
	     * @param s the name of a vertex
	     * @return {@code true} if {@code s} is the name of a vertex, and {@code false} otherwise
	     */
	    public boolean contains(String s) {
	        return st.contains(s);
	    }


	    /**
	     * Returns the integer associated with the vertex named {@code s}.
	     * @param s the name of a vertex
	     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
	     */
	    public int indexOf(String s) {
	        return st.get(s);
	    }

	    

	    /**
	     * Returns the graph associated with the symbol graph. It is the client's responsibility
	     * not to mutate the graph.
	     * @return the graph associated with the symbol graph
	     */
	    public EdgeWeightedGraph graph() {
	        return graph;
	    }

	    // throw an IllegalArgumentException unless {@code 0 <= v < V}
	    private void validateVertex(int v) {
	        int V = graph.V();
	        if (v < 0 || v >= V)
	            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	    }


	    /**
	     * Unit tests the {@code SymbolGraph} data type.
	     *
	     * @param args the command-line arguments
	     */
	    /*public static void main(String[] args) {
	        String filename  = args[0];
	        String delimiter = args[1];
	        SymbolGraph sg = new SymbolGraph(filename, delimiter);
	        Graph graph = sg.graph();
	        while (StdIn.hasNextLine()) {
	            String source = StdIn.readLine();
	            if (sg.contains(source)) {
	                int s = sg.index(source);
	                for (int v : graph.adj(s)) {
	                    StdOut.println("   " + sg.nameOf(v));
	                }
	            }
	            else {
	                StdOut.println("input not contain '" + source + "'");
	            }
	        }
	    }*/
	//}
}
