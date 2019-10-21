package ie.ul.hbs2.database;

import java.util.ArrayList;
import java.util.Map;


//ArrayList of Rows
public class Query extends ArrayList<Row> {

	public String toString() {
		String line = "";
		for(int i = 0;i < this.size(); i++) {
			line+= this.get(i).toString() + "\n";
		}
		return line;
	}
}
