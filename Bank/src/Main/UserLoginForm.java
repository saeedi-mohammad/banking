package Main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Dao.HesabDao;
import Dao.UserDao;
import User.UserHome;

public class UserLoginForm {

	private JFrame frame;
	private JTextField textF1;
	private JPasswordField passwordField;

	private long memberid;

	private UserHome uhome;
	private Main main;

	UserDao uDao = new UserDao();
	HesabDao hesabDao = new HesabDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginForm window = new UserLoginForm();
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
	public UserLoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.shadow"));
		frame.setBounds(100, 100, 500, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(128, 104, 225, 163);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btn1 = new JButton("ورود");
		btn1.setBounds(126, 129, 89, 23);
		frame.getRootPane().setDefaultButton(btn1);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				long a = 0;

				try {

					a = uDao.CheakUserLogin(textF1.getText(), passwordField.getText());

					if (a != 0) {

						setMemberid(a);
						while (hesabDao.SelectByMemberId(a).next()) {
							uhome = new UserHome(getMemberid());
							frame.dispose();
							return;
						}

						JOptionPane.showMessageDialog(frame, "درخواست ایجاد حساب شما بررسی نشده است.");

					}

					else {
						JOptionPane.showMessageDialog(frame, "نام کاربری یا رمز عبور اشتباه است!!");
					}

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(21, 84, 113, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);
		panel.add(btn1);

		JButton btn2 = new JButton("برگشت");
		btn2.setBounds(10, 129, 89, 23);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				main = new Main();
				frame.dispose();

			}
		});
		panel.add(btn2);

		textF1 = new JTextField();
		textF1.setBounds(21, 53, 113, 20);
		panel.add(textF1);
		textF1.setColumns(10);

		JLabel Label1 = new JLabel("ورود:");
		Label1.setFont(new Font("B Nazanin", Font.PLAIN, 18));
		Label1.setBounds(187, 11, 28, 23);
		panel.add(Label1);

		JLabel Label2 = new JLabel("نام کاربری:");
		Label2.setBounds(144, 56, 56, 14);
		panel.add(Label2);

		JLabel Label3 = new JLabel("رمز عبور:");
		Label3.setBounds(145, 87, 46, 14);
		panel.add(Label3);

		frame.setVisible(true);
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}
}
