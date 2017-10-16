package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import services.CalculationServiceRemote;

public class CalculationGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static String operationSelected;
	private static Context context;
	private CalculationServiceRemote calculationServiceRemote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculationGui frame = new CalculationGui();
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
	public CalculationGui() {
		try {
			context = new InitialContext();
			calculationServiceRemote = (CalculationServiceRemote) context.lookup(
					"sigma-smart-safe-ear/sigma-smart-safe-ejb/CalculationService!services.CalculationServiceRemote");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblA = new JLabel("a");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblB = new JLabel("b");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationSelected = "+";
			}
		});

		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationSelected = "-";
			}
		});

		JButton button_2 = new JButton("/");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationSelected = "/";
			}
		});

		JButton button_3 = new JButton("*");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationSelected = "*";
			}
		});

		JLabel lblResult = new JLabel("result");

		JLabel lblNewLabel = new JLabel("");

		JButton button_4 = new JButton("=");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(operationSelected);
				switch (operationSelected) {
				case "+":
					lblNewLabel.setText(String.valueOf(calculationServiceRemote
							.sum(Integer.valueOf(textField.getText()), Integer.valueOf(textField_1.getText()))));
					break;
				case "-":
					lblNewLabel.setText(String.valueOf(calculationServiceRemote
							.substract(Integer.valueOf(textField.getText()), Integer.valueOf(textField_1.getText()))));
					break;
				case "/":
					lblNewLabel.setText(String.valueOf(calculationServiceRemote
							.divide(Integer.valueOf(textField.getText()), Integer.valueOf(textField_1.getText()))));
					break;
				case "*":
					lblNewLabel.setText(String.valueOf(calculationServiceRemote
							.multiply(Integer.valueOf(textField.getText()), Integer.valueOf(textField_1.getText()))));
				
				}


			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane
												.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
																.createSequentialGroup().addGap(24)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblA).addComponent(
																				lblB, GroupLayout.PREFERRED_SIZE, 43,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addGap(12).addComponent(textField,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(lblNewLabel)
																						.addComponent(textField_1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
																.addGap(77)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(button_3).addComponent(button_2)
																		.addComponent(button_1).addComponent(button)))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addContainerGap().addComponent(lblResult))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addContainerGap().addComponent(button_4)))
												.addContainerGap(141, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(32)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblA)
										.addComponent(textField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(button))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(26).addComponent(lblB))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(textField_1,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(button_1)))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(button_2).addGap(18)
						.addComponent(button_3).addGap(7).addComponent(button_4)
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblResult)
								.addComponent(lblNewLabel))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	public static String getOperationSelected() {
		return operationSelected;
	}

	public static void setOperationSelected(String operationSelected) {
		CalculationGui.operationSelected = operationSelected;
	}

}
