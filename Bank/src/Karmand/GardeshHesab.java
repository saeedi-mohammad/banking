package Karmand;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Clender.DateConverter;
import Clender.JalaliCalendar;
import Clender.JalaliDate;
import Dao.HesabDao;
import Dao.TarakoneshDao;

public class GardeshHesab {

	private JFrame frame;

	HesabDao hesabDao = new HesabDao();
	JalaliCalendar jalaliC = new JalaliCalendar();
	DateConverter dateconverter = new DateConverter();
	TarakoneshDao tarakoneshDao = new TarakoneshDao();

	private long operatorid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GardeshHesab window = new GardeshHesab();
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
	public GardeshHesab() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public GardeshHesab(long operatorid) throws ClassNotFoundException, SQLException {
		setOperatorid(operatorid);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private DefaultTableModel model;
	private DefaultTableCellRenderer cellRenderer;

	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setTitle("\u06AF\u0631\u062F\u0634 \u062D\u0633\u0627\u0628");
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//////////////////

		JTable jt = new JTable();
		model = (DefaultTableModel) jt.getModel();

		model.addColumn("ردیف");
		model.addColumn("کد تراکنش");
		model.addColumn("نوع تراکنش");
		model.addColumn("تاریخ تراکنش");
		model.addColumn("زمان تراکنش");
		model.addColumn("از-به شماره حساب");
		model.addColumn("مبلغ تراکنش");

		jt.getColumnModel().getColumn(0).setPreferredWidth(5);
		jt.getColumnModel().getColumn(1).setPreferredWidth(20);
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		jt.setPreferredSize(new Dimension(760, 415));
		jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) { // to detect doble click events
					JTable target = (JTable) me.getSource();
					int row = target.getSelectedRow(); // select a row
					int column = target.getSelectedColumn(); // select a column
					JOptionPane.showMessageDialog(null, jt.getValueAt(row, column)); // get the value of a row and
																						// column.
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(2, 3, 780, 420);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(780, 400));

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 140, 784, 421);
		panel1.setLayout(null);
		panel1.add(sp);
		frame.getContentPane().add(panel1);

		JLabel lblNewLabel_2 = new JLabel("1400");
		lblNewLabel_2.setBounds(299, 42, 29, 13);
		frame.getContentPane().add(lblNewLabel_2);

		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(327, 38, 79, 21);
		frame.getContentPane().add(comboBox1);
		comboBox1.setModel(new DefaultComboBoxModel(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد",
				"شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));

		JSpinner spinner1 = new JSpinner();
		spinner1.setBounds(404, 39, 36, 20);
		frame.getContentPane().add(spinner1);
		spinner1.setModel(new SpinnerNumberModel(1, 1, 31, 1));

		JLabel lblNewLabel_1 = new JLabel("یا از تاریخ");
		lblNewLabel_1.setBounds(450, 41, 59, 13);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnNewButton_1 = new JButton("انصراف");
		btnNewButton_1.setBounds(305, 89, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(btnNewButton_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("10");
		rdbtnNewRadioButton.setBounds(701, 38, 45, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("20");
		rdbtnNewRadioButton_1.setBounds(655, 38, 45, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("30");
		rdbtnNewRadioButton_2.setBounds(608, 38, 45, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		JLabel lblNewLabel_3 = new JLabel("گردش آخر");
		lblNewLabel_3.setBounds(531, 41, 71, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("تا تاریخ");
		lblNewLabel_4.setBounds(244, 42, 45, 13);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_4);

		JSpinner spinner2 = new JSpinner();
		spinner2.setBounds(190, 39, 36, 20);
		frame.getContentPane().add(spinner2);
		spinner2.setModel(new SpinnerNumberModel(1, 1, 31, 1));

		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(112, 38, 79, 21);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد",
				"شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));
		frame.getContentPane().add(comboBox2);

		JLabel lblNewLabel_2_2 = new JLabel("1400");
		lblNewLabel_2_2.setBounds(82, 42, 29, 13);
		frame.getContentPane().add(lblNewLabel_2_2);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);

		JButton btnNewButton_2 = new JButton("پاک کردن");
		btnNewButton_2.setBounds(640, 66, 79, 23);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				group.clearSelection();
			}
		});
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton = new JButton("تایید");
		btnNewButton.setBounds(413, 89, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ResultSet rs = null;

				if (rdbtnNewRadioButton.isSelected() == false && rdbtnNewRadioButton_1.isSelected() == false
						&& rdbtnNewRadioButton_2.isSelected() == false) {

					int year1 = 1400;
					int month1 = comboBox1.getSelectedIndex() + 1;
					int day1 = Integer.parseInt(spinner1.getValue().toString());

					int year2 = 1400;
					int month2 = comboBox2.getSelectedIndex() + 1;
					int day2 = Integer.parseInt(spinner2.getValue().toString());

					LocalDate ldate1 = dateconverter.jalaliToGregorian(year1, month1, day1);
					Date date1 = convertLDtoD(ldate1);

					LocalDate ldate2 = dateconverter.jalaliToGregorian(year2, month2, day2);
					Date date2 = convertLDtoD(ldate2);

					System.out.println(date1 + "   تا   " + date2);
					try {

						rs = tarakoneshDao.getAllTByTarikh(date1, date2);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				else if (rdbtnNewRadioButton.isSelected() == true) {
					try {
						rs = tarakoneshDao.getAllTByNumber(10);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (rdbtnNewRadioButton_1.isSelected() == true) {

					try {
						rs = tarakoneshDao.getAllTByNumber(20);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (rdbtnNewRadioButton_2.isSelected() == true) {

					try {
						rs = tarakoneshDao.getAllTByNumber(30);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				try {
					int i = 0;
					model.setRowCount(0);
					while (rs.next()) {
						model.addRow(new Object[0]);
						model.setValueAt(i + 1, i, 0);
						model.setValueAt(rs.getLong("TarakoneshId"), i, 1);
						model.setValueAt(rs.getString("NoeTarakonesh"), i, 2);
						model.setValueAt(miladitojalali(rs.getDate("TarikhSabt")), i, 3);
						model.setValueAt(rs.getTime("ZamanTarakonesh"), i, 4);
						model.setValueAt(rs.getLong("HesabId"), i, 5);
						model.setValueAt(rs.getLong("MablaghTarakonesh"), i, 6);

						i++;

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(btnNewButton);
	}

	public JalaliDate miladitojalali(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;

		System.out.println(year + "  " + month + "  " + day);

		dateconverter = new DateConverter();
		JalaliDate jalali = dateconverter.gregorianToJalali(year, month, day);
		return jalali;
	}

	public Date convertLDtoD(LocalDate ldate) {

		// default time zone
		ZoneId defaultZoneId = ZoneId.systemDefault();

		// local date + atStartOfDay() + default time zone + toInstant() = Date
		java.util.Date date = Date.from(ldate.atStartOfDay(defaultZoneId).toInstant());

		java.sql.Date sDate = new java.sql.Date(date.getTime());
		return sDate;
	}

	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}
}
