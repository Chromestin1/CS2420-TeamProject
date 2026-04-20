package airportRoute;

import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class Route {
	private double cost;
	private Route shortRoute;
	private Airport origin;
	private Airport destination;
	
	
	public Route(Airport origin, Airport destination, double cost) {
		this.origin = origin;
		this.destination = destination;
		this.cost = cost;
		this.shortRoute = this;
	}
	
	/**
	 * Calculates the shortest path
	 * 
	 * For now, this compares the current route cost with the stored shortRoute
	 * and updates it if this route is cheaper.
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
		
		cost  = newCost;
		return cost;
	}
	
	/*
	 * Checks whether a passenger can take this route.
	 * 
	 * 
	 */
	public void checkPassenger() {
		if (origin == null || destination == null)
			throw new IllegalArgumentException("Route must have an origin and destination");
	}
	
	/**
	 * Books the trip
	 */
	public void book() {
		checkPassenger();
		
		StdOut.println("Trip booked from " + origin + " to " + destination + " for $" + cost);
	}
	
	
	
}
