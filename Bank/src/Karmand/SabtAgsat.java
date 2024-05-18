package Karmand;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Clender.DateConverter;
import Dao.AgsatDao;
import Dao.HesabDao;
import Dao.TarakoneshDao;
import Dao.VamDao;

public class SabtAgsat {

	private JFrame frame;

	private DarkhastHayeVam dvam;

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;

	DateConverter dateconverter = new DateConverter();
	VamDao vamDao = new VamDao();
	AgsatDao agsatdao = new AgsatDao();
	HesabDao hesabDao = new HesabDao();
	TarakoneshDao tarakoneshDao = new TarakoneshDao();

	private long vamid;
	private long memberid;
	private long operatorid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SabtAgsat window = new SabtAgsat();
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
	public SabtAgsat() {
		initialize();
	}

	public SabtAgsat(long operatorid, long vamid, long memberid) {
		setVamid(vamid);
		setMemberid(memberid);
		setOperatorid(operatorid);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(93, 85, 289, 308);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("تاریخ شروع اقساط:");
		lblNewLabel.setBounds(156, 37, 89, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("مبلغ هر قسط:");
		lblNewLabel_1.setBounds(156, 71, 68, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("تعداد کل اقساط:");
		lblNewLabel_2.setBounds(156, 106, 89, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("تاریخ پایان اقساط:");
		lblNewLabel_3.setBounds(156, 141, 89, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("جریمه تاخیر هر قسط:");
		lblNewLabel_4.setBounds(156, 176, 101, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("جمع کل اقساط:");
		lblNewLabel_5.setBounds(156, 211, 89, 14);
		panel.add(lblNewLabel_5);

		/////////////

		textField1 = new JTextField();
		textField1.setBounds(60, 34, 86, 20);
		panel.add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(60, 68, 86, 20);
		panel.add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(60, 103, 86, 20);
		panel.add(textField3);
		textField3.setColumns(10);

		textField4 = new JTextField();
		textField4.setBounds(60, 138, 86, 20);
		panel.add(textField4);
		textField4.setColumns(10);

		textField5 = new JTextField();
		textField5.setBounds(60, 173, 86, 20);
		panel.add(textField5);
		textField5.setColumns(10);

		textField6 = new JTextField();
		textField6.setBounds(60, 208, 86, 20);
		panel.add(textField6);
		textField6.setColumns(10);

		/////////////////

		JButton btnNewButton = new JButton("تایید و ثبت");
		btnNewButton.setBounds(156, 261, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					agsatdao.setMemberid(getMemberid());
					agsatdao.setVamid(getVamid());
					agsatdao.setStartdate(Sjalalitomiladi(textField1.getText()));
					agsatdao.setMablaghhargest(Long.parseLong(textField2.getText()));
					agsatdao.setTedadkolagsat(Long.parseLong(textField3.getText()));
					agsatdao.setEnddate(Sjalalitomiladi(textField4.getText()));
					agsatdao.setJarimetakhirgest(Long.parseLong(textField5.getText()));
					agsatdao.setJamkolagsat(Long.parseLong(textField6.getText()));
					agsatdao.NewAgsat();

					vamDao.AcceptVam(getVamid());

					ResultSet vam = vamDao.SelectByVamId(getVamid());
					while (vam.next()) {
						hesabDao.IncreaseMojudi(vam.getLong("HesabId"), vam.getLong("MablaghVam"));
						tarakoneshDao.setMemberid(14);// 14 = bank
						tarakoneshDao.setHesabid(vam.getLong("HesabId"));
						tarakoneshDao.setMablaghtarakonesh(vam.getLong("MablaghVam"));
						tarakoneshDao.ForceVariz();

					}

					dvam = new DarkhastHayeVam(getOperatorid());
					frame.dispose();

				} catch (ParseException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("انصراف");
		btnNewButton_1.setBounds(40, 261, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);

	}

	public Date Sjalalitomiladi(String s) throws ParseException {

		java.util.Date date = new SimpleDateFormat("yyyy/MM/dd").parse(s);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;

		System.out.println(year + "  " + month + "  " + day);

		LocalDate ldate1 = dateconverter.jalaliToGregorian(year, month, day);
		Date sqldate = convertLDtoD(ldate1);

		return sqldate;

	}

	public Date convertLDtoD(LocalDate ldate) {

		// default time zone
		ZoneId defaultZoneId = ZoneId.systemDefault();

		// local date + atStartOfDay() + default time zone + toInstant() = Date
		java.util.Date date = Date.from(ldate.atStartOfDay(defaultZoneId).toInstant());

		java.sql.Date sDate = new java.sql.Date(date.getTime());
		return sDate;
	}

	public long getVamid() {
		return vamid;
	}

	public void setVamid(long vamid) {
		this.vamid = vamid;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}

}
