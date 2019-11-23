package Booking;

import ie.ul.hbs2.booking.Booking;
import ie.ul.hbs2.booking.BookingManager;
import org.junit.*;

import javax.swing.*;

import static org.junit.Assert.*;

public class BookingManagerTest {
    public BookingManagerTest(){}

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
    public void DateBookingManagerTest(){
        System.out.println("Checking date validation");
        String dateIn = "30/08/20";
        String dateOut = "15/09/20";
        BookingManager manager = new BookingManager();
        boolean test = manager.dateValidation(dateIn,dateOut);
        assert(test);
    }
}
