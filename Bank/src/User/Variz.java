package User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.HesabDao;
import Dao.TarakoneshDao;

public class Variz {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	private long memberid;
	private long hesabid;
	private long varizid;
	private long operatorid;
	private String noevariz;
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
					Variz window = new Variz();
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
	public Variz() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public Variz(long memberid) throws ClassNotFoundException, SQLException {

		this.memberid = memberid;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setTitle("واریز");
		frame.setBounds(100, 100, 800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel.setLayout(null);
		panel.setBounds(179, 163, 424, 178);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("مبلغ (ریال)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(282, 36, 67, 13);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(49, 34, 204, 19);
		panel.add(textField);

		JLabel lblNewLabel_1 = new JLabel("به شماره حساب");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(268, 65, 101, 13);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 63, 204, 19);
		panel.add(textField_1);

		JButton btnNewButton = new JButton("تایید");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					hesabid = Long.parseLong(textField_1.getText());
					if (tarakoneshDao.isPenalty(getHesabid(), getMemberid())) {

						JOptionPane.showMessageDialog(frame, "در حال حاضر درخواست قبلی شما بررسی نشده است!");
					}

					else {

						tarakoneshDao.setHesabid(Long.parseLong(textField_1.getText()));
						tarakoneshDao.setMemberid(getMemberid());
						tarakoneshDao.setMablaghtarakonesh(Long.parseLong(textField.getText()));

						tarakoneshDao.RequestVariz();
					}

				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(236, 132, 85, 21);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("انصراف");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(135, 132, 85, 21);
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

	public Long getHesabid(Long heabid) {

		return hesabid;
	}

	public void setHesabid(Long hesabid) {
		this.hesabid = hesabid;
	}

	public Long getVarizid() {
		return varizid;
	}

	public void setVarizid(Long variztid) {
		this.varizid = varizid;
	}

	public Long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Long operatorid) {
		this.operatorid = operatorid;
	}

	public String getNoeVariz() {
		return noevariz;
	}

	public void setNoeVariz(String noevariz) {
		this.noevariz = noevariz;
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
