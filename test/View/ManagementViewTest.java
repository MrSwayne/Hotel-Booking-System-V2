package View;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.ManagementView;
import org.junit.*;

public class ManagementViewTest {

    public ManagementViewTest(){}

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
    public void managementViewTest(){
        System.out.println("Testing Management  View");
        Frame parent = new Frame();
        ManagementView view =  new ManagementView("management",parent);
        parent.show(view);

        boolean test = parent.isVisible();
        assert (test);
    }
}
