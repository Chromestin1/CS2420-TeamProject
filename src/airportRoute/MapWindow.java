package airportRoute;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.princeton.cs.algs4.StdOut;

/**
 * MapWindow is the widow that shows the map for the Window
 * It has 2 methods being zoom and icon.
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class MapWindow {
	private String city;
	private int zoomLevel;
	
	/**
	 * 
	 * @param inOrOut the positive or negative zoom value
	 */
	
	public MapWindow(String city) {
		this.city = city;
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
																//width, height
		Image scaledImage = usaIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		unitedStates.setIcon((new ImageIcon(scaledImage)));
		contentPane.add(unitedStates, BorderLayout.CENTER);
	}
}
