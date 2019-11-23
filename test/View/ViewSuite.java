package View;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingViewTest.class,ManagementViewTest.class,SearchViewTest.class,PaymentViewTest.class})
public class ViewSuite {
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