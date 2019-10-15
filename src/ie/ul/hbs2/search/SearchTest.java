package ie.ul.hbs2.search;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import ie.ul.hbs2.database.*;
//import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class SearchTest
{

    private DatabaseHelper dbh = DatabaseHelper.getInstance();
	private JFrame frame;
	private JTable table;
	private JTextField txtSearch;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{	
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					SearchTest window = new SearchTest();
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchTest()
	{
		initialize();
			
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{						
			
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 65, 765, 472);
		frame.getContentPane().add(table);		
		
		//DB testing grounds
			dbh.executeQuery("select*from guests");
			
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//Search on Key release
		txtSearch.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				//Selection will fill in query point, e.g "Select from * where SELECTION = SEARCHED WORD  
				String selection = (String)comboBox.getSelectedItem();
				
			}
		});
		
		txtSearch.setBounds(225, 11, 550, 43);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 205, 43);
		frame.getContentPane().add(comboBox);
			//To add select points
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
			
		
	}
}