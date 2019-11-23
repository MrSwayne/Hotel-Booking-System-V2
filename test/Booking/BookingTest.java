package Booking;

import ie.ul.hbs2.booking.Booking;
import org.junit.*;
import static org.junit.Assert.*;




public class BookingTest {
    public BookingTest(){}

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
    public void setAndGetMethodsBookingTest(){
        System.out.println("Set and Get methods testing");
        Booking book = new Booking();

        book.setBID(1);
        book.setMemLvl(2);

        int BID = 1;
        int memLvl = 2;

        int resultBID = book.getBID();
        int resultMem = book.getMemLvl();

        assertEquals(BID,resultBID);
        assertEquals(memLvl,resultMem);
    }
}
