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
import javax.swing.SwingConstants;

import Dao.AgsatDao;
import Dao.HesabDao;
import Dao.TarakoneshDao;

public class PardakhtVam {

	private JFrame frame;

	AgsatDao agsatDao = new AgsatDao();
	HesabDao hesabDao = new HesabDao();
	TarakoneshDao tarakoneshDao = new TarakoneshDao();

	private Long memberid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PardakhtVam window = new PardakhtVam();
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
	public PardakhtVam() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public PardakhtVam(long memberid) throws ClassNotFoundException, SQLException {
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
		frame.setTitle("\u067E\u0631\u062F\u0627\u062E\u062A \u0648\u0627\u0645");
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
		panel.setBounds(79, 139, 614, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0648\u0627\u0645");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(527, 48, 25, 13);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("قسط شماره:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(217, 49, 77, 13);
		panel.add(lblNewLabel_1);

		JLabel label1 = new JLabel("");
		label1.setBounds(150, 48, 58, 18);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label1);

		JLabel lblNewLabel_3 = new JLabel("مبلغ(ریال):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(481, 104, 68, 13);
		panel.add(lblNewLabel_3);

		JLabel label2 = new JLabel("");
		label2.setBounds(377, 105, 94, 13);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label2);

		JLabel lblNewLabel_6 = new JLabel("\u067E\u0631\u062F\u0627\u062E\u062A \u0627\u0632 \u062D\u0633\u0627\u0628");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(269, 105, 98, 13);
		panel.add(lblNewLabel_6);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(423, 45, 94, 21);
		ResultSet rs = agsatDao.SelectByMemberId(getMemberid());

		while (rs.next()) {
			comboBox.addItem(rs.getObject("VamId"));
		}
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					ResultSet rs1 = agsatDao.SelectByVamId(Long.parseLong(comboBox.getSelectedItem().toString()));
					while (rs1.next()) {
						label1.setText(String.valueOf(rs1.getLong("TedadPardakhti") + 1));
						label2.setText(String.valueOf(rs1.getLong("MablaghHarGest")));
					}
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(149, 101, 110, 21);
		ResultSet rs2 = hesabDao.SelectByMemberId(getMemberid());

		while (rs2.next()) {
			comboBox_1.addItem(rs2.getObject("HesabId"));
		}
		panel.add(comboBox_1);

		JButton btn1 = new JButton("پرداخت");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn1.setBounds(345, 173, 85, 21);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				long mojudi;
				try {
					mojudi = hesabDao.getMojudi(Long.parseLong(comboBox_1.getSelectedItem().toString()));
					if (mojudi >= Long.parseLong(label2.getText())) {

						setBardasht(comboBox_1, Long.parseLong(label2.getText()));

						hesabDao.CustMojudi(Long.parseLong(comboBox_1.getSelectedItem().toString()),
								mojudi - Long.parseLong(label2.getText()));

						agsatDao.SabtGestByVamId(Long.parseLong(comboBox.getSelectedItem().toString()));

						JOptionPane.showMessageDialog(frame, "قسط " + label1.getText() + "ام با موفقیت پرداخت شد");
						frame.dispose();

					}

					else {

						JOptionPane.showMessageDialog(frame, "موجودی کافی نمیباشد");

					}

				}

				catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		panel.add(btn1);

		JButton btn2 = new JButton("انصراف");
		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn2.setBounds(250, 173, 85, 21);
		panel.add(btn2);
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public void setBardasht(JComboBox comboBox_1, long mablagh) throws ClassNotFoundException, SQLException {

		tarakoneshDao.setMemberid(getMemberid());
		tarakoneshDao.setHesabid(Long.parseLong(comboBox_1.getSelectedItem().toString()));
		tarakoneshDao.setMablaghtarakonesh(mablagh);
		tarakoneshDao.ForceBardasht();
	}
}
