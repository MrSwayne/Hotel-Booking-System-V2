package Memento;

import ie.ul.hbs2.memento.CareTaker;
import ie.ul.hbs2.memento.Memento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class CareTakerTest {

    public CareTakerTest() {
    }

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
     * Test of getInstance method in class CareTaker.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance method in CareTaker");

        CareTaker expResult =CareTaker.getInstance();
        CareTaker result = CareTaker.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method in class CareTaker.
     */
    @Test
    public void testAddMethod() {
        System.out.println("add method in CareTaker");

        JPanel Test=new JPanel();
        Memento state = new Memento(Test);
        CareTaker instance = new CareTaker();
        instance.add(state);
        int n = 1;
        Memento result = instance.get(n);

        assertEquals(Test, result.getState());
    }


}
