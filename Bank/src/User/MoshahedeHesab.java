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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Dao.AgsatDao;
import Dao.HesabDao;
import Dao.NoeHesabDao;
import Dao.NoeVamDao;
import Dao.UserDao;
import Dao.VamDao;

public class MoshahedeHesab {

	private JFrame frame;

	HesabDao hesabDao = new HesabDao();
	VamDao vamDao = new VamDao();
	UserDao userDao = new UserDao();
	AgsatDao agsatDao = new AgsatDao();
	NoeHesabDao noehesabDao = new NoeHesabDao();
	NoeVamDao noevamDao = new NoeVamDao();

	private long memberid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoshahedeHesab window = new MoshahedeHesab();
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
	public MoshahedeHesab() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public MoshahedeHesab(long memberid) throws ClassNotFoundException, SQLException {
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
		frame.setTitle("\u0645\u0634\u0627\u0647\u062F\u0647 \u062D\u0633\u0627\u0628");
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

		JInternalFrame internalFrame = new JInternalFrame("مشاهده حساب");
		internalFrame.setBounds(0, 153, 786, 205);
		frame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JLabel Slabel11 = new JLabel("نام:");
		Slabel11.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel11.setBounds(736, 10, 28, 13);
		internalFrame.getContentPane().add(Slabel11);

		JLabel label11 = new JLabel("");
		label11.setBounds(585, 11, 141, 13);
		label11.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame.getContentPane().add(label11);

		JLabel Slabel12 = new JLabel("نام خانوادگی:");
		Slabel12.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel12.setBounds(491, 10, 84, 13);
		internalFrame.getContentPane().add(Slabel12);

		JLabel label12 = new JLabel("");
		label12.setBounds(320, 11, 161, 13);
		label12.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame.getContentPane().add(label12);

		JLabel Slabel13 = new JLabel("کد ملی:");
		Slabel13.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel13.setBounds(261, 11, 55, 13);
		internalFrame.getContentPane().add(Slabel13);

		JLabel label13 = new JLabel("");
		label13.setBounds(78, 11, 173, 13);
		label13.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame.getContentPane().add(label13);

		JLabel Slabel14 = new JLabel("کد مشتری:");
		Slabel14.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel14.setBounds(691, 34, 73, 13);
		internalFrame.getContentPane().add(Slabel14);

		JLabel label14 = new JLabel("");
		label14.setBounds(562, 34, 119, 13);
		label14.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame.getContentPane().add(label14);

		JLabel Slabel15 = new JLabel("شماره حساب:");
		Slabel15.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel15.setBounds(433, 35, 84, 13);
		internalFrame.getContentPane().add(Slabel15);

		JLabel label15 = new JLabel("");
		label15.setBounds(287, 34, 136, 13);
		label15.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame.getContentPane().add(label15);

		JLabel Slabel16 = new JLabel("نوع حساب:");
		Slabel16.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel16.setBounds(691, 58, 73, 13);
		internalFrame.getContentPane().add(Slabel16);

		JLabel label16 = new JLabel("");
		label16.setBounds(545, 58, 136, 13);
		label16.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame.getContentPane().add(label16);

		JLabel Slabel17 = new JLabel(":موجودی حساب");
		Slabel17.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel17.setBounds(10, 92, 95, 13);
		internalFrame.getContentPane().add(Slabel17);

		JLabel label17 = new JLabel("");
		label17.setBounds(115, 92, 232, 13);
		internalFrame.getContentPane().add(label17);

		JLabel lblNewLabel_16 = new JLabel(
				"* درصورت مغایر بودن اطلاعات، از بخش ارتباط با اپراتور در پنل اصلی پیگیری نمایید.");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_16.setBounds(287, 142, 477, 13);
		internalFrame.getContentPane().add(lblNewLabel_16);

		JInternalFrame internalFrame_1 = new JInternalFrame("مشاهده وام");
		internalFrame_1.setBounds(0, 358, 786, 205);
		frame.getContentPane().add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);

		JLabel Slabel211 = new JLabel("کد وام:");
		Slabel211.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel211.setBounds(707, 10, 53, 13);
		internalFrame_1.getContentPane().add(Slabel211);

		JLabel label211 = new JLabel("");
		label211.setHorizontalAlignment(SwingConstants.RIGHT);
		label211.setBounds(579, 10, 118, 13);
		internalFrame_1.getContentPane().add(label211);

		JLabel Slabel212 = new JLabel("نوع وام:");
		Slabel212.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel212.setBounds(431, 10, 53, 13);
		internalFrame_1.getContentPane().add(Slabel212);

		JLabel label212 = new JLabel("");
		label212.setBounds(303, 10, 118, 13);
		label212.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label212);

		JLabel Slabel22 = new JLabel("تاریخ شروع اقساط:");
		Slabel22.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel22.setBounds(646, 33, 118, 13);
		internalFrame_1.getContentPane().add(Slabel22);

		JLabel label22 = new JLabel("");
		label22.setBounds(520, 34, 118, 13);
		label22.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label22);

		JLabel Slabel23 = new JLabel("مبلغ هر قسط (ریال):");
		Slabel23.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel23.setBounds(360, 34, 124, 13);
		internalFrame_1.getContentPane().add(Slabel23);

		JLabel label23 = new JLabel("");
		label23.setBounds(247, 34, 103, 13);
		label23.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label23);

		JLabel Slabel24 = new JLabel("تعداد کل اقساط:");
		Slabel24.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel24.setBounds(117, 34, 103, 13);
		internalFrame_1.getContentPane().add(Slabel24);

		JLabel label24 = new JLabel("");
		label24.setBounds(62, 34, 45, 13);
		label24.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label24);

		JLabel Slabel25 = new JLabel("تاریخ پایان اقساط:");
		Slabel25.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel25.setBounds(656, 56, 108, 13);
		internalFrame_1.getContentPane().add(Slabel25);

		JLabel label25 = new JLabel("");
		label25.setBounds(520, 57, 128, 13);
		label25.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label25);

		JLabel Slabel26 = new JLabel("جریمه تاخیر هر قسط:");
		Slabel26.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel26.setBounds(360, 57, 130, 13);
		internalFrame_1.getContentPane().add(Slabel26);

		JLabel label26 = new JLabel("");
		label26.setBounds(257, 56, 93, 13);
		label26.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label26);

		JLabel Slabel27 = new JLabel("جمع کل اقساط:");
		Slabel27.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel27.setBounds(117, 57, 97, 13);
		internalFrame_1.getContentPane().add(Slabel27);

		JLabel label27 = new JLabel("");
		label27.setBounds(10, 57, 97, 13);
		label27.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label27);

		JLabel Slabel28 = new JLabel("تعداد اقساط پرداخت شده:");
		Slabel28.setFont(new Font("Tahoma", Font.BOLD, 12));
		Slabel28.setBounds(605, 79, 159, 13);
		internalFrame_1.getContentPane().add(Slabel28);

		JLabel label28 = new JLabel("");
		label28.setBounds(520, 80, 75, 13);
		label28.setHorizontalAlignment(SwingConstants.RIGHT);
		internalFrame_1.getContentPane().add(label28);

		JLabel lblNewLabel = new JLabel("حساب خود را انتخاب کنید");
		lblNewLabel.setBounds(626, 125, 150, 13);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(427, 122, 189, 21);
		ResultSet rs = hesabDao.SelectByMemberId(getMemberid());

		while (rs.next()) {
			comboBox.addItem(rs.getObject("HesabId"));
		}
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResultSet hesab = null;
				ResultSet member = null;
				ResultSet vam = null;
				ResultSet agsat = null;
				ResultSet noevam = null;
				ResultSet noehesab = null;

				try {
					member = userDao.SelectByMemberId(getMemberid());
					while (member.next()) {

						label11.setText(member.getString("name"));
						label12.setText(member.getString("family"));
						label13.setText(String.valueOf(member.getString("MelliCode")));
						label14.setText(String.valueOf(member.getString("MemberId")));

					}

					hesab = hesabDao.SelectByHesabId(Long.parseLong(comboBox.getSelectedItem().toString()));
					while (hesab.next()) {

						label15.setText(String.valueOf(hesab.getLong("HesabId")));
						label17.setText(String.valueOf(hesab.getLong("MojudiHesab")));
						label16.setText(noehesabDao.getNameById(hesab.getLong("NoeHesabId")));
					}

					Boolean flag = false;
					vam = vamDao.SelectByHesabId(Long.parseLong(label15.getText()));
					while (vam.next()) {
						label211.setText(String.valueOf(vam.getLong("VamId")));
						label212.setText(noevamDao.GetNameByNoeVamId(vam.getLong("NoeVamId")));
						flag = true;

					}

					if (flag) {
						agsat = agsatDao.SelectByVamId(Long.parseLong(label211.getText()));
						while (agsat.next()) {

							label22.setText(agsat.getDate("TarikhShrueAgsat").toString());
							label23.setText(String.valueOf(agsat.getLong("MablaghHarGest")));
							label24.setText(String.valueOf(agsat.getLong("TedadKolAgsat")));
							label25.setText(agsat.getDate("TarikhPayanAgsat").toString());
							label26.setText(String.valueOf(agsat.getLong("JarimeTakhirGest")));
							label27.setText(String.valueOf(agsat.getLong("JamKolleAgsat")));
							label28.setText(String.valueOf(agsat.getLong("TedadPardakhti")));

						}
					}

				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(comboBox);

		JButton btn2 = new JButton("بازگشت");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn2.setBounds(10, 126, 109, 21);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn2);

		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}
}
