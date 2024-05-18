package User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Dao.HesabDao;
import Dao.UserDao;
import Dao.VamDao;
import Main.UserLoginForm;

public class BastanHesab {

	private JFrame frame;
	private UserHome userhome;
	private UserLoginForm uloginf;

	private long memberid;

	HesabDao hesabDao = new HesabDao();
	UserDao userDao = new UserDao();
	VamDao vamDao = new VamDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BastanHesab window = new BastanHesab();
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
	public BastanHesab() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public BastanHesab(long memberid) throws ClassNotFoundException, SQLException {
		setMemberid(memberid);
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
		frame.setTitle("\u0628\u0633\u062A\u0646 \u062D\u0633\u0627\u0628");
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 153, 102));
		panel_2.setBounds(0, 0, 786, 115);
		frame.getContentPane().add(panel_2);

		JLabel lblNewLabel_5 = new JLabel(
				"\u0633\u06CC\u0633\u062A\u0645 \u0628\u0627\u0646\u06A9\u062F\u0627\u0631\u06CC \u0646\u0648\u06CC\u0646");
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
		panel.setBounds(124, 136, 556, 191);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u062D\u0633\u0627\u0628");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(458, 52, 38, 13);
		panel.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(93, 49, 299, 21);
		ResultSet rs = hesabDao.SelectByMemberId(getMemberid());

		while (rs.next()) {
			comboBox.addItem(rs.getObject("HesabId"));
		}
		panel.add(comboBox);

		JButton btnNewButton = new JButton("\u062A\u0627\u06CC\u06CC\u062F");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(306, 121, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					boolean flag = false;
					ResultSet vam = vamDao.SelectByHesabId(Long.parseLong(comboBox.getSelectedItem().toString()));
					while (vam.next())
						flag = true;
					if (flag)
						JOptionPane.showMessageDialog(frame,
								"اقساط مربوط به وام گرفته شده از طریق این حساب کامل نشده است!!!");
					else {
						if (comboBox.getItemCount() < 2) {

							int a = JOptionPane.showConfirmDialog(null,
									"با توجه به این که شما یک حساب بیشتر در این بانک ندارید در صورت بستن حساب دسترسی شما به این سامانه به طور کامل قطع خواهد شد.     آیا موافقید؟");
							if (a == 0) {

								hesabDao.Bastanhesab(Long.parseLong(comboBox.getSelectedItem().toString()));
								userDao.Remove(getMemberid());
								frame.dispose();
								uloginf = new UserLoginForm();

							}

							else {

								frame.dispose();
								userhome = new UserHome(getMemberid());
							}
						}

						else {
							int a = JOptionPane.showConfirmDialog(null, "آیا مطمعن هستید؟");
							if (a == 0) {

								hesabDao.Bastanhesab(Long.parseLong(comboBox.getSelectedItem().toString()));
								frame.dispose();
								uloginf = new UserLoginForm();

							}

							else {

								frame.dispose();
								userhome = new UserHome(getMemberid());
							}
						}
					}

				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u0627\u0646\u0635\u0631\u0627\u0641");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					userhome = new UserHome(getMemberid());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(211, 121, 85, 21);
		panel.add(btnNewButton_1);
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

}
