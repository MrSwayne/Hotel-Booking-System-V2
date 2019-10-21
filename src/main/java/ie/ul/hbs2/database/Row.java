package ie.ul.hbs2.database;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Row {
	
	private Map<String,String> map;
	private List<String> columnNames;

	//Creates a row
	public Row() {

		//Mapping of column names to column results
		map = new HashMap<String,String>();

		//List of column Names

		columnNames = new LinkedList<String>();
	}
	public Iterator<String> getColNames() {
		return columnNames.iterator();
	}

	//Add column to row
	public void add(String columnName, String result) {
		if(!map.containsKey(columnName))
			columnNames.add(columnName);
		map.put(columnName, result);
	}

	//Get result from column name
	public String get(String columnName) {
		return map.get(columnName);
	}


	//Prints the row as  astring
	public String toString() {
		String line = "";
			Iterator<String> columnIterator = columnNames.iterator();
			while(columnIterator.hasNext()) 
				line += map.get(columnIterator.next()) + " ";
		return line;
	}
}
