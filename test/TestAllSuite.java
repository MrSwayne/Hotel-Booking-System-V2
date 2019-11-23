
import Booking.BookingSuite;
import Database.DatabaseSuite;
import Memento.MementoSuite;
import View.ViewSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingSuite.class, DatabaseSuite.class, ViewSuite.class, MementoSuite.class})
public class TestAllSuite {

    @BeforeClass
    public static void setUpClass() throws Exception{

    }

    @AfterClass
    public static void tearDownClass() throws Exception{

    }

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception{

    }
}