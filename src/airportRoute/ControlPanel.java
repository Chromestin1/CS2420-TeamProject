package airportRoute;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class ControlPanel {
	
	private static JRadioButton cheapest;

	public static void display(JPanel contentPane) {
		JPanel controlPanel = new JPanel();
		contentPane.add(controlPanel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		controlPanel.setLayout(gbl_panel);
		
		ButtonGroup stuff = new ButtonGroup();
		
		JLabel originText = new JLabel("Origin");
		GridBagConstraints gbc_originText = new GridBagConstraints();
		gbc_originText.insets = new Insets(0, 0, 5, 0);
		gbc_originText.gridx = 0;
		gbc_originText.gridy = 6;
		controlPanel.add(originText, gbc_originText);
		
		JComboBox<?> origin = new JComboBox<>();
		GridBagConstraints gbc_origin = new GridBagConstraints();
		gbc_origin.fill = GridBagConstraints.HORIZONTAL;
		gbc_origin.insets = new Insets(0, 0, 5, 0);
		gbc_origin.gridx = 0;
		gbc_origin.gridy = 7;
		controlPanel.add(origin, gbc_origin);
		
		JLabel destinationText = new JLabel("Destination");
		GridBagConstraints gbc_destinationText = new GridBagConstraints();
		gbc_destinationText.insets = new Insets(0, 0, 5, 0);
		gbc_destinationText.gridx = 0;
		gbc_destinationText.gridy = 9;
		controlPanel.add(destinationText, gbc_destinationText);
		
		JComboBox<?> destination = new JComboBox<>();
		GridBagConstraints gbc_destination = new GridBagConstraints();
		gbc_destination.insets = new Insets(0, 0, 5, 0);
		gbc_destination.fill = GridBagConstraints.HORIZONTAL;
		gbc_destination.gridx = 0;
		gbc_destination.gridy = 10;
		controlPanel.add(destination, gbc_destination);
		
		JRadioButton leastConnections = new JRadioButton("Least Connections");
		leastConnections.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		leastConnections.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_leastConnections = new GridBagConstraints();
		gbc_leastConnections.insets = new Insets(0, 0, 5, 0);
		gbc_leastConnections.gridx = 0;
		gbc_leastConnections.gridy = 12;
		controlPanel.add(leastConnections, gbc_leastConnections);
		stuff.add(leastConnections);
		
		cheapest = new JRadioButton("Cheapest Route");
		cheapest.setHorizontalTextPosition(SwingConstants.RIGHT);
		cheapest.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_cheapest = new GridBagConstraints();
		gbc_cheapest.insets = new Insets(0, 0, 5, 0);
		gbc_cheapest.gridx = 0;
		gbc_cheapest.gridy = 13;
		controlPanel.add(cheapest, gbc_cheapest);
		stuff.add(cheapest);
		
		JButton btnBook = new JButton("Book");
		btnBook.setEnabled(false);
		GridBagConstraints gbc_btnBook = new GridBagConstraints();
		gbc_btnBook.gridx = 0;
		gbc_btnBook.gridy = 18;
		controlPanel.add(btnBook, gbc_btnBook);
	}
}