package airportRoute;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MapWindow is the widow that shows the map for the Window
 * It has 2 methods being zoom and icon.
 * 
 * @author Benjamin Shaw & Ian Shoell
 */
public class MapWindow {
	private String city;
	
	/**
	 * 
	 * @param inOrOut the positive or negative zoom value
	 */
	public void zoom(int inOrOut) {
		if (inOrOut >= 0) {
			
		} else if (inOrOut <= 0) {
			
		}
	}
	
	/**
	 * The point of a city
	 */
	public void icon() {
		
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
