package airportRoute;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.io.File;

import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JRadioButton;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 22, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel origin = new JLabel("Origin");
		GridBagConstraints gbc_Origin = new GridBagConstraints();
		gbc_Origin.insets = new Insets(0, 0, 5, 0);
		gbc_Origin.gridx = 0;
		gbc_Origin.gridy = 1;
		panel.add(origin, gbc_Origin);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel destination = new JLabel("Destination");
		GridBagConstraints gbc_destination = new GridBagConstraints();
		gbc_destination.insets = new Insets(0, 0, 5, 0);
		gbc_destination.gridx = 0;
		gbc_destination.gridy = 4;
		panel.add(destination, gbc_destination);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 5;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Least Connections");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 7;
		panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JLabel imgLabel = new JLabel("New label");
		
		
		
		/*ImageIcon usaIcon = new ImageIcon("/airportRoute/Resources/usa.png");
		Image scaledImage = usaIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image img = usaIcon.getImage();
		Image imgScale = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		imgLabel.setIcon(scaledIcon);
		*/
		
		
		JLabel unitedStates = new JLabel("unitedStates");
//		unitedStates.setSize(1,1);
//		unitedStates.setIcon(new ImageIcon(Window.class.getResource("/airportRoute/Resources/usa.png")));
		ImageIcon usaIcon = new ImageIcon(Window.class.getResource("/airportRoute/Resources/usa.png"));
																//width, height
		Image scaledImage = usaIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		unitedStates.setIcon((new ImageIcon(scaledImage)));
		contentPane.add(unitedStates, BorderLayout.CENTER);
	}

}
