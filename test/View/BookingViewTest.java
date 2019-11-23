package View;


import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.MainBookingView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.swing.*;

import static org.junit.Assert.*;
public class BookingViewTest {

    public BookingViewTest(){}

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
    public void mainbookingviewTest(){
        Frame parent = new Frame();

        System.out.println("Testing MainBooking View");
        MainBookingView view = new MainBookingView("booking",parent);
        parent.show(view);
        boolean test = parent.isVisible();
        assert (test);
    }
}
