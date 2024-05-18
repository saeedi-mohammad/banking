package User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

public class Bardasht {

	private JFrame frame;
	private JTextField textField;

	private long memberid;
	private long hesabid;
	private long bardashtid;
	private long operatorid;
	private String noebardasht;
	private long mablag;
	private int isSet;
	private Date tarikh;

	HesabDao hesabDao = new HesabDao();
	TarakoneshDao tarakoneshDao = new TarakoneshDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bardasht window = new Bardasht();
					window.frame.setVisible(true);
				}

				catch (Exception e) {
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
	public Bardasht() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public Bardasht(long memberid) throws ClassNotFoundException, SQLException {

		this.memberid = memberid;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setTitle("برداشت");
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
		panel.setBounds(170, 160, 424, 186);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("مبلغ (ریال)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(289, 36, 65, 13);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(49, 34, 204, 19);
		panel.add(textField);

		JLabel lblNewLabel_1 = new JLabel("حساب");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(309, 65, 45, 13);
		panel.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(49, 62, 202, 21);
		ResultSet rs = hesabDao.SelectByMemberId(getMemberid());

		while (rs.next()) {
			comboBox.addItem(rs.getObject("HesabId"));
		}
		panel.add(comboBox);

		JButton btnNewButton = new JButton("تایید");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(222, 121, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					if (tarakoneshDao.isPenalty(Long.parseLong(comboBox.getSelectedItem().toString()), getMemberid())) {

						JOptionPane.showMessageDialog(frame, "در حال حاضر درخواست قبلی شما بررسی نشده است!");
					}

					else {
						long a = hesabDao.getMojudi(Long.parseLong(comboBox.getSelectedItem().toString()));
						System.out.println(a);

						if (a >= Long.parseLong(textField.getText())) {

							tarakoneshDao.setHesabid(Long.parseLong(comboBox.getSelectedItem().toString()));
							tarakoneshDao.setMemberid(getMemberid());
							tarakoneshDao.setMablaghtarakonesh(Long.parseLong(textField.getText()));

							tarakoneshDao.RequestBardasht();

						}

						else {

							JOptionPane.showMessageDialog(frame, "موجودی کافی نمیباشد");
						}
					}
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
		btnNewButton_1.setBounds(127, 121, 85, 21);
		panel.add(btnNewButton_1);

	}

	// set and gets

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getHesabid() {
		return hesabid;
	}

	public void setHesabid(Long hesabid) {
		this.hesabid = hesabid;
	}

	public Long getBardashtid() {
		return bardashtid;
	}

	public void setBardashtid(Long bardashtid) {
		this.bardashtid = bardashtid;
	}

	public Long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Long operatorid) {
		this.operatorid = operatorid;
	}

	public String getNoebardasht() {
		return noebardasht;
	}

	public void setNoebardasht(String noebardasht) {
		this.noebardasht = noebardasht;
	}

	public Long getMablag() {
		return mablag;
	}

	public void setMablag(Long mablag) {
		this.mablag = mablag;
	}

	public int getIsSet() {
		return isSet;
	}

	public void setIsSet(int isSet) {
		this.isSet = isSet;
	}

	public Date getTarikh() {
		return tarikh;
	}

	public void setTarikh(Date tarikh) {
		this.tarikh = tarikh;
	}

}
