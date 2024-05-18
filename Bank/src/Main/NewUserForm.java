package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Dao.HesabDao;
import Dao.NoeHesabDao;
import Dao.UserDao;

public class NewUserForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JLabel Slabel9;

	private UserLoginForm ulf;

	UserDao userDao = new UserDao();
	HesabDao hesabDao = new HesabDao();
	NoeHesabDao noehesabDao = new NoeHesabDao();

	private long memberid;
	private long noehesabid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserForm window = new NewUserForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public NewUserForm() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(122, 35, 348, 487);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel Slabel1 = new JLabel("نام:");
		Slabel1.setBounds(225, 50, 46, 14);
		panel.add(Slabel1);

		JLabel Slabel2 = new JLabel("نام خوانوادگی:");
		Slabel2.setBounds(225, 87, 74, 14);
		panel.add(Slabel2);

		JLabel Slabel3 = new JLabel("کد ملی:");
		Slabel3.setBounds(225, 126, 46, 14);
		panel.add(Slabel3);

		JLabel Slabel14 = new JLabel("تاریخ تولد:");
		Slabel14.setBounds(225, 166, 58, 14);
		panel.add(Slabel14);

		JLabel Slabel5 = new JLabel("تلفن همراه:");
		Slabel5.setBounds(225, 213, 58, 14);
		panel.add(Slabel5);

		JLabel Slabel6 = new JLabel("آدرس:");
		Slabel6.setBounds(225, 255, 46, 14);
		panel.add(Slabel6);

		JLabel Slabel7 = new JLabel("نام کاربری:");
		Slabel7.setBounds(225, 295, 74, 14);
		panel.add(Slabel7);

		JLabel Slabel8 = new JLabel("رمز عبور:");
		Slabel8.setBounds(225, 340, 46, 14);
		panel.add(Slabel8);

		textField = new JTextField();
		textField.setBounds(141, 47, 74, 20);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(120, 84, 95, 20);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(129, 123, 86, 20);
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(129, 163, 86, 20);
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(129, 210, 86, 20);
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(10, 252, 205, 20);
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(129, 292, 86, 20);
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_6);
		textField_6.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(129, 337, 86, 20);
		panel.add(passwordField);

		Slabel9 = new JLabel("نوع حساب:");
		Slabel9.setBounds(225, 383, 58, 14);
		panel.add(Slabel9);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(98, 379, 117, 22);
		ResultSet rs = noehesabDao.GetAll();

		while (rs.next()) {
			comboBox.addItem(rs.getObject("HesabName"));
		}
		panel.add(comboBox);

		JButton btnNewButton = new JButton("انصراف");
		btnNewButton.setBounds(10, 436, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ثبت نام و درخواست ایجاد حساب");
		btnNewButton_1.setBounds(159, 436, 179, 23);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				userDao.setName(textField.getText());
				userDao.setFamily(textField_1.getText());
				userDao.setMellicode(Long.parseLong(textField_2.getText()));
				userDao.setDate(textField_3.getText());
				userDao.setPhone(textField_4.getText());
				userDao.setAdress(textField_5.getText());
				userDao.setUsername(textField_6.getText());
				userDao.setPassword(passwordField.getText());
				try {
					userDao.AddNewUser();

					setMemberid(userDao.SelectByMellicode(Long.parseLong(textField_2.getText())));

					hesabDao.setMemberid(getMemberid());
					hesabDao.setNoehesabid(comboBox.getSelectedIndex() + 6);
					hesabDao.IjadHesab();
					ulf = new UserLoginForm();
					frame.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnNewButton_1);

		frame.setVisible(true);
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public long getNoehesabid() {
		return noehesabid;
	}

	public void setNoehesabid(long noehesabid) {
		this.noehesabid = noehesabid;
	}
}
