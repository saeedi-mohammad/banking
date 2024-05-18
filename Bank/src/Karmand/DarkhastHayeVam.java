package Karmand;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clender.DateConverter;
import Clender.JalaliCalendar;
import Clender.JalaliDate;
import Dao.VamDao;

public class DarkhastHayeVam {

	private JFrame frame;

	private KarmandHome kh;
	private SabtAgsat sa;

	JalaliCalendar jalaliC = new JalaliCalendar();
	DateConverter dateconverter = new DateConverter();

	private DarkhastHayeVam dvam;

	VamDao vamDao = new VamDao();

	private long operatorid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarkhastHayeVam window = new DarkhastHayeVam();
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
	public DarkhastHayeVam() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public DarkhastHayeVam(long operatorid) throws ClassNotFoundException, SQLException {
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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("درخواست های وام");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 562);
		panel.setLayout(null);

		///////////////////
		JLabel Slabel1 = new JLabel("کد درخواست:");
		Slabel1.setBounds(701, 429, 73, 20);
		panel.add(Slabel1);

		JLabel Slabel2 = new JLabel("کد نوع وام:");
		Slabel2.setBounds(701, 467, 73, 14);
		panel.add(Slabel2);

		JLabel Slabel3 = new JLabel("مبلغ درخواستی:");
		Slabel3.setBounds(701, 506, 81, 14);
		panel.add(Slabel3);

		JLabel Slabel4 = new JLabel("تاریخ درخواست:");
		Slabel4.setBounds(421, 432, 90, 14);
		panel.add(Slabel4);

		JLabel Slabel5 = new JLabel("کد درخواست کننده:");
		Slabel5.setBounds(421, 467, 90, 14);
		panel.add(Slabel5);

		JLabel Slabel6 = new JLabel("کد حساب:");
		Slabel6.setBounds(421, 506, 90, 14);
		panel.add(Slabel6);

		////////////////////

		JLabel label1 = new JLabel("");
		label1.setBackground(Color.WHITE);
		label1.setBounds(549, 431, 142, 17);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label1);

		JLabel label2 = new JLabel("");
		label2.setBackground(Color.WHITE);
		label2.setBounds(549, 466, 142, 17);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label2);

		JLabel label3 = new JLabel("");
		label3.setBackground(Color.WHITE);
		label3.setBounds(549, 504, 142, 17);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label3);

		JLabel label4 = new JLabel("");
		label4.setBackground(Color.WHITE);
		label4.setBounds(269, 430, 142, 17);
		label4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label4);

		JLabel label5 = new JLabel("");
		label5.setBackground(Color.WHITE);
		label5.setBounds(269, 465, 142, 17);
		label5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label5);

		JLabel label6 = new JLabel("");
		label6.setHorizontalAlignment(SwingConstants.RIGHT);
		label6.setBackground(Color.WHITE);
		label6.setBounds(269, 506, 142, 17);
		panel.add(label6);

		/////////////////////

		JTable jt = new JTable();
		model = (DefaultTableModel) jt.getModel();

		model.addColumn("ردیف");
		model.addColumn("کد درخواست");
		model.addColumn("کد نوع وام");
		model.addColumn("مبلغ درخواستی");
		model.addColumn("تاریخ درخواست");
		model.addColumn("کد درخواست کننده");
		model.addColumn("کد حساب");

		ResultSet rs = vamDao.GetAllRequesteds();

		int i = 0;
		while (rs.next())

		{
			model.addRow(new Object[0]);
			model.setValueAt(i + 1, i, 0);
			model.setValueAt(rs.getLong("VamId"), i, 1);
			model.setValueAt(rs.getLong("NoeVamId"), i, 2);
			model.setValueAt(rs.getLong("MablaghVam"), i, 3);
			model.setValueAt(miladitojalali(rs.getDate("TarikhDarkhast")), i, 4);
			model.setValueAt(rs.getLong("MemberId"), i, 5);
			model.setValueAt(rs.getLong("HesabId"), i, 6);

			i++;
		}

		jt.getColumnModel().getColumn(0).setPreferredWidth(10);
		jt.getColumnModel().getColumn(1).setPreferredWidth(15);
//		jt.getColumnModel().getColumn(3).setPreferredWidth(100);
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		jt.setPreferredSize(new Dimension(750, 400));
		jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) { // to detect doble click events

					int row = jt.getSelectedRow(); // select a row
					TableModel model1 = jt.getModel();
					label1.setText(model1.getValueAt(row, 1).toString());
					label2.setText(model1.getValueAt(row, 2).toString());
					label3.setText(model1.getValueAt(row, 3).toString());
					label4.setText(model1.getValueAt(row, 4).toString());
					label5.setText(model1.getValueAt(row, 5).toString());
					label6.setText(model1.getValueAt(row, 6).toString());

				}
			}
		});

		JButton btnNewButton_2 = new JButton("برگشت");
		btnNewButton_2.setBounds(10, 515, 101, 23);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("تخصیص و ثبت شرایط اقساط");
		btnNewButton_2_1.setBounds(10, 443, 150, 23);
		btnNewButton_2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sa = new SabtAgsat(getOperatorid(), Long.parseLong(label1.getText()), Long.parseLong(label5.getText()));
				frame.dispose();
			}
		});
		panel.add(btnNewButton_2_1);

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(2, 5, 780, 400);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(780, 400));

		panel.add(sp);
		frame.getContentPane().add(panel);

		JButton btnNewButton = new JButton("رد درخواست");
		btnNewButton.setBounds(10, 481, 101, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					vamDao.RejectVam(Long.parseLong(label1.getText()));
					frame.invalidate();
					frame.validate();
					frame.repaint();

				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);

	}

	protected JalaliDate miladitojalali(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;

		System.out.println(year + "  " + month + "  " + day);

		JalaliDate jalali = dateconverter.gregorianToJalali(year, month, day);
		return jalali;
	}

	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}
}
