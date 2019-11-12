package ie.ul.hbs2.GUI;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.View;
import ie.ul.hbs2.search.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SearchView extends View
{
	private javax.swing.JButton jButton_Search;
	private javax.swing.JComboBox jComboBox_Switch;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable_Users;
	private javax.swing.JTextField jText_Search;

	public SearchView(String name, Frame parent)
	{
		super(name, parent);
		initComponents();
	}

	public Connection getConnection()
	{
		String hotel = "";


		//Strategy DB switch -Hotel1Strategy, Hotel2Strategy... HotelNStrategy
		//Temporary until UI integrated for Hotel selection
		SearchStrategy searchStrategy = new Hotel1Strategy();
		hotel = searchStrategy.hotelChoice(hotel);


		Connection con = null;
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+hotel, "root", "");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return con;
	}

	public void findUsers()
	{
		ArrayList<User> users = usersList(jText_Search.getText());
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

	public void findRooms()
	{
		ArrayList<Rooms> rooms = roomsList(jText_Search.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"Gid", "firstname", "lastname", "memberSince","totalSpent","membershipLevel"});
		Object[] row = new Object[6];
		for (int i = 0; i < rooms.size(); i++)
		{
			row[0] = rooms.get(i).getRid();
			row[1] = rooms.get(i).getRnumber();
			row[2] = rooms.get(i).getType();
			row[3] = rooms.get(i).getAvailable();
			row[4] = rooms.get(i).getPrice();
			row[5] = rooms.get(i).getHid();
			model.addRow(row);
		}
		jTable_Users.setModel(model);
	}

	public void findBookings()
	{
		ArrayList<Booking> bookings = bookingsList(jText_Search.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"Bid", "DateIn", "DateOut", "Gid","Rid"});
		Object[] row = new Object[5];
		for (int i = 0; i < bookings.size(); i++)
		{
			row[0] = bookings.get(i).getBid();
			row[1] = bookings.get(i).getdateIn();
			row[2] = bookings.get(i).getdateOut();
			row[3] = bookings.get(i).getGid();
			row[4] = bookings.get(i).getRid();
			model.addRow(row);
		}
		jTable_Users.setModel(model);
	}

	public ArrayList<User> usersList(String ValToSearch)
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

	public ArrayList<Rooms> roomsList(String ValToSearch)
	{
		ArrayList<Rooms> roomsList = new ArrayList<Rooms>();

		Statement st;
		ResultSet rs;

		try
		{
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `rooms` WHERE CONCAT(`Rid`, `Rnumber`, `Type`, `available`, `Price`, `Hid`) LIKE '%" + ValToSearch + "%'";

			rs = st.executeQuery(searchQuery);

			Rooms rooms;

			while (rs.next())
			{
				rooms = new Rooms(
						rs.getInt("Rid"),
						rs.getInt("Rnumber"),
						rs.getString("Type"),
						rs.getBoolean("available"),
						rs.getInt("Price"),
						rs.getInt("Hid")
				);
				roomsList.add(rooms);
			}

		} catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return roomsList;
	}

	public ArrayList<Booking> bookingsList(String ValToSearch)
	{
		ArrayList<Booking> bookingsList = new ArrayList<>();

		Statement st;
		ResultSet rs;

		try
		{
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `bookings` WHERE CONCAT(`Bid`, `dateIn`, `dateOut`, `Gid`, `Rid`) LIKE '%" + ValToSearch + "%'";
			rs = st.executeQuery(searchQuery);

			Booking booking;

			while (rs.next())
			{
				booking = new Booking(
						rs.getInt("Bid"),
						rs.getInt("dateIn"),
						rs.getInt("dateOut"),
						rs.getInt("Gid"),
						rs.getInt("Rid")
				);
				bookingsList.add(booking);
			}
		} catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return bookingsList;
	}

	private void initComponents()
	{
		jPanel2 = new javax.swing.JPanel();

		jButton_Search = new javax.swing.JButton();
		String[] tableSwitch={"Guests","Bookings","Rooms"};
		jComboBox_Switch = new javax.swing.JComboBox<>(tableSwitch);
		jText_Search = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable_Users = new javax.swing.JTable();

		jTable_Users.setRowSelectionAllowed(true);
		jTable_Users.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		jButton_Search.setText("Search");
		jButton_Search.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_SearchActionPerformed(evt);
			}
		});

		//Default combo box to "Guests"
		jComboBox_Switch.setSelectedIndex(0);

		//Combobox Check (Guest or Booking)
		jComboBox_Switch.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent event)
			{
				JComboBox jComboBoxSwitch = (JComboBox) event.getSource();

				Object item = event.getItem();

				if(event.getItem()=="Guests")
				{
					findUsers();
				}
				else
					if (event.getItem()=="Bookings")
					{
					findBookings();
					}
					else findRooms();
			}
		});

		jText_Search.setFont(new java.awt.Font("Tahoma", 1, 18));
		jTable_Users.setFont(new java.awt.Font("Tahoma", 1, 14));

		jScrollPane1.setViewportView(jTable_Users);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addContainerGap(22, Short.MAX_VALUE)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
												.addComponent(jComboBox_Switch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(jComboBox_Switch)
												.addGap(136, 136, 136))
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
										.addComponent(jComboBox_Switch)
										.addComponent(jButton_Search)
										.addComponent(jText_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(28, 28, 28)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(41, Short.MAX_VALUE))
		);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(parent.getContentPane());
		parent.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		//parent.pack();
		this.add(jPanel2);

	}

	public void valueChanged(ListSelectionEvent e)
	{
		System.out.println("test");
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();

		int firstIndex= e.getFirstIndex();
		int lastIndex= e.getLastIndex();
		boolean isAdjusting =e.getValueIsAdjusting();

		System.out.println("event for indexs "+ firstIndex+ " - "+ isAdjusting + "; selected indexes");

		if(lsm.isSelectionEmpty())
		{
			System.out.println(" <none>");
		}else
		{
			int minIndex=lsm.getMinSelectionIndex();
			int maxIndex=lsm.getMaxSelectionIndex();

			for(int i=minIndex; i<=maxIndex; i++)
			{
				System.out.print(" "+i);
			}
		}
	}

	private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt)
	{
		if(jComboBox_Switch.getSelectedIndex()==0)
		{
			findUsers();
		}
		else
			if (jComboBox_Switch.getSelectedIndex()==1)
			{
				findBookings();
			}
			else
		if (jComboBox_Switch.getSelectedIndex()==2)
		{
			findRooms();
		}
	}
}