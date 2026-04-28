package airportRoute;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents an airport.
 * 
 * Stores the airport code and provides display functionality.
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class Airport {
	private String name;

	/*
	 * Constructs an Airport with the given name.
	 * 
	 * @param name the airport code
	 */
	public Airport(String name) {
		this.name = name;
	}

	/*
	 * Returns the airport code.
	 * 
	 * @return the airport name
	 */
	public String getName() {
		return name;
	}

	/*
	 * Returns the airport code as a string
	 * 
	 * @return the airport name
	 */
	@Override
	public String toString() {
		return name;
	}

	/*
	 * Creates a display panel for showing route information.
	 * 
	 * This method adds a panel to the SOUTH region of the container and places a
	 * label that can later be updated with route details
	 * 
	 * @param contentPane the main container to which the display is added
	 */
	public static void display(JPanel contentPane) {
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);

		JLabel displayRoute = new JLabel();
		displayRoute.setBackground(new Color(255, 255, 255));
		southPanel.add(displayRoute);
	}

}