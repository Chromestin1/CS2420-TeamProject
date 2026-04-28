package airportRoute;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

/*
 * Provides the graphical user interface for the Airport Route Application
 * 
 * This class allows the user to:
 * -Select an origin and destination airport
 * -Choose a route type (least connections or cheapest
 * -Display the resulting route and cost
 * -Visualize routes on a map
 * 
 * @author Ian Shoell and Benjamin Shaw
 */
public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton cheapest;
	private JRadioButton leastConnections;

	private Map airportMap = new Map("src/airportRoute/Resources/Airports.txt");
	private JComboBox<Airport> originComboBox;
	private JComboBox<Airport> destinationComboBox;

	private JButton btnBook;
	private JLabel displayRoute;

	private Route currentRoute;
	private JLabel airport;

	private MapWindow windowMap;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructs the main application window
	 * 
	 * Initializes layout, loads airport data, and attaches event handlers.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);

		airportMap = new Map("src/airportRoute/Resources/Airports.txt");

		contentPane = new JPanel();
		contentPane.setBackground(new Color(149, 226, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		display();
		loadAirports();
		addEventHandlers();

	}

	/*
	 * Builds and arranges all GUI components.
	 * 
	 * Creates the control panel, map display, labels, and loads the map image.
	 */
	private void display() {
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);

		displayRoute = new JLabel("Welcome to Airport Route System!");
		displayRoute.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 19));
		displayRoute.setBackground(new Color(255, 255, 255));
		southPanel.add(displayRoute);

		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(new Color(0, 0, 255));
		contentPane.add(controlPanel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		controlPanel.setLayout(gbl_panel);

		ButtonGroup stuff = new ButtonGroup();

		JLabel originText = new JLabel("Origin");
		originText.setForeground(new Color(255, 255, 0));
		originText.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_originText = new GridBagConstraints();
		gbc_originText.insets = new Insets(0, 0, 5, 0);
		gbc_originText.gridx = 0;
		gbc_originText.gridy = 6;
		controlPanel.add(originText, gbc_originText);

		originComboBox = new JComboBox<Airport>();
		GridBagConstraints gbc_origin = new GridBagConstraints();
		gbc_origin.fill = GridBagConstraints.HORIZONTAL;
		gbc_origin.insets = new Insets(0, 0, 5, 0);
		gbc_origin.gridx = 0;
		gbc_origin.gridy = 7;
		controlPanel.add(originComboBox, gbc_origin);

		JLabel destinationText = new JLabel("Destination");
		destinationText.setForeground(new Color(255, 255, 0));
		destinationText.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_destinationText = new GridBagConstraints();
		gbc_destinationText.insets = new Insets(0, 0, 5, 0);
		gbc_destinationText.gridx = 0;
		gbc_destinationText.gridy = 9;
		controlPanel.add(destinationText, gbc_destinationText);

		destinationComboBox = new JComboBox<>();
		GridBagConstraints gbc_destination = new GridBagConstraints();
		gbc_destination.insets = new Insets(0, 0, 5, 0);
		gbc_destination.fill = GridBagConstraints.HORIZONTAL;
		gbc_destination.gridx = 0;
		gbc_destination.gridy = 10;
		controlPanel.add(destinationComboBox, gbc_destination);

		// Radio button 1
		leastConnections = new JRadioButton("Least Connections");
		leastConnections.setForeground(new Color(255, 255, 0));
		leastConnections.setBackground(new Color(0, 0, 255));
		leastConnections.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		leastConnections.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		leastConnections.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_leastConnections = new GridBagConstraints();
		gbc_leastConnections.insets = new Insets(0, 0, 5, 0);
		gbc_leastConnections.gridx = 0;
		gbc_leastConnections.gridy = 12;
		controlPanel.add(leastConnections, gbc_leastConnections);
		stuff.add(leastConnections);

		// Radio button 2
		cheapest = new JRadioButton("Cheapest Route");
		cheapest.setForeground(new Color(255, 255, 0));
		cheapest.setBackground(new Color(0, 0, 255));
		cheapest.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		cheapest.setHorizontalTextPosition(SwingConstants.RIGHT);
		cheapest.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_cheapest = new GridBagConstraints();
		gbc_cheapest.insets = new Insets(0, 0, 5, 0);
		gbc_cheapest.gridx = 0;
		gbc_cheapest.gridy = 13;
		controlPanel.add(cheapest, gbc_cheapest);
		stuff.add(cheapest);

		// Button
		btnBook = new JButton("Book");
		btnBook.setBackground(new Color(192, 192, 192));
		btnBook.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		btnBook.setEnabled(false);
		GridBagConstraints gbc_btnBook = new GridBagConstraints();
		gbc_btnBook.gridx = 0;
		gbc_btnBook.gridy = 18;
		controlPanel.add(btnBook, gbc_btnBook);

		windowMap = new MapWindow();
		contentPane.add(windowMap, BorderLayout.CENTER);

		JLabel unitedStates = new JLabel();
		unitedStates.setBackground(new Color(157, 193, 253));
		windowMap.setLayer(unitedStates, 100);
		windowMap.moveToFront(unitedStates);
		unitedStates.setBounds(5, 6, 893, 575);
		windowMap.add(unitedStates);
		ImageIcon usaIcon = new ImageIcon(Window.class.getResource("/airportRoute/Resources/usa.png"));
		Image scaledImage = usaIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		unitedStates.setIcon((new ImageIcon(scaledImage)));

		windowMap.moveToBack(unitedStates);

		String file = "src/airportRoute/Resources/AirportCoord.txt";
		String delimiter = ",";

		generateLabel(file, delimiter);

	}

	/*
	 * Loads airport choices into the combo boxes
	 */
	private void loadAirports() {
		for (int i = 0; i < airportMap.getSize(); i++) {
			StdOut.println("Adding to combo: " + i);
			originComboBox.addItem(airportMap.getAirport(i));
			destinationComboBox.addItem(airportMap.getAirport(i));
		}

		// refresh comboboxes
		originComboBox.revalidate();
		originComboBox.repaint();
		destinationComboBox.revalidate();
		destinationComboBox.repaint();

	}

	/*
	 * Adds function to comboboxes, radioboxes, and button
	 */
	private void addEventHandlers() {
		originComboBox.addActionListener(e -> updateBookButtonState());
		destinationComboBox.addActionListener(e -> updateBookButtonState());

		leastConnections.addActionListener(e -> updateBookButtonState());
		cheapest.addActionListener(e -> updateBookButtonState());

		btnBook.addActionListener(e -> updateRouteDisplay());

	}

	/*
	 * Updates the route display label
	 */

	private void updateRouteDisplay() {
		Airport origin = (Airport) originComboBox.getSelectedItem();
		Airport destination = (Airport) destinationComboBox.getSelectedItem();

		currentRoute = null;

		if (origin == null || destination == null) {
			displayRoute.setText("Please select both airports. ");
			return;

		}

		if (origin.equals(destination)) {
			displayRoute.setText("Origin and destination must be different.");
			return;
		}

		if (leastConnections.isSelected())
			currentRoute = findMostDirectRoute(origin, destination);
		else if (cheapest.isSelected())
			currentRoute = findCheapestRoute(origin, destination);
		else
			displayRoute.setText("Please select a route type.");

		if (currentRoute == null) {
			displayRoute.setText("No route found.");
			return;
		}

		displayRoute.setText("Route: " + currentRoute);

	}

	/*
	 * Enables or disables the Book button based on user input
	 */
	private void updateBookButtonState() {
		Airport origin = (Airport) originComboBox.getSelectedItem();
		Airport destination = (Airport) destinationComboBox.getSelectedItem();

		boolean hasOrigin = origin != null;
		boolean hasDestination = destination != null;
		boolean differentAirports = hasOrigin && hasDestination && !origin.equals(destination);
		boolean hasRouteType = leastConnections.isSelected() || cheapest.isSelected();

		btnBook.setEnabled(differentAirports && hasRouteType);

	}

	/*
	 * Finds the route with the fewest connections
	 * 
	 * Uses breadth-first search (BFS) to determine whether a path exists between
	 * the origin and destination.
	 * 
	 * @param origin the starting airport
	 * 
	 * @param origin the starting airport
	 * 
	 * @return a Route if found, otherwise null
	 */
private Route findMostDirectRoute(Airport origin, Airport destination) {
		int originIndex = airportMap.indexOf(origin.getName());
		int destinationIndex = airportMap.indexOf(destination.getName());

		BreadthFirstPaths bfs = airportMap.mostDirect(originIndex);

		if (!bfs.hasPathTo(destinationIndex)) {
			return null;
		}
		
		Double cost = 0.0;
		int pre = 0;
		boolean first = true;
		Queue<Integer> path = new Queue<>();
		for (int el : bfs.pathTo(destinationIndex)) {
			if (!first) {
				EdgeWeightedGraph sp = airportMap.getGraph();
				for (Edge e : sp.adj(pre)) {
					if ((e.either() == el &&
							e.other(e.either()) == pre)
							||
							(e.either() == pre &&
							e.other(e.either()) == el)) {
						cost += e.weight();
					}
				}
				// cost += sp.distTo(pre);
			} else {
				first = false;
			}
			path.enqueue(el);
			pre = el;
		}
		
		
		int[] airportNumber = new int[(path.size() * 2) - 2];
		
		int i = 0;
		first = true;
		for (int el : path) {
			if (!first) {
				airportNumber[i] = pre;
				airportNumber[i + 1] = el;
				i += 2;
			}
			pre = el;
			first = false;
		}
		
		Airport[] airports = new Airport[airportNumber.length];
		for (int j = 0; j < airportNumber.length; j++) {
			airports[j] = airportMap.getAirport(airportNumber[j]);
		}

		return new Route(airports, cost);
	}

	/*
	 * Finds the cheapest route between two airports.
	 * 
	 * Uses Dijkstra's shortest path algorithm to compute minimum cost.
	 * 
	 * @param origin the starting airport
	 * 
	 * @param destination airport
	 * 
	 * @return a Route if found, otherwise null
	 */
	private Route findCheapestRoute(Airport origin, Airport destination) {
		int originIndex = airportMap.indexOf(origin.getName());
		int destinationIndex = airportMap.indexOf(destination.getName());

		DijkstraUndirectedSP sp = airportMap.cheapest(originIndex);

		if (!sp.hasPathTo(destinationIndex))
			return null;

		Queue<Integer> path = new Queue<>();
		int airport = -1;
		for (Edge el : sp.pathTo(destinationIndex)) {
			if (el.either() == airportMap.indexOf(origin.getName()) || el.either() == airport) {
				path.enqueue(el.either());
				path.enqueue(el.other(el.either()));
				airport = el.other(el.either());
			} else {
				path.enqueue(el.other(el.either()));
				path.enqueue(el.either());
				airport = el.either();
			}
		}
		int[] airportNumber = new int[path.size()];

		int i = 0;
		for (int el : path) {
			airportNumber[i] = el;
			i++;
		}

		Airport[] airports = new Airport[airportNumber.length];
		for (int j = 0; j < airportNumber.length; j++) {
			airports[j] = airportMap.getAirport(airportNumber[j]);
		}

		return new Route(airports, sp.distTo(destinationIndex));
	}

	/**
	 * 
	 * generateLabel generates the label on the map by using AirportCoord.txt to get
	 * the city followed by the coordinates.
	 * 
	 * @param file
	 * @param delimiter
	 */
	private void generateLabel(String file, String delimiter) {
		In in = new In(file);

		while (in.hasNextLine()) {
			String line = in.readLine().trim();

			if (line.isEmpty())
				continue;

			String[] parts = line.split(delimiter);

			if (parts.length < 3)
				continue;

			String code = parts[0].trim();
			int x = Integer.parseInt(parts[1].trim());
			int y = Integer.parseInt(parts[2].trim());

			addAirportLabel(code, x, y);
		}

	}

	/*
	 * Adds a label for an airport at a specific position on the map.
	 * 
	 * @param code the airport code
	 * 
	 * @param x the x-coordinate
	 * 
	 * @param y the y-coordinate
	 */

	private void addAirportLabel(String code, int x, int y) {
		airport = new JLabel("· " + code);
		airport.setBounds(x, y, 36, 20);
		airport.setForeground(Color.BLUE);
		airport.setFont(new Font("Arial", Font.BOLD, 11));
		windowMap.add(airport);

	}
}
