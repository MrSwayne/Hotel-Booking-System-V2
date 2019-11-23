package View;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.SearchView;
import org.junit.*;

public class SearchViewTest {
    public SearchViewTest(){}

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
    public void searchViewTest(){
        System.out.println("Testing Search View");
        Frame parent = new Frame();
        SearchView view = new SearchView("search",parent);
        parent.show(view);

        boolean test = parent.isVisible();
        assert (test);
    }
}
