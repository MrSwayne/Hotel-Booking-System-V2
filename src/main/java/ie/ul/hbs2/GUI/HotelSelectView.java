package ie.ul.hbs2.GUI;

import javax.swing.*;

public class HotelSelectView extends View {

    public HotelSelectView()
    {
        this.setTitle("Hotel Select");
        String [] hotels = {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5","Hotel6","Hotel7","Hotel8"};
        JComboBox hotelList = new JComboBox(hotels);
        hotelList.setSelectedIndex(0);
    }

    @Override
    public void setMessage(String message) {

    }
}
