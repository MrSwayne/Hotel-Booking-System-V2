package ie.ul.hbs2.database;

public class SQLliteStrategy implements DbStrategy
{
    private String type = "jdbc:sqlite:";
    //private String fileLoc = "C:/sqlite/db/";
    private String fileName = "hbsBackUp.db";

    @Override
    public String connectionStrat(String url)
    {
        url = type + fileName;
        return url;
    }
}
