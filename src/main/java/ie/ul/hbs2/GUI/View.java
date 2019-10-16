package ie.ul.hbs2.GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import ie.ul.hbs2.controllers.Controller;

public abstract class View extends JFrame{

    protected Controller controller;

    protected View() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//setting to the center of the screen
        this.setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public abstract void setMessage(String message);
}