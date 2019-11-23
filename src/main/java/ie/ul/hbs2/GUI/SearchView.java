package ie.ul.hbs2.GUI;

import ie.ul.hbs2.common.DoNothingCommand;
import ie.ul.hbs2.common.NextCommand;
import ie.ul.hbs2.database.DatabaseHelper;
import ie.ul.hbs2.memento.CareTaker;
import ie.ul.hbs2.memento.Memento;
import ie.ul.hbs2.search.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class SearchView extends View
{
	private javax.swing.JButton jButton_Search;
	private javax.swing.JButton jButton_Clear;
	private javax.swing.JButton jButton_Managment;
	private CommandJButton jButton_Next;
	private javax.swing.JComboBox jComboBox_Switch;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel j1;
	private javax.swing.JPanel j2;
	private javax.swing.JPanel j3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable_Users;
	private javax.swing.JTextField jText_Search;

	protected static ArrayList<Object[]> selectedData = new ArrayList<Object[]>();;
	private JPanel panel1;


	public SearchView(String name, Frame parent)
	{
		super(name, parent);
		initComponents();
	}

	//The following 3 methods all focus on taking a query, and translating it to an Arraylist, which can in turn be translated to readable english for the user
	public ArrayList<User> usersList(String ValToSearch)
	{
		ArrayList<User> usersList = new ArrayList<User>();

		Statement st;
		ResultSet rs;

		try
		{
			Connection con = DatabaseHelper.getInstance().conn();
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
			Connection con = DatabaseHelper.getInstance().conn();
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
			Connection con = DatabaseHelper.getInstance().conn();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `bookings` WHERE CONCAT(`Bid`, `dateIn`, `dateOut`, `Gid`) LIKE '%" + ValToSearch + "%'";
			rs = st.executeQuery(searchQuery);

			Booking booking;

			while (rs.next())
			{
				booking = new Booking(
						rs.getInt("Bid"),
						rs.getInt("dateIn"),
						rs.getInt("dateOut"),
						rs.getInt("Gid")
				);
				bookingsList.add(booking);
			}
		} catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return bookingsList;
	}

	//The following 3 methods translate the Arraylist into a JTable for easy reading
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
		model.setColumnIdentifiers(new Object[]{"Rid", "Rnumber", "Type", "Available","Price","Hid"});
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
		model.setColumnIdentifiers(new Object[]{"Bid", "DateIn", "DateOut", "Gid"});
		Object[] row = new Object[4];
		for (int i = 0; i < bookings.size(); i++)
		{
			row[0] = bookings.get(i).getBid();
			row[1] = bookings.get(i).getdateIn();
			row[2] = bookings.get(i).getdateOut();
			row[3] = bookings.get(i).getGid();
			model.addRow(row);
		}
		jTable_Users.setModel(model);
	}

	private void initComponents()
	{
		//UI component declaration
		jPanel2 = new javax.swing.JPanel(new BorderLayout());
		jButton_Search = new javax.swing.JButton();
		jButton_Clear = new javax.swing.JButton();
		jButton_Next =  new CommandJButton(new DoNothingCommand());
		String[] tableSwitch={"Guests","Bookings","Rooms"};
		jComboBox_Switch = new javax.swing.JComboBox<>(tableSwitch);
		jText_Search = new javax.swing.JTextField();
		jText_Search.setColumns(30);
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable_Users = new javax.swing.JTable();
		jButton_Managment = new javax.swing.JButton();

		//Jtable allowance of multi selection of rows
		jTable_Users.setRowSelectionAllowed(true);
		jTable_Users.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		jButton_Clear.setText("Clear");
		jButton_Next.setText("Next");
		jButton_Search.setText("Search");
		jButton_Managment.setText("Management");

		jScrollPane1.setViewportView(jTable_Users);

		j1 = new JPanel();
			j1.add(jComboBox_Switch);
			j1.add(jText_Search);
			j1.add(jButton_Search);
			j1.add(jButton_Clear);
		j2 = new JPanel();
			j2.add(jScrollPane1);
		j3 = new JPanel();
			j3.add(jButton_Next);
			j3.add(jButton_Managment);

		jPanel2.add(j1, BorderLayout.NORTH);
		jPanel2.add(j2, BorderLayout.CENTER);
		jPanel2.add(j3, BorderLayout.SOUTH);

		//Default combo box to "Guests"
		jComboBox_Switch.setSelectedIndex(0);

		this.add(jPanel2);

		//For updating JTable on what to display
		jButton_Search.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_SearchActionPerformed(evt);
			}
		});

		//Wipes the Arraylist if something mistakenly selected.
		jButton_Clear.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				selectedData.clear();
			}
		});

		//Combobox Check (Guest or Booking)
		jComboBox_Switch.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent event)
			{
				jComboBox_Switch = (JComboBox) event.getSource();

				Object item = event.getItem();

				if(item=="Guests")
				{
					findUsers();
				}
				else
					if (item=="Bookings")
					{
					findBookings();
					}
					else
						if(item=="Rooms")
						{
							findRooms();
						}
			}
		});

		jButton_Next.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CareTaker.getInstance().add(new Memento(jPanel2));
				jButton_Next.setCommand(new NextCommand(selectedData,parent));
				jButton_Next.execute();
			}
		});

		jText_Search.setFont(new java.awt.Font("Tahoma", 1, 18));
		jTable_Users.setFont(new java.awt.Font("Tahoma", 1, 14));

		//Takes the Row selected, adding the data to an array, which is then passed to an array list to handle multiple selections at once
		jTable_Users.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{

				int selection = jTable_Users.getSelectedRow();
				Object[] rowData = new Object[jTable_Users.getColumnCount()];

				for (int i = 0; i < jTable_Users.getColumnCount(); i++)
				{
					rowData[i] = jTable_Users.getValueAt(selection, i);
				}
				selectedData.add(rowData);

					System.out.println(Arrays.deepToString(selectedData.toArray()));
			}
		});
	}

	//Sets the table to what is selected from combo box
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