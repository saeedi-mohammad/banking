package Karmand;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Dao.HesabDao;
import Dao.UserDao;
import Dao.VarizDao;

public class OtherVariz {

	private JFrame frame;

	private OtherVariz ov;

	UserDao userDao = new UserDao();
	VarizDao varizDao = new VarizDao();
	HesabDao hesabDao = new HesabDao();

	private long operatorid;
	private long memberid;

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtherVariz window = new OtherVariz();
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
	public OtherVariz() {
		initialize();
	}

	public OtherVariz(long operatorid) {
		setOperatorid(operatorid);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setBounds(100, 100, 529, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("واریز");
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel Slabel1 = new JLabel("نام واریز کننده:");
		Slabel1.setBounds(293, 54, 80, 14);
		frame.getContentPane().add(Slabel1);

		JLabel Slabel2 = new JLabel("نام خانوادگی واریز کننده:");
		Slabel2.setBounds(293, 89, 112, 14);
		frame.getContentPane().add(Slabel2);

		JLabel Slabel3 = new JLabel("کد ملی واریز کننده:");
		Slabel3.setBounds(293, 126, 89, 14);
		frame.getContentPane().add(Slabel3);

		JLabel Slabel4 = new JLabel("به شماره حساب:");
		Slabel4.setBounds(293, 161, 80, 14);
		frame.getContentPane().add(Slabel4);

		JLabel Slabel5 = new JLabel("مبلغ واریز:");
		Slabel5.setBounds(293, 192, 80, 14);
		frame.getContentPane().add(Slabel5);

		textField1 = new JTextField();
		textField1.setBounds(197, 51, 86, 20);
		textField1.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(197, 86, 86, 20);
		textField2.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(textField2);

		textField3 = new JTextField();
		textField3.setColumns(11);
		textField3.setBounds(197, 123, 86, 20);
		frame.getContentPane().add(textField3);

		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(197, 158, 86, 20);
		frame.getContentPane().add(textField4);

		textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(197, 189, 86, 20);
		frame.getContentPane().add(textField5);

		JButton btnNewButton = new JButton("انصراف");
		btnNewButton.setBounds(139, 255, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("تایید");
		btnNewButton_1.setBounds(267, 255, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				userDao.setName(textField1.getText());
				userDao.setFamily(textField2.getText());
				userDao.setMellicode(Long.parseLong(textField3.getText()));

				varizDao.setHesabid(Long.parseLong(textField4.getText()));
				varizDao.setMablaghvariz(Long.parseLong(textField5.getText()));
				varizDao.setOperatorid(getOperatorid());
				try {
					userDao.AddNewOtherUser();
					setMemberid(userDao.SelectByMellicode(Long.parseLong(textField3.getText())));

					varizDao.setMemberid(getMemberid());
					varizDao.ForceVariz();

					long mojudi = hesabDao.getMojudi(Long.parseLong(textField4.getText()));
					hesabDao.IncreaseMojudi(Long.parseLong(textField4.getText()), Long.parseLong(textField5.getText()));

					ov = new OtherVariz();
					JOptionPane.showMessageDialog(frame, "واریز با موفقیت انجام شد.");
					frame.dispose();

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(btnNewButton_1);
	}

	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}
}
