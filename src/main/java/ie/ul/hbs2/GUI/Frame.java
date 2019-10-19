package ie.ul.hbs2.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;

public class Frame extends JFrame {

    HashMap<String, View> views = new HashMap<>();
    View currentView = null;

    public Frame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//setting to the center of the screen
        this.setSize(1280, 720);
        this.setVisible(true);
    }

    public void add(String name, View view) {
        name = name.toUpperCase();
        views.put(name, view);
        if(currentView == null)
            this.show(view);
    }

    public void show(String name) {
        name = name.toUpperCase();
        View view = views.get(name);
        if (view != null)
            this.show(view);
        else
            System.out.println("Invalid view: " + name);
    }

    public void show(JPanel view) {

        if (this.currentView != null) {
            this.remove(currentView);
            this.currentView.setVisible(false);
        }
        this.add(new JButton("OK"), BorderLayout.SOUTH);
        this.add(view, BorderLayout.CENTER);

        this.currentView = (View) view;
        this.currentView.setVisible(true);
        this.validate();
        this.repaint();
    }

    public void next() {
        View nextView = this.currentView.next;
        if (nextView != null)
            this.show(nextView);
        else
            System.out.println("Invalid next view");
    }

    public void previous() {
        View prevView = this.currentView.prev;
        if (prevView != null)
            this.show(prevView);
        else
            System.out.println("Invalid next view");
    }
}
