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
import javax.swing.JTextField;

import Dao.HesabDao;
import Dao.NoeVamDao;
import Dao.VamDao;

public class DarkhastVam {

	private JFrame frame;
	private JTextField textField;

	private long memberid;

	HesabDao hesabDao = new HesabDao();
	NoeVamDao noevamDao = new NoeVamDao();
	VamDao vamDao = new VamDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarkhastVam window = new DarkhastVam();
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
	public DarkhastVam() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public DarkhastVam(long memberid) throws ClassNotFoundException, SQLException {
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
		frame.setTitle("\u062F\u0631\u062E\u0648\u0627\u0633\u062A \u0648\u0627\u0645");
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
		panel.setBounds(32, 130, 724, 397);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("بسمه تعالی");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(338, 10, 77, 13);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("با سلام و احترام؛");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(599, 85, 98, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("اینجانب دارای حساب بانکی ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(530, 120, 167, 13);
		panel.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(357, 117, 163, 21);
		ResultSet rs = hesabDao.SelectByMemberId(getMemberid());

		while (rs.next()) {
			comboBox.addItem(rs.getObject("HesabId"));
		}
		panel.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("تقاضای درخواست وام");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(216, 120, 130, 13);
		panel.add(lblNewLabel_3);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(28, 117, 178, 21);
		ResultSet rs2 = noevamDao.GetAll();

		while (rs2.next()) {
			comboBox_1.addItem(rs2.getObject("VamName"));
		}
		panel.add(comboBox_1);

		JLabel lblNewLabel_4 = new JLabel("به مبلغ (ریال)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(612, 160, 85, 13);
		panel.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(451, 158, 154, 19);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("را دارم.");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(395, 160, 51, 13);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(
				"تقاضا دارم در صورت صلاحدید، مدارک اینجانب را مورد بررسی قرار داده و دستورات لازم را  مبذول بفرمایید.  ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(76, 198, 621, 13);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("پیشاپیش از توجه شما کمال تشکر را دارم.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(447, 221, 250, 13);
		panel.add(lblNewLabel_8);

		JButton btnNewButton = new JButton("ارسال");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(390, 283, 98, 21);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					vamDao.setMemberid(getMemberid());
					vamDao.setHesabid(Long.parseLong(comboBox.getSelectedItem().toString()));
					vamDao.setNoevamid(comboBox_1.getSelectedIndex() + 5);
					vamDao.setMablaghvam(Long.parseLong(textField.getText()));

					vamDao.RequestVam();

					frame.dispose();
					JOptionPane.showMessageDialog(frame, "درخواست شما با موفقیت ثبت شد.");

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("انصراف");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(283, 283, 98, 21);
		panel.add(btnNewButton_1);
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}
}
