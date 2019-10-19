package ie.ul.hbs2.GUI;

import javax.swing.*;
import java.awt.*;

public class HotelSelectView extends View {

    public HotelSelectView(String name, Frame parent)
    {
        super(name, parent);
        String [] hotels = {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5","Hotel6","Hotel7","Hotel8"};
        JComboBox hotelList = new JComboBox(hotels);
        hotelList.setSelectedIndex(0);
        this.add(hotelList, BorderLayout.NORTH);
        this.add(new JButton("hsss"), BorderLayout.SOUTH);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void setMessage(String message) {

    }
}
