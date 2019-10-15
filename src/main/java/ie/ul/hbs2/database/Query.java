package ie.ul.hbs2.database;

import java.util.ArrayList;
import java.util.Map;

public class Query extends ArrayList<Row> {
	
	public String toString() {
		String line = "";
		for(int i = 0;i < this.size(); i++) {
			line+= this.get(i).toString() + "\n";
		}
		return line;
	}
	
	public int getColumnSize() {
		return this.get(0).getColsSize();
	}
	
	public String getColumnName(int i) {
		return this.get(0).getColName(i);
	}
}
