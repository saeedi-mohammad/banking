package Karmand;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dao.MorakhasiDao;

public class Morakhasi {

	private JFrame frame;
	private DefaultTableModel model;
	private DefaultTableCellRenderer cellRenderer;

	MorakhasiDao mDao = new MorakhasiDao();

	private Morakhasi morakhasi;

	private long operatorid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Morakhasi window = new Morakhasi();
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
	public Morakhasi() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public Morakhasi(long operatorid) throws ClassNotFoundException, SQLException {
		setOperatorid(operatorid);
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
		frame.setTitle("مرخصی");
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 562);
		panel.setLayout(null);

		JLabel lblNewLabel_5_1 = new JLabel(":");
		lblNewLabel_5_1.setBounds(144, 75, 4, 14);
		frame.getContentPane().add(lblNewLabel_5_1);

		JLabel lblNewLabel_5 = new JLabel(":");
		lblNewLabel_5.setBounds(144, 32, 4, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel = new JLabel("از تاریخ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(447, 32, 45, 13);
		frame.getContentPane().add(lblNewLabel);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(392, 30, 36, 20);
		frame.getContentPane().add(spinner);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد",
				"شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));
		comboBox.setBounds(309, 29, 79, 21);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("1400");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(272, 32, 36, 13);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("زمان");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(200, 33, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(151, 30, 39, 20);
		frame.getContentPane().add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner_2.setBounds(105, 30, 36, 20);
		frame.getContentPane().add(spinner_2);

		JLabel lblNewLabel_3 = new JLabel("تا تاریخ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(447, 75, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_4.setBounds(392, 73, 36, 20);
		frame.getContentPane().add(spinner_4);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد",
				"شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));
		comboBox_1.setBounds(309, 72, 79, 21);
		frame.getContentPane().add(comboBox_1);

		JLabel lblNewLabel_1_1 = new JLabel("1400");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(272, 76, 36, 13);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_4 = new JLabel("زمان");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(200, 76, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_5.setBounds(151, 73, 39, 20);
		frame.getContentPane().add(spinner_5);

		JSpinner spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner_6.setBounds(105, 73, 36, 20);
		frame.getContentPane().add(spinner_6);

		JButton btnNewButton_1 = new JButton("برگشت");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(203, 125, 85, 21);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton = new JButton("تایید");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(303, 125, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DateFormat timeformatter = new SimpleDateFormat("HH:mm");
				SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy/MM/dd");

				String date1 = "1400/" + (comboBox.getSelectedIndex() + 1) + "/" + (spinner.getValue().toString());
				String date2 = "1400/" + (comboBox_1.getSelectedIndex() + 1) + "/" + (spinner_4.getValue().toString());
				String time1 = (spinner_2.getValue().toString()) + ":" + (spinner_1.getValue().toString());
				String time2 = (spinner_6.getValue().toString()) + ":" + (spinner_5.getValue().toString());

				try {
					java.sql.Time timeValue1 = new java.sql.Time(timeformatter.parse(time1).getTime());
					java.sql.Time timeValue2 = new java.sql.Time(timeformatter.parse(time2).getTime());

					Date parsed1 = dateformatter.parse(date1);
					Date parsed2 = dateformatter.parse(date2);

					java.sql.Date sqldate1 = new java.sql.Date(parsed1.getTime());
					java.sql.Date sqldate2 = new java.sql.Date(parsed2.getTime());

					mDao.setOperatorid(getOperatorid());
					mDao.setStartdate(sqldate1);
					mDao.setEnddate(sqldate2);
					mDao.setStarttime(timeValue1);
					mDao.setEndtime(timeValue2);
					mDao.AddMorakhasi();

					frame.dispose();
					morakhasi = new Morakhasi(getOperatorid());

					JOptionPane.showMessageDialog(frame, "مرخصی با موفقیت ثبت شد.");

				} catch (ParseException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(btnNewButton);

		JTable jt = new JTable();
		model = (DefaultTableModel) jt.getModel();

		model.addColumn("کد مرخصی");
		model.addColumn("کد اپراتور");
		model.addColumn("تاریخ شروع");
		model.addColumn("تاریخ پایان");
		model.addColumn("زمان شروع");
		model.addColumn("زمان پایان");

		ResultSet rs = mDao.SelectAll();

		int i = 0;
		while (rs.next()) {
			model.addRow(new Object[0]);
			model.setValueAt(rs.getLong("MorakhasiId"), i, 0);
			model.setValueAt(rs.getLong("OperatorId"), i, 1);
			model.setValueAt(rs.getDate("StartDate"), i, 2);
			model.setValueAt(rs.getDate("EndDate"), i, 3);
			model.setValueAt(rs.getTime("StartTime"), i, 4);
			model.setValueAt(rs.getTime("EndTime"), i, 5);
			i++;

		}

		jt.getColumnModel().getColumn(0).setPreferredWidth(20);
		jt.getColumnModel().getColumn(1).setPreferredWidth(20);
		jt.getColumnModel().getColumn(4).setPreferredWidth(30);
		jt.getColumnModel().getColumn(5).setPreferredWidth(30);
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		jt.setPreferredSize(new Dimension(570, 400));
		jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(2, 150, 580, 400);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(580, 400));

		panel.add(sp);
		frame.getContentPane().add(panel);
	}

	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}
}
