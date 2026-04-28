package airportRoute;

import edu.princeton.cs.algs4.StdOut;

/**
 * Represents a route between two airports
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class Route {
	private double cost;
	private Route shortRoute;
	private Airport[] airports;

	public Route(Airport[] airports, double cost) {
		this.airports = airports;
		this.cost = cost;
		this.shortRoute = this;
	}

	/**
	 * Calculates the shortest path
	 * 
	 * For now, this compares the current route cost with the stored shortRoute and
	 * updates it if this route is cheaper.
	 */
	public void calcPath() {
		if (shortRoute == null || this.cost < shortRoute.cost)
			shortRoute = this;
	}

	/**
	 * Updates the cost of the trip.
	 * 
	 * @param newCost the new route cost
	 * @return the updatedCost of the trip
	 * @throws IllegalArgumentException if newCost is negative
	 */
	public double updateCost(Double newCost) {
		if (newCost == null || newCost < 0)
			throw new IllegalArgumentException("Cost must be non-negative");

		cost = newCost;
		return cost;
	}

	/*
	 * Checks whether a passenger can take this route.
	 * 
	 * @throws IllegalArgumentException if either is null
	 */
	public void checkPassenger() {
		if (airports[0] == null || airports[airports.length - 1] == null)
			throw new IllegalArgumentException("Route must have an origin and destination");
	}

	/**
	 * Books route and displays confirmation
	 */
	public void book() {
		checkPassenger();

		StdOut.println("Trip booked from " + airports[0] + " to " + airports[airports.length - 1] + " for $" + cost);
	}

	/*
	 * Returns the airport code as a string.
	 * 
	 * @return the airport name
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < airports.length; i += 2) {
			sb.append(airports[i] + " -> " + airports[i + 1]);
			sb.append(" | ");
		}
		return sb.toString() + " ($" + String.format("%.2f",cost) + ")";
	}

}
