package airportRoute;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class Airport {
	private String name;
	// private double price;

	public Airport(String name) {
		this.name = name;
	}

	/////// New methods///////////////////////////////////////////////
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	///////////////////////////////////////////////////////////////////
	public static void display(JPanel contentPane) {
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);

		JLabel displayRoute = new JLabel();
		displayRoute.setBackground(new Color(255, 255, 255));
		southPanel.add(displayRoute);
	}

}