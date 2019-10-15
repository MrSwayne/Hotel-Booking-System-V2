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
	
	public Row() {
		map = new HashMap<String,String>();
		columnNames = new LinkedList<String>();
	}
	
	public int getColsSize() {
		return columnNames.size();
	}
	
	public String getColName(int i) {
		return columnNames.get(i);
	}
	
	public void add(String columnName, String result) {
		if(!map.containsKey(columnName))
			columnNames.add(columnName);
		map.put(columnName, result);
	}
	
	public String get(String columnName) {
		return map.get(columnName);
	}
	
	public String toString() {
		String line = "";
			Iterator<String> columnIterator = columnNames.iterator();
			while(columnIterator.hasNext()) 
				line += map.get(columnIterator.next()) + " ";

		return line;
	}
}
