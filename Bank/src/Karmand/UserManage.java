package Karmand;

import java.awt.Dimension;
import java.awt.EventQueue;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clender.DateConverter;
import Clender.JalaliDate;
import Dao.UserDao;

public class UserManage {

	private JFrame frame;

	private KarmandHome kh;

	DateConverter dateconverter = new DateConverter();

	UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManage window = new UserManage();
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
	public UserManage() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private DefaultTableModel model;
	private DefaultTableCellRenderer cellRenderer;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField7;
	private JTextField textField6;

	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("مدیریت مشتریان");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 980, 562);
		panel.setLayout(null);

		/////////////////

		JLabel Slabel1 = new JLabel("نام:");
		Slabel1.setBounds(850, 430, 73, 14);
		panel.add(Slabel1);

		JLabel Slabel2 = new JLabel("نام خوانوادگی:");
		Slabel2.setBounds(850, 478, 73, 14);
		panel.add(Slabel2);

		JLabel Slabel3 = new JLabel("نام کاربری:");
		Slabel3.setBounds(623, 430, 73, 14);
		panel.add(Slabel3);

		JLabel Slabel4 = new JLabel("تلفن همراه:");
		Slabel4.setBounds(623, 478, 62, 14);
		panel.add(Slabel4);

		JLabel Slabel5 = new JLabel("کد ملی:");
		Slabel5.setBounds(428, 430, 45, 14);
		panel.add(Slabel5);

		JLabel Slabel6 = new JLabel("تاریخ تولد:");
		Slabel6.setBounds(428, 478, 62, 14);
		panel.add(Slabel6);

		JLabel Slabel7 = new JLabel("آدرس:");
		Slabel7.setBounds(850, 519, 73, 14);
		panel.add(Slabel7);

		JLabel Slabel8 = new JLabel("کد مشتری:");
		Slabel8.setBounds(402, 519, 55, 14);
		panel.add(Slabel8);

		///
		JLabel label1 = new JLabel("");
		label1.setBounds(318, 519, 79, 14);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label1);
		///

		////////////////

		textField1 = new JTextField();
		textField1.setBounds(754, 427, 86, 20);
		textField1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(733, 475, 107, 20);
		textField2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(527, 427, 86, 20);
		textField3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField3);
		textField3.setColumns(10);

		textField4 = new JTextField();
		textField4.setBounds(527, 475, 86, 20);
		textField4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField4);
		textField4.setColumns(10);

		textField5 = new JTextField();
		textField5.setBounds(332, 427, 86, 20);
		textField5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField5);
		textField5.setColumns(10);

		textField6 = new JTextField();
		textField6.setBounds(332, 475, 86, 20);
		textField6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField6);
		textField6.setColumns(10);

		textField7 = new JTextField();
		textField7.setBounds(467, 516, 373, 20);
		textField7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField7);
		textField7.setColumns(10);

		JTable jt = new JTable();
		model = (DefaultTableModel) jt.getModel();

		model.addColumn("کد مشتری");
		model.addColumn("نام");
		model.addColumn("نام خانوادگی");
		model.addColumn("نام کاربری");
		model.addColumn("تلفن همراه");
		model.addColumn("کد ملی");
		model.addColumn("تاریخ تولد");
		model.addColumn("آدرس");

		ResultSet rs = userDao.SelectAll();

		int i = 0;
		while (rs.next()) {
			model.addRow(new Object[0]);
			model.setValueAt(rs.getLong("MemberId"), i, 0);
			model.setValueAt(rs.getString("name"), i, 1);
			model.setValueAt(rs.getString("family"), i, 2);
			model.setValueAt(rs.getString("username"), i, 3);
			model.setValueAt(rs.getString("phone"), i, 4);
			model.setValueAt(rs.getLong("MelliCode"), i, 5);
			model.setValueAt(rs.getDate("birthdate"), i, 6);
			model.setValueAt(rs.getString("adress"), i, 7);
			i++;

		}

		jt.getColumnModel().getColumn(0).setPreferredWidth(5);
		jt.getColumnModel().getColumn(1).setPreferredWidth(50);
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		jt.setPreferredSize(new Dimension(950, 400));
		jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				int row = jt.getSelectedRow(); // select a row
				TableModel model1 = jt.getModel();

				label1.setText(model.getValueAt(row, 0).toString());
				if (model1.getValueAt(row, 1) != null)
					textField1.setText(model1.getValueAt(row, 1).toString());
				if (model1.getValueAt(row, 2) != null)
					textField2.setText(model1.getValueAt(row, 2).toString());
				if (model1.getValueAt(row, 3) != null)
					textField3.setText(model1.getValueAt(row, 3).toString());
				if (model1.getValueAt(row, 4) != null)
					textField4.setText(model1.getValueAt(row, 4).toString());
				if (model1.getValueAt(row, 5) != null)
					textField5.setText(model1.getValueAt(row, 5).toString());
				if (model1.getValueAt(row, 6) != null)
					textField6.setText(model1.getValueAt(row, 6).toString());
				if (model1.getValueAt(row, 7) != null)
					textField7.setText(model1.getValueAt(row, 7).toString());
			}
		});

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(2, 5, 980, 400);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(980, 400));

		panel.add(sp);
		frame.getContentPane().add(panel);

		JButton btnNewButton_1 = new JButton("حذف");
		btnNewButton_1.setBounds(10, 481, 101, 23);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					userDao.Remove(Long.parseLong(label1.getText()));
					frame.invalidate();
					frame.validate();
					frame.repaint();

				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("برگشت");
		btnNewButton_2.setBounds(10, 515, 101, 23);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		panel.add(btnNewButton_2);

	}

	public JalaliDate miladitojalali(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;

		System.out.println(year + "  " + month + "  " + day);

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
}
