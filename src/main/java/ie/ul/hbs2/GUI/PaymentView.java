package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.Booking;
import ie.ul.hbs2.payments.*;
import ie.ul.hbs2.payments.interceptors.CardPayment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

//TODO, Still waiting on Booking to be completed before I can progress on this

public class PaymentView extends View implements ActionListener, IPaymentCallback {

    private IPaymentCallback callback;
    PaymentDispatcher dispatcher = null;
    Map<JButton, IPaymentMethod> buttonMapping;
    private JPanel buttonPanel = new JPanel();
    private JPanel contentPanel = new JPanel();
    private Booking booking;
    private IPaymentMethod currentPaymentMethod = null;


    public void getDefaultDispatcher() {
        PaymentDispatcher dispatcher = new PaymentDispatcher();
        dispatcher.addPaymentMethod(new CardPayment());
        this.dispatcher = dispatcher;
    }

    public void attachDispatcher(PaymentDispatcher dispatcher) {this.dispatcher = dispatcher;}

    public PaymentView(String name, Frame parent) {
        super(name, parent);
    }


    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public void showPaymentScreen(IPaymentCallback callback, Booking booking) {
        View oldView = parent.currentView;
        this.callback = callback;
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        this.booking = booking;
        buttonMapping = new HashMap<>();
        for(IPaymentMethod paymentMethod : this.dispatcher.getMethods()) {
            JButton button = new JButton();
            try {
                Image resizedImage = getScaledImage(paymentMethod.getIcon().getImage(), 80, 40);
                button.setIcon((new ImageIcon(resizedImage)));
                button.setPreferredSize(new Dimension(80, 40));
            } catch(Exception e) {
                System.out.println(e);
                button.setText("null");
                e.printStackTrace();
            }
            buttonPanel.add(button);

            button.addActionListener(this);

            this.buttonMapping.put(button, paymentMethod);
        }
        this.setLayout(new GridLayout(2,1));
        this.add(buttonPanel,0);
        this.add(contentPanel, 1);

        parent.show(this);
    }

    @Override
    public void doWork() {
        this.currentPaymentMethod.processPayment(this);
    }

    @Override
    public void workDone(boolean successful) {
        System.out.println("Booking successful? " + successful);
        this.booking.workDone(successful);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        this.currentPaymentMethod = this.buttonMapping.get(button);
        this.currentPaymentMethod.setContextObject(new BookingCharge(this.booking));
        this.remove(contentPanel);
        contentPanel = this.currentPaymentMethod.getContentPanel(this);
        this.add(contentPanel);
        this.contentPanel.setVisible(true);
        parent.show(this);
    }
}
