package View;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.PaymentView;
import org.junit.*;

public class PaymentViewTest {
    public PaymentViewTest(){}

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
    public void paymentViewTest(){
        System.out.println("Testing Payment View");
        Frame parent = new Frame();
        PaymentView view = new PaymentView("payment",parent);
        parent.show(view);

        boolean test = parent.isVisible();
        assert (test);
    }
}
