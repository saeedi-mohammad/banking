package Karmand;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import Dao.HesabDao;

public class SabtIjadHesab {

	private JFrame frame;

	private KarmandHome kh;
	private SabtIjadHesab sabtijadhesab;

	HesabDao hesabDao = new HesabDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SabtIjadHesab window = new SabtIjadHesab();
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
	public SabtIjadHesab() throws ClassNotFoundException, SQLException {
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
		frame.setTitle("درخواست های ایجاد حساب");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 562);
		panel.setLayout(null);

		JLabel Slabel1 = new JLabel("شماره حساب:");
		Slabel1.setBounds(701, 448, 73, 20);
		panel.add(Slabel1);

		JLabel Slabel2 = new JLabel("کد مشتری:");
		Slabel2.setBounds(701, 503, 55, 14);
		panel.add(Slabel2);

		JLabel Slabel3 = new JLabel("نوع حساب:");
		Slabel3.setBounds(459, 451, 55, 14);
		panel.add(Slabel3);

		JLabel Slabel4 = new JLabel("تاریخ درخواست:");
		Slabel4.setBounds(459, 503, 73, 14);
		panel.add(Slabel4);

		JLabel label1 = new JLabel("");
		label1.setBackground(Color.WHITE);
		label1.setBounds(549, 451, 142, 17);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label1);

		JLabel label2 = new JLabel("");
		label2.setBackground(Color.WHITE);
		label2.setBounds(549, 503, 142, 17);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label2);

		JLabel label3 = new JLabel("");
		label3.setBackground(Color.WHITE);
		label3.setBounds(307, 451, 142, 17);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label3);

		JLabel label4 = new JLabel("");
		label4.setBackground(Color.WHITE);
		label4.setBounds(307, 503, 142, 17);
		label4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label4);

		JTable jt = new JTable();
		model = (DefaultTableModel) jt.getModel();

		model.addColumn("ردیف");
		model.addColumn("شماره حساب");
		model.addColumn("کد صاحب حساب");
		model.addColumn("نوع حساب");
		model.addColumn("تاریخ درخواست");

		ResultSet rs = hesabDao.GetAllRequesteds();

		int i = 0;
		while (rs.next())

		{
			model.addRow(new Object[0]);
			model.setValueAt(i + 1, i, 0);
			model.setValueAt(rs.getLong("HesabId"), i, 1);
			model.setValueAt(rs.getLong("MemberId"), i, 2);
			model.setValueAt(rs.getLong("NoeHesabId"), i, 3);
			model.setValueAt(rs.getDate("TarikhIjadHesab"), i, 4);

			i++;
		}

//		jt.getColumnModel().getColumn(0).setPreferredWidth(5);
//		jt.getColumnModel().getColumn(3).setPreferredWidth(100);
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		jt.setPreferredSize(new Dimension(750, 400));
		jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				int row = jt.getSelectedRow(); // select a row
				TableModel model1 = jt.getModel();
				label1.setText(model1.getValueAt(row, 1).toString());
				label2.setText(model1.getValueAt(row, 2).toString());
				label3.setText(model1.getValueAt(row, 3).toString());
				label4.setText(model1.getValueAt(row, 4).toString());
			}
		});

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(2, 5, 780, 400);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(780, 400));

		panel.add(sp);
		frame.getContentPane().add(panel);

		JButton btnNewButton = new JButton("قبول درخواست");
		btnNewButton.setBounds(10, 447, 101, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					hesabDao.SetActive(Long.parseLong(label1.getText()));
					sabtijadhesab = new SabtIjadHesab();
					frame.dispose();
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("رد درخواست");
		btnNewButton_1.setBounds(10, 481, 101, 23);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					hesabDao.Remove(Long.parseLong(label1.getText()));
					sabtijadhesab = new SabtIjadHesab();
					frame.dispose();

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
}
