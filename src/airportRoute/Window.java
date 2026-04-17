 package airportRoute;

import java.awt.EventQueue;
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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JRadioButton cheapest;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/**
		ControlPanel.display(contentPane);
		
		MapWindow.display(contentPane);
		
		Airport.display(contentPane);
		*/
		
		display(contentPane);	
	}

	private void display(JPanel contentPane2) {
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		JLabel displayRoute = new JLabel("This Work Some Day");
		displayRoute.setBackground(new Color(255, 255, 255));
		southPanel.add(displayRoute);
		
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
		
		JLabel unitedStates = new JLabel();
		ImageIcon usaIcon = new ImageIcon(Window.class.getResource("/airportRoute/Resources/usa.png"));
																//width, height
		Image scaledImage = usaIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		unitedStates.setIcon((new ImageIcon(scaledImage)));
		contentPane.add(unitedStates, BorderLayout.CENTER);
	}
}
