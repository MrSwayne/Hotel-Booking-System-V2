package ie.ul.hbs2.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SearchTest extends javax.swing.JFrame
{
	private javax.swing.JButton jButton_Search;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable_Users;
	private javax.swing.JTextField jText_Search;

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(SearchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(SearchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(SearchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(SearchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new SearchTest().setVisible(true);
			}
		});
	}

	public SearchTest()
	{
		initComponents();
		findUsers();
	}

	public Connection getConnection()
	{
		Connection con = null;
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/hbs", "root", "");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return con;
	}

	public ArrayList<User> ListUsers(String ValToSearch)
	{
		ArrayList<User> usersList = new ArrayList<User>();

		Statement st;
		ResultSet rs;

		try
		{
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `guests` WHERE CONCAT(`Gid`, `firstname`, `lastname`, `memberSince`, `totalSpent`, `membershipLevel`) LIKE '%" + ValToSearch + "%'";
			rs = st.executeQuery(searchQuery);

			User user;

			while (rs.next())
			{
				user = new User(
						rs.getInt("Gid"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getInt("memberSince"),
						rs.getInt("totalSpent"),
						rs.getInt("membershipLevel")
				);
				usersList.add(user);
			}

		} catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return usersList;
	}

	public void findUsers()
	{
		ArrayList<User> users = ListUsers(jText_Search.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"Gid", "firstname", "lastname", "memberSince","totalSpent","membershipLevel"});
		Object[] row = new Object[6];
		for (int i = 0; i < users.size(); i++)
		{
			row[0] = users.get(i).getGid();
			row[1] = users.get(i).getfirstname();
			row[2] = users.get(i).getlastname();
			row[3] = users.get(i).getmemberSince();
			row[4] = users.get(i).gettotalSpent();
			row[5] = users.get(i).getmembershipLevel();
			model.addRow(row);
		}
		jTable_Users.setModel(model);
	}

	private void initComponents()
	{
		jPanel2 = new javax.swing.JPanel();
		jButton_Search = new javax.swing.JButton();
		jText_Search = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable_Users = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton_Search.setText("Search");
		jButton_Search.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_SearchActionPerformed(evt);
			}
		});

		jText_Search.setFont(new java.awt.Font("Tahoma", 1, 18));
		jTable_Users.setFont(new java.awt.Font("Tahoma", 1, 14));
		jTable_Users.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][]
						{
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null}
				},
				new String []
						{
						"Title 1", "Title 2", "Title 3", "Title 4","Title 5","Title 6"
				}
		));
		jScrollPane1.setViewportView(jTable_Users);
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addContainerGap(22, Short.MAX_VALUE)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
												.addComponent(jText_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(jButton_Search)
												.addGap(136, 136, 136))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(29, 29, 29))))
		);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGap(31, 31, 31)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButton_Search)
										.addComponent(jText_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(28, 28, 28)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(41, Short.MAX_VALUE))
		);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		pack();
	}

	private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt)
	{
		findUsers();
	}
}