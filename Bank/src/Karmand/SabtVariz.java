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
import Dao.TarakoneshDao;

public class SabtVariz {

	private JFrame frame;

	private long varizid;
	private long memberid;
	private Date tarikh;
	private long operatorid;
	private long hesabid;
	private long mablaghvariz;

	private KarmandHome kh;
	private OtherVariz ov;
	private SabtVariz sabtvariz;

	TarakoneshDao tarakoneshDao = new TarakoneshDao();
	HesabDao hesabDao = new HesabDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SabtVariz window = new SabtVariz();
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
	public SabtVariz() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public SabtVariz(long operatorid) throws ClassNotFoundException, SQLException {

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
		frame.setTitle("درخواست های واریز");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 562);
		panel.setLayout(null);

		JLabel Slabel1 = new JLabel("به شماره حساب:");
		Slabel1.setBounds(701, 429, 73, 20);
		panel.add(Slabel1);

		JLabel Slabel2 = new JLabel("تاریخ درخواست:");
		Slabel2.setBounds(701, 467, 73, 14);
		panel.add(Slabel2);

		JLabel Slabel3 = new JLabel("کد واریز:");
		Slabel3.setBounds(701, 503, 81, 14);
		panel.add(Slabel3);

		JLabel Slabel4 = new JLabel("کد صاحب حساب:");
		Slabel4.setBounds(421, 432, 91, 14);
		panel.add(Slabel4);

		JLabel Slabel5 = new JLabel("مبلغ واریز:");
		Slabel5.setBounds(421, 467, 91, 14);
		panel.add(Slabel5);

		JLabel label1 = new JLabel("");
		label1.setBackground(Color.WHITE);
		label1.setBounds(549, 432, 142, 17);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label1);

		JLabel label2 = new JLabel("");
		label2.setBackground(Color.WHITE);
		label2.setBounds(549, 467, 142, 17);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label2);

		JLabel label3 = new JLabel("");
		label3.setBackground(Color.WHITE);
		label3.setBounds(549, 503, 142, 17);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label3);

		JLabel label4 = new JLabel("");
		label4.setBackground(Color.WHITE);
		label4.setBounds(269, 432, 142, 17);
		label4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label4);

		JLabel label5 = new JLabel("");
		label5.setBackground(Color.WHITE);
		label5.setBounds(269, 467, 142, 17);
		label5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label5);

		JTable jt = new JTable();
		model = (DefaultTableModel) jt.getModel();

		model.addColumn("ردیف");
		model.addColumn("به شماره حساب");
		model.addColumn("تاریخ درخواست");
		model.addColumn("کد واریز");
		model.addColumn("کد صاحب حساب");
		model.addColumn("مبلغ واریز");

		ResultSet rs = tarakoneshDao.GetAllVRequesteds();

		int i = 0;
		while (rs.next())

		{
			model.addRow(new Object[0]);
			model.setValueAt(i + 1, i, 0);
			model.setValueAt(rs.getLong("HesabId"), i, 1);
			model.setValueAt(rs.getDate("TarikhDarkhast"), i, 2);
			model.setValueAt(rs.getLong("TarakoneshId"), i, 3);
			model.setValueAt(rs.getLong("MemberId"), i, 4);
			model.setValueAt(rs.getLong("MablaghTarakonesh"), i, 5);

			i++;
		}

		jt.getColumnModel().getColumn(0).setPreferredWidth(5);
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
				label5.setText(model1.getValueAt(row, 5).toString());
			}
		});

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(2, 5, 780, 400);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(780, 400));

		panel.add(sp);
		frame.getContentPane().add(panel);

		JButton btnNewButton = new JButton("ثبت واریز");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long mojudi;
				System.out.println(getOperatorid());
				try {
					mojudi = hesabDao.getMojudi(Long.parseLong(label1.getText()));

					tarakoneshDao.setOperatorid(getOperatorid());
					tarakoneshDao.setTarakoneshid(Long.parseLong(label3.getText()));
					tarakoneshDao.SetVariz();

					hesabDao.IncreaseMojudi(Long.parseLong(label1.getText()), Long.parseLong(label5.getText()));

					sabtvariz = new SabtVariz(getOperatorid());
					frame.dispose();
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnNewButton.setBounds(10, 452, 101, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("رد درخواست");
		btnNewButton_1.setBounds(10, 486, 101, 23);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					tarakoneshDao.Remove(Long.parseLong(label3.getText()));
					sabtvariz = new SabtVariz(getOperatorid());
					frame.dispose();
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("برگشت");
		btnNewButton_2.setBounds(10, 520, 101, 23);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("واریز جدید");
		btnNewButton_3.setBounds(10, 416, 101, 23);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ov = new OtherVariz(getOperatorid());
			}
		});
		panel.add(btnNewButton_3);

	}

	// set and gets
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

	public Date getTarikh() {
		return tarikh;
	}

	public void setTarikh(Date tarikh) {
		this.tarikh = tarikh;
	}

	public long getHesabid() {
		return hesabid;
	}

	public void setHesabid(long hesabid) {
		this.hesabid = hesabid;
	}

	public long getMablaghvariz() {
		return mablaghvariz;
	}

	public void setMablaghvariz(long mablaghvariz) {
		this.mablaghvariz = mablaghvariz;
	}

	public long getVarizid() {
		return varizid;
	}

	public void setVarizid(long varizid) {
		this.varizid = varizid;
	}

}
