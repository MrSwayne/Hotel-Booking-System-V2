package ie.ul.hbs2.database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper {
	
	private Connection conn = null;
	
	private final String host = "localhost";
	private final String database = "hbs";
	private final String username = "root";
	private final String password = "";
	
	private String url = "jdbc:mysql://" + host + "/" + database + "?" + "user=" + username + "&password=" + password;
	
	
	private String uName;
	private String pWord;
	private String ip;
	
	private static DatabaseHelper instance = null;
	
	private DatabaseHelper() {
	}
	
	public static DatabaseHelper getInstance() {
		if(instance == null)
			instance = new DatabaseHelper();
		return instance;
	}
	
	private Connection conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, uName, pWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//Gets data from database and returns as a hbs.database.Query
	public synchronized Query executeQuery(String sql) {
		System.out.println("Executing " + sql);
		try(
			Connection conn = this.conn();
		) {
			Query query = new Query();
			
			if(sql.toUpperCase().startsWith("SELECT")) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet resultSet = stmt.executeQuery();
				query = resultSetToQuery(resultSet);
			}
			
			else {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			}
			
			return query;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//
		System.err.println("Nothing found");
		return null;
	}
	
	private Query resultSetToQuery(ResultSet resultSet) {
		Query query = new Query();
		ResultSetMetaData metaData;
		try {
			metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(resultSet.next()) {
				Row row = new Row();
				for(int i = 0;i < columnCount;i++) 
					row.add(metaData.getColumnName(i + 1), resultSet.getString(metaData.getColumnName(i+1)));
				query.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return query;
	}
}
