package Database;

import ie.ul.hbs2.booking.BookingManager;
import org.junit.*;
import static org.junit.Assert.*;
public class DBTester {

    public DBTester(){}

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getFromDB(){
        System.out.println("Getting from DB");

        BookingManager manager = new BookingManager();
        int GID = manager.getSpecificGID("Vera", "Irwin");
        int expectedResult = 1;

        assertEquals(expectedResult,GID);
    }
}
