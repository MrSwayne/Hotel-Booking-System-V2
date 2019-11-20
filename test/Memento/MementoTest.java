package Memento;

import ie.ul.hbs2.memento.Memento;
import org.junit.*;

import javax.swing.*;

import static org.junit.Assert.*;

public class MementoTest {

    public MementoTest(){}

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

    /**
     * Test to getState method in class Memento.
     */
    @Test
    public void testGetState(){
        System.out.println("getState method in Memento");
        JPanel testExpResult = new JPanel();
        Memento instance = new Memento(testExpResult);
        JPanel result = instance.getState();
        assertEquals(testExpResult, result);
    }
}
