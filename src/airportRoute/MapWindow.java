package airportRoute;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import edu.princeton.cs.algs4.StdOut;

/**
 * MapWindow is the widow that shows the map for the Window It has 2 methods
 * being zoom and icon.
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
@SuppressWarnings("serial")
public class MapWindow extends JLayeredPane {
	private String city;
	private int zoomLevel;
	// private JLayeredPane windowMap;
	// private Airport origin;
	// private Airport destination;

	/**
	 * 
	 * @param inOrOut the positive or negative zoom value
	 */

	public MapWindow() {
		// this.city = city;
		this.zoomLevel = 100;
	}

	public void zoom(int inOrOut) {
		zoomLevel += inOrOut;

		if (zoomLevel >= 10)
			zoomLevel = 10;

	}

	/**
	 * The point of a city
	 */
	public void icon() {
		StdOut.println("Displaying icon for " + city);
	}

	public static void display(JPanel contentPane) {
		JLabel unitedStates = new JLabel();
		ImageIcon usaIcon = new ImageIcon(Window.class.getResource("/airportRoute/Resources/usa.png"));
		Image scaledImage = usaIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		unitedStates.setIcon((new ImageIcon(scaledImage)));
		contentPane.add(unitedStates, BorderLayout.CENTER);
	}

	/*
	 * Sets route
	 */
	/*
	 * public void setRoute(Airport origin, Airport destination) { this.origin =
	 * origin; this.destination = destination; repaint(); }
	 */

	// This is attempting to draw the line between to labels
	// @Override
	/*
	 * protected void paintComponent(java.awt.Graphics g) { super.paintComponent(g);
	 * 
	 * if (origin != null && destination != null) { int[] start =
	 * getPoint(origin.getName()); int[] end = getPoint(destination.getName());
	 * 
	 * if (start != null && end != null) { g.setColor(Color.RED);
	 * g.drawLine(start[0], start[1], end[0], end[1]); } } }*
	 * 
	 * 
	 * /*private int[] getPoint(String code) { if (code.equals("SLC")) return new
	 * int[] { 252, 220 }; if (code.equals("PVU")) return new int[] { 253, 229 }; if
	 * (code.equals("OGD")) return new int[] { 253, 200 }; if (code.equals("SGU"))
	 * return new int[] { 233, 270 }; if (code.equals("JFK")) return new int[] {
	 * 735, 195 }; if (code.equals("ATL")) return new int[] { 615, 355 };
	 * 
	 * return null; }
	 */

}