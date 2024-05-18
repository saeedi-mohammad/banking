package User;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Eoperator {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eoperator window = new Eoperator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Eoperator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setTitle("ارتباط با اپراتور");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 786, 115);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 153, 102));
		frame.getContentPane().add(panel_2);

		JLabel lblNewLabel_5 = new JLabel("سیستم بانکداری نوین");
		lblNewLabel_5.setForeground(new Color(204, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_5.setBounds(542, 10, 244, 62);
		panel_2.add(lblNewLabel_5);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 102, 51));
		panel_3.setBounds(0, 68, 786, 47);
		panel_2.add(panel_3);

		JLabel lblNewLabel_2_1 = new JLabel("BNovin");
		lblNewLabel_2_1.setFont(new Font("Blackadder ITC", Font.BOLD, 40));
		lblNewLabel_2_1.setBounds(10, 10, 134, 62);
		panel_2.add(lblNewLabel_2_1);

		JPanel panel = new JPanel();
		panel.setBounds(87, 125, 611, 415);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("موضوع:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(527, 24, 53, 13);
		panel.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "پیگیری وام", "تراکنش ها", "مغایر بودن اطلاعات حساب", "سایر" }));
		comboBox.setBounds(342, 21, 175, 21);
		panel.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("شرح درخواست:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(479, 52, 101, 13);
		panel.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(76, 75, 473, 272);
		textArea.setLineWrap(true);
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textArea);

		JButton btnNewButton = new JButton("ارسال");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(316, 367, 85, 21);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("انصراف");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(230, 367, 85, 21);
		panel.add(btnNewButton_1);
	}
}
