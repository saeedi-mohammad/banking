package User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Dao.HesabDao;
import Dao.UserDao;
import Main.Main;
import Main.UserLoginForm;

public class UserHome {

	private JFrame frame;
	private Main main;
	private IjadHesab ijadhesab;
	private Variz variz;
	private Bardasht bardasht;
	private Enteqal enteqal;
	private DarkhastVam darkhastvam;
	private MoshahedeHesab moshahedehesab;
	private GardeshHesab gardeshhesab;
	private PardakhtVam pardakhtvam;
	private BastanHesab bastanhesab;
	private UserLoginForm userloginform;
	private Eoperator eoperator;
	private Ruls ruls;

	private long memberidid;
	private String name;
	private String family;
	private long mellicode;
	private String adress;
	private String phone;
	private String username;
	private String password;

	HesabDao hesabDao = new HesabDao();
	UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHome window = new UserHome();
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
	public UserHome() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public UserHome(long memberid) throws ClassNotFoundException, SQLException {

		this.memberidid = memberid;
		System.out.println(this.getId());
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
		frame.setBounds(50, 50, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 50, 800, 500);
		panel_1.setBackground(new Color(204, 255, 204));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 102));
		panel_2.setBounds(0, 0, 786, 115);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("به سیستم بانکداری نوین خوش آمدید");
		lblNewLabel.setForeground(new Color(204, 255, 255));
		lblNewLabel.setBounds(386, 10, 400, 62);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 51));
		panel_3.setBounds(0, 68, 786, 47);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 10, 42, 31);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Data\\eclipse\\eclipse-workspace-java\\Bank\\285645-32.jpg"));

		JButton btnNewButton_9_1 = new JButton("قوانین");
		btnNewButton_9_1.setBounds(648, 10, 122, 31);
		btnNewButton_9_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ruls = new Ruls();
			}
		});
		panel_3.add(btnNewButton_9_1);
		btnNewButton_9_1.setForeground(new Color(204, 255, 255));
		btnNewButton_9_1.setBackground(new Color(0, 102, 102));
		btnNewButton_9_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblNewLabel_4 = new JLabel(name);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(49, 10, 215, 31);
		panel_3.add(lblNewLabel_4);

		////////////////////////////////////////////////////////////////////////////////////////////////////////

		ResultSet member = null;
		member = userDao.SelectByMemberId(getMemberid());
		while (member.next()) {

			String showuser = member.getString("name") + " " + member.getString("family");
			lblNewLabel_4.setText(showuser);

		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel_2 = new JLabel("BNovin");
		lblNewLabel_2.setFont(new Font("Blackadder ITC", Font.BOLD, 40));
		lblNewLabel_2.setBounds(10, 10, 134, 62);
		panel_2.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 51));
		panel.setBounds(649, 125, 123, 375);
		panel_1.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnNewButton = new JButton("ایجاد حساب");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ijadhesab = new IjadHesab(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setForeground(new Color(204, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("واریز وجه");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					variz = new Variz(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnNewButton_1.setForeground(new Color(204, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 102, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton("برداشت وجه");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					bardasht = new Bardasht(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setForeground(new Color(204, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 102, 102));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_3 = new JButton("انتقال وجه");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					enteqal = new Enteqal(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setForeground(new Color(204, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 102, 102));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);

		JButton btnNewButton_4 = new JButton("درخواست وام");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					darkhastvam = new DarkhastVam(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setForeground(new Color(204, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 102, 102));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 4;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);

		JButton btnNewButton_5 = new JButton("مشاهده حساب");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					moshahedehesab = new MoshahedeHesab(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setForeground(new Color(204, 255, 255));
		btnNewButton_5.setBackground(new Color(0, 102, 102));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 5;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);

		JButton btnNewButton_6 = new JButton("گردش حساب");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gardeshhesab = new GardeshHesab(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setForeground(new Color(204, 255, 255));
		btnNewButton_6.setBackground(new Color(0, 102, 102));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 6;
		panel.add(btnNewButton_6, gbc_btnNewButton_6);

		JButton btnNewButton_7 = new JButton("باز پرداخت وام");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pardakhtvam = new PardakhtVam(getId());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setForeground(new Color(204, 255, 255));
		btnNewButton_7.setBackground(new Color(0, 102, 102));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 7;
		panel.add(btnNewButton_7, gbc_btnNewButton_7);

		JButton btnNewButton_8 = new JButton("بستن حساب");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bastanhesab = new BastanHesab(getId());
					frame.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_8.setForeground(new Color(204, 255, 255));
		btnNewButton_8.setBackground(new Color(0, 102, 102));
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 8;
		panel.add(btnNewButton_8, gbc_btnNewButton_8);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 114, 648, 449);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("3d_bank_wallpaper-normal.jpg"));

		JButton btnNewButton_9 = new JButton("خروج");
		btnNewButton_9.setBounds(649, 506, 123, 31);
		panel_1.add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				userloginform = new UserLoginForm();

			}
		});
		btnNewButton_9.setForeground(new Color(204, 255, 255));
		btnNewButton_9.setBackground(new Color(0, 102, 102));
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnNewButton_9_2 = new JButton("ارتباط با اپراتور");
		btnNewButton_9_2.setBounds(10, 496, 141, 31);
		panel_1.add(btnNewButton_9_2);
		btnNewButton_9_2.setForeground(new Color(204, 255, 255));
		btnNewButton_9_2.setBackground(new Color(0, 102, 102));
		btnNewButton_9_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_9_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				eoperator = new Eoperator();
			}
		});

	}

	// set and get

	public long getId() {
		return memberidid;
	}

	public void setId(long id) {
		this.memberidid = id;
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

	public long getMellicode() {
		return mellicode;
	}

	public void setMellicode(long mellicode) {
		this.mellicode = mellicode;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public long getMemberid() {
		return memberidid;
	}
}
