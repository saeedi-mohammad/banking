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
import Dao.TarakoneshDao;
import Dao.UserDao;

public class Enteqal {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;

	private long memberid;

	HesabDao hesabDao = new HesabDao();
	UserDao userDao = new UserDao();

	TarakoneshDao tarakoneshDao = new TarakoneshDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enteqal window = new Enteqal();
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

	public Enteqal() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public Enteqal(long memberid) throws ClassNotFoundException, SQLException {
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
		frame.setTitle("انتقال");
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
		panel.setLayout(null);
		panel.setBounds(164, 162, 424, 198);
		frame.getContentPane().add(panel);

		JLabel Slabel1 = new JLabel("از حساب");
		Slabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel1.setBounds(289, 36, 59, 13);
		panel.add(Slabel1);

		JLabel Slabel2 = new JLabel("مبلغ (ریال)");
		Slabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel2.setBounds(280, 65, 68, 13);
		panel.add(Slabel2);

		JLabel Slabel3 = new JLabel("به حساب");
		Slabel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel3.setBounds(289, 94, 59, 13);
		panel.add(Slabel3);

		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(49, 63, 204, 19);
		panel.add(textField1);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(49, 92, 204, 19);
		panel.add(textField2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(49, 33, 204, 21);
		ResultSet rs = hesabDao.SelectByMemberId(getMemberid());

		while (rs.next()) {
			comboBox.addItem(rs.getObject("HesabId"));
		}
		panel.add(comboBox);

		JButton btnNewButton = new JButton("تایید");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(241, 138, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					long mojudi1 = hesabDao.getMojudi(Long.parseLong(comboBox.getSelectedItem().toString()));
					long mojudi2 = hesabDao.getMojudi(Long.parseLong(textField2.getText()));

					if (mojudi1 > Long.parseLong(textField1.getText())) {
						ResultSet rs = hesabDao.SelectByHesabId(Long.parseLong(textField2.getText()));

						long memberid2 = 0;
						while (rs.next()) {
							memberid2 = rs.getLong("MemberId");
						}
						String name2 = null;
						String family2 = null;
						ResultSet rs2 = userDao.SelectByMemberId(memberid2);
						while (rs2.next()) {
							name2 = rs2.getString("name");
							family2 = rs2.getString("family");
						}
						int a = JOptionPane.showConfirmDialog(null,
								"مبلغ مورد نظر به حساب  " + name2 + " " + family2 + "  واریز شود؟");
						if (a == 0) {

							setVariz();
							setBardasht(comboBox);

							hesabDao.CustMojudi(Long.parseLong(comboBox.getSelectedItem().toString()),
									mojudi1 - Long.parseLong(textField1.getText()));

							hesabDao.IncreaseMojudi(Long.parseLong(textField2.getText()),
									Long.parseLong(textField1.getText()));

							frame.dispose();
							JOptionPane.showMessageDialog(frame, "انتقال وجه با موفقیت انجام شد.");

						}

						else if (a == 2) {
							frame.dispose();
							JOptionPane.showMessageDialog(frame, "عملیات لغو شد.");
						}
					}

					else
						JOptionPane.showMessageDialog(frame, "موجودی کافی نمی باشد");

				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
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
		btnNewButton_1.setBounds(146, 138, 85, 21);
		panel.add(btnNewButton_1);

	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public void setVariz() throws ClassNotFoundException, SQLException {

		tarakoneshDao.setMemberid(getMemberid());
		tarakoneshDao.setHesabid(Long.parseLong(textField2.getText()));
		tarakoneshDao.setMablaghtarakonesh(Long.parseLong(textField1.getText()));
		tarakoneshDao.ForceVariz();

	}

	public void setBardasht(JComboBox comboBox) throws ClassNotFoundException, SQLException {

		tarakoneshDao.setMemberid(getMemberid());
		tarakoneshDao.setHesabid(Long.parseLong(comboBox.getSelectedItem().toString()));
		tarakoneshDao.setMablaghtarakonesh(Long.parseLong(textField1.getText()));
		tarakoneshDao.ForceBardasht();
	}

}
