import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final DisplayValue DisplayValue = null;
	private JPanel contentPane;
	private JTextField speedPilot;
	private JTextField altitudePilot;
	private JTextField landtimePilot;
	private JTextField copilotSpeed;
	private JTextField copilotAltitude;
	private JTextField copilotLandtime;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface(null);
					frame.setVisible(true);
					frame.setTitle("Flight Landing Simulator");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Interface(DisplayValue DV) {
		setTitle("Aircraft Landing Simulation System");
		
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		Font font2 = new Font("SansSerif", Font.BOLD, 15);
		Color red = new Color(229,45,45);
		Color yellow = new Color(255,255,76);
		Color grey = new Color(70,70,70);
		Color green = new Color(90,223,90);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 884, 437);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(102, 102, 102));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setForeground(Color.WHITE);
		lblSpeed.setBounds(42, 245, 65, 14);
		contentPane.add(lblSpeed);
		
		JLabel lblAltitude = new JLabel("Altitude:");
		lblAltitude.setForeground(Color.WHITE);
		lblAltitude.setBounds(36, 272, 71, 14);
		contentPane.add(lblAltitude);
		
		JLabel lblLandtime = new JLabel("Landing Time:");
		lblLandtime.setForeground(Color.WHITE);
		lblLandtime.setBounds(196, 245, 93, 14);
		contentPane.add(lblLandtime);
		
		speedPilot = new JTextField();
		speedPilot.setBounds(95, 241, 86, 20);
		speedPilot.setFont(font2);
		contentPane.add(speedPilot);
		speedPilot.setColumns(10);
		speedPilot.setText(""+DV.speed);
		
		altitudePilot = new JTextField();
		altitudePilot.setBounds(95, 272, 86, 20);
		altitudePilot.setFont(font2);
		contentPane.add(altitudePilot);
		altitudePilot.setColumns(10);
		
		landtimePilot = new JTextField();
		landtimePilot.setBounds(301, 241, 86, 20);
		landtimePilot.setFont(font2);
		contentPane.add(landtimePilot);
		landtimePilot.setColumns(10);
		
		JToggleButton pilotAudio = new JToggleButton("AUDIO ALARM ON");
		pilotAudio.doClick();
		pilotAudio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(pilotAudio.isSelected())
				{
					pilotAudio.setText("AUDIO ALARM ON");
					pilotAudio.setBackground(green);
				}
				else
				{
					pilotAudio.setBackground(red);
					pilotAudio.setText("AUDIO ALARM OFF");
					
				}
			}
		});
		pilotAudio.setBounds(32, 193, 163, 31);
		contentPane.add(pilotAudio);
		
		
		JTextArea pilotAlarm = new JTextArea();
		pilotAlarm.setText("Speed");
		pilotAlarm.setAlignmentX(SwingConstants.LEFT);
		pilotAlarm.setAlignmentY(SwingConstants.TOP);
		//pilotAlarm.setBackground(green);
		pilotAlarm.setBackground(Color.GREEN);
		pilotAlarm.setFont(font1);
		pilotAlarm.setAlignmentX(JTextField.CENTER);
		pilotAlarm.setForeground(Color.WHITE);
		pilotAlarm.setBounds(32, 40, 95, 84);
		contentPane.add(pilotAlarm);
		
		JTextArea pilotWarning = new JTextArea();
		pilotWarning.setBackground(Color.WHITE);
		//pilotWarning.setBackground(Color.white);
		pilotWarning.setFont(font1);
		pilotWarning.setBounds(205, 77, 203, 47);
		contentPane.add(pilotWarning);
		
		JToggleButton pilotGearToggle = new JToggleButton("Gear DOWN");
		pilotGearToggle.setBounds(205, 193, 163, 31);
		contentPane.add(pilotGearToggle);
		//pilotGearToggle.doClick();
		pilotGearToggle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(pilotGearToggle.isSelected())
				{
					pilotGearToggle.setText("Gear UP");
				}
				else
				{
					pilotGearToggle.setText("Gear DOWN");
				}
			}
		});
		
		JTextArea copilotWarning = new JTextArea();
		copilotWarning.setBackground(Color.WHITE);
		//copilotWarning.setBackground(Color.white);
		copilotWarning.setFont(font1);
		copilotWarning.setBounds(607, 77, 205, 47);
		contentPane.add(copilotWarning);
		
		JTextArea copilotAlarm = new JTextArea();
		//copilotAlarm.setBackground(green);
		copilotAlarm.setBackground(Color.GREEN);
		copilotAlarm.setFont(font1);
		copilotAlarm.setForeground(Color.white);
		copilotAlarm.setBounds(434, 77, 163, 47);
		contentPane.add(copilotAlarm);
		
		copilotSpeed = new JTextField();
		copilotSpeed.setColumns(10);
		copilotSpeed.setFont(font2);
		copilotSpeed.setBounds(488, 240, 86, 20);
		contentPane.add(copilotSpeed);
		
		copilotAltitude = new JTextField();
		copilotAltitude.setColumns(10);
		copilotAltitude.setBounds(488, 265, 86, 20);
		copilotAltitude.setFont(font2);
		contentPane.add(copilotAltitude);
		
		copilotLandtime = new JTextField();
		copilotLandtime.setColumns(10);
		copilotLandtime.setBounds(674, 240, 86, 20);
		copilotLandtime.setFont(font2);
		contentPane.add(copilotLandtime);
		
		JLabel lblPilot = new JLabel("PILOT");
		lblPilot.setFont(font1);
		lblPilot.setForeground(Color.WHITE);
		lblPilot.setBounds(62, 364, 65, 16);
		contentPane.add(lblPilot);
		
		JLabel lblCopilot = new JLabel("CO-PILOT");
		lblCopilot.setFont(font1);
		lblCopilot.setForeground(Color.WHITE);
		lblCopilot.setBounds(563, 18, 105, 16);
		contentPane.add(lblCopilot);
		
		JButton pilotSpeedAdd = new JButton("Speed +");
		pilotSpeedAdd.setBounds(101, 325, 90, 28);
		contentPane.add(pilotSpeedAdd);
		
		JButton pilotSpeedMinus = new JButton("Speed -");
		pilotSpeedMinus.setBounds(192, 325, 90, 28);
		contentPane.add(pilotSpeedMinus);
		
		JLabel lblAlarm = new JLabel("ALARM");
		lblAlarm.setFont(font2);
		lblAlarm.setForeground(Color.WHITE);
		lblAlarm.setBounds(36, 329, 55, 16);
		contentPane.add(lblAlarm);
		
		JLabel lblWarning = new JLabel("WARNING");
		lblWarning.setFont(font2);
		lblWarning.setForeground(Color.WHITE);
		lblWarning.setBounds(216, 366, 82, 16);
		contentPane.add(lblWarning);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(1);
		separator.setBounds(420, 12, 2, 396);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Speed:");
		label.setForeground(Color.WHITE);
		label.setBounds(445, 244, 41, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Altitude:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(434, 269, 52, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Landing Time:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(589, 244, 90, 14);
		contentPane.add(label_2);
		
		JLabel label_4 = new JLabel("ALARM");
		label_4.setFont(font2);
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(498, 49, 55, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("WARNING");
		label_5.setFont(font2);
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(652, 49, 71, 16);
		contentPane.add(label_5);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(674, 265, 86, 20);
		contentPane.add(textField);
		
		JLabel lblGearStatus = new JLabel("Gear Status:");
		lblGearStatus.setForeground(Color.WHITE);
		lblGearStatus.setBounds(586, 272, 90, 14);
		contentPane.add(lblGearStatus);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.BOLD, 20));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(607, 137, 205, 47);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		textArea_1.setBackground(Color.GREEN);
		textArea_1.setBounds(434, 137, 163, 47);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setBounds(205, 137, 203, 47);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setForeground(Color.WHITE);
		textArea_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		textArea_3.setBackground(Color.GREEN);
		textArea_3.setBounds(32, 137, 163, 47);
		contentPane.add(textArea_3);
		
		JLabel lblGearStatus_1 = new JLabel("Gear Status:");
		lblGearStatus_1.setForeground(Color.WHITE);
		lblGearStatus_1.setBounds(199, 272, 93, 14);
		contentPane.add(lblGearStatus_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(301, 272, 86, 20);
		contentPane.add(textField_1);
		
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button){
					
				}
			}
		});
		button.setBounds(318, 349, 90, 28);
		contentPane.add(button);
		
	}

}
