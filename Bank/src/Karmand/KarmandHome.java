package Karmand;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Main.KarmandLoginForm;

public class KarmandHome {

	private JFrame frame;

	private SabtIjadHesab sih;
	private KarmandLoginForm klf;
	private SabtBardasht sb;
	private SabtVariz sv;
	private UserManage um;
	private HesabManage hm;
	private GardeshHesab gh;
	private DarkhastHayeVam dhv;
	private Morakhasi morkhsi;

	private long operatorid;
	private String name;
	private String family;
	private String phone;
	private String adress;
	private long mellicode;
	private String username;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KarmandHome window = new KarmandHome();
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
	public KarmandHome() {
		initialize();
	}

	public KarmandHome(ResultSet kSpecifications) throws SQLException {
		setKSpecifications(kSpecifications);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 50, 800, 500);
		panel_1.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBounds(645, 97, 129, 354);
		panel.setBackground(SystemColor.scrollbar);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 129, 0 };
		gbl_panel.rowHeights = new int[] { 35, 35, 35, 35, 35, 35, 35, 35, 0, 44, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnNewButton_5_1_2_1 = new JButton("مرخصی");
		btnNewButton_5_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					morkhsi = new Morakhasi(getOperatorid());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnNewButton_1 = new JButton("ایجاد حساب");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					sih = new SabtIjadHesab();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_3 = new JButton("ثبت برداشت");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 1;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					sb = new SabtBardasht(getOperatorid());

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_5_1_1 = new JButton("اطلاعات حساب ها");
		btnNewButton_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_5_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					hm = new HesabManage();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnNewButton_4 = new JButton("ثبت واریز");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 2;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);

		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					sv = new SabtVariz(getOperatorid());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_5 = new JButton("تراکنش ها");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 3;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);

		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					gh = new GardeshHesab(getOperatorid());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_5_1 = new JButton("درخواست های وام");
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_5_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					dhv = new DarkhastHayeVam();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_5_1 = new GridBagConstraints();
		gbc_btnNewButton_5_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5_1.gridx = 0;
		gbc_btnNewButton_5_1.gridy = 4;
		panel.add(btnNewButton_5_1, gbc_btnNewButton_5_1);
		GridBagConstraints gbc_btnNewButton_5_1_1 = new GridBagConstraints();
		gbc_btnNewButton_5_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5_1_1.gridx = 0;
		gbc_btnNewButton_5_1_1.gridy = 5;
		panel.add(btnNewButton_5_1_1, gbc_btnNewButton_5_1_1);

		JButton btnNewButton_5_1_2 = new JButton("اطلاعات کاربران");
		btnNewButton_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_5_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					um = new UserManage();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_5_1_2 = new GridBagConstraints();
		gbc_btnNewButton_5_1_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5_1_2.gridx = 0;
		gbc_btnNewButton_5_1_2.gridy = 6;
		panel.add(btnNewButton_5_1_2, gbc_btnNewButton_5_1_2);
		btnNewButton_5_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton_5_1_2_1 = new GridBagConstraints();
		gbc_btnNewButton_5_1_2_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5_1_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5_1_2_1.gridx = 0;
		gbc_btnNewButton_5_1_2_1.gridy = 7;
		panel.add(btnNewButton_5_1_2_1, gbc_btnNewButton_5_1_2_1);

		JButton btnNewButton_1_1 = new JButton("خروج");
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_1.gridx = 0;
		gbc_btnNewButton_1_1.gridy = 8;
		panel.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		btnNewButton_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				klf = new KarmandLoginForm();
				frame.dispose();
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 764, 75);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("بانکداری نوین");
		lblNewLabel.setFont(new Font("B Nazanin", Font.PLAIN, 40));
		lblNewLabel.setBounds(542, 5, 212, 62);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Data\\eclipse\\eclipse-workspace-java\\Bank\\285645-32.jpg"));
		lblNewLabel_3.setBounds(10, 34, 42, 31);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel(name + " " + family);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(51, 43, 303, 24);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Data\\eclipse\\eclipse-workspace-java\\Bank\\banking-2.jpg"));
		lblNewLabel_1.setBounds(10, 97, 625, 354);
		panel_1.add(lblNewLabel_1);

	}

	public void setKSpecifications(ResultSet kSpecifications) throws SQLException {

		while (kSpecifications.next()) {

			this.operatorid = kSpecifications.getLong("OperatorId");
			this.name = kSpecifications.getString("name");
			this.family = kSpecifications.getString("family");
			this.phone = kSpecifications.getString("phone");
			this.adress = kSpecifications.getString("adress");
			this.mellicode = kSpecifications.getLong("MelliCode");
			this.username = kSpecifications.getString("username");
			this.password = kSpecifications.getString("password");

		}
	}

	// set and gets
	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public long getMellicode() {
		return mellicode;
	}

	public void setMellicode(long mellicode) {
		this.mellicode = mellicode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
