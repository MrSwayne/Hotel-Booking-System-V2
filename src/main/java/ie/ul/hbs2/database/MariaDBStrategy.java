package ie.ul.hbs2.database;

public class MariaDBStrategy implements DbStrategy
{
    private String type = "jdbc:mysql://";
    private String host = "localhost";
    private String database = "hbs";
    private String username = "root";
    private String password = "";
    private String url = "";
    @Override
    public String connectionStrat(String url)
    {
         url = type + host + "/" + database + "?" + "zeroDateTimeBehavior=convertToNull&" + "user=" + username + "&password=" + password;
         return url;
    }
}
