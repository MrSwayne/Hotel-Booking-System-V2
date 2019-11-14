package ie.ul.hbs2.payments.interceptors;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import ie.ul.hbs2.payments.BookingCharge;
import ie.ul.hbs2.payments.IPaymentCallback;
import ie.ul.hbs2.payments.IPaymentMethod;

import javax.swing.*;

public class PaypalPayment implements IPaymentMethod {
    String CLIENT_ID;
    String SECRET_CLIENT_ID;

    private BookingCharge context;

    public PaypalPayment() {
        this.CLIENT_ID = "Ad0eT8cs3sGB-mORwb4QpazaLNVI3TnClTNVflp_U0HPeAMSMBIhAVFPC0dj5CFWeqNF4iEZF4nbMV_1";
        this.SECRET_CLIENT_ID = "EK1nFHIllpZ2b1Hm22sTITu8nrEM2OmRPJ6MsBMvBJFExUNtKQj0GOo7Bm0cbhDFuCpsltNFsIOoaix3";

    }
    @Override
    public void processPayment(final IPaymentCallback callback) {
        final APIContext APIcontext = new APIContext(this.CLIENT_ID, this.SECRET_CLIENT_ID, "sandbox");

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:3000/cancel");
        redirectUrls.setReturnUrl("http://localhost:3000/process");

        Details details = new Details();

        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setTotal("" + this.context.getCharge());

        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Receipt from Shambles Hotel Group");

        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        final Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(transactions);

        try {
            final Payment createdPayment = payment.create(APIcontext);

            Iterator links = createdPayment.getLinks().iterator();
            while (links.hasNext()) {
                Links link = (Links) links.next();
                if (link.getRel().equalsIgnoreCase("approval_url")) {

                    Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI(link.getHref());
                    desktop.browse(oURL);

                    JFrame f = new JFrame("paypal");
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {

                        }

                        @Override
                        public void windowClosing(WindowEvent e) {
                            PaymentExecution paymentExecution = new PaymentExecution();
                            paymentExecution.setPayerId("DXQLLRSHDPTCG");
                            try {
                                payment.setId(createdPayment.getId());
                                System.out.println(createdPayment.getPayer().getPayerInfo());
                                Payment createdPayment = payment.execute(APIcontext, paymentExecution);
                                System.out.println(createdPayment);
                                String orderId = createdPayment.getTransactions().get(0)
                                        .getRelatedResources().get(0).getOrder().getId();
                                callback.workDone(true);
                            } catch (PayPalRESTException ex) {
                                System.err.println(ex.getDetails());
                                callback.workDone(false);
                            }
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {

                        }

                        @Override
                        public void windowIconified(WindowEvent e) {

                        }

                        @Override
                        public void windowDeiconified(WindowEvent e) {

                        }

                        @Override
                        public void windowActivated(WindowEvent e) {

                        }

                        @Override
                        public void windowDeactivated(WindowEvent e) {

                        }
                    });

                    f.setPreferredSize(new Dimension(1280, 720));
                    f.setVisible(true);
                }
            }

        } catch (PayPalRESTException | URISyntaxException | IOException e) {
            e.printStackTrace();
            callback.workDone(false);
        }
        callback.workDone(false);
    }

    @Override
    public ImageIcon getIcon() throws IOException {
       // Image img = ImageIO.read(getClass().getResource("res/Paypal.png"));
        ImageIcon icon = new ImageIcon("res/Paypal.png");
        return icon;
    }

    @Override
    public JPanel getContentPanel(final IPaymentCallback callback) {
        JPanel panel = new JPanel();
        JButton button = new JButton("Pay With Paypal");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.doWork();
            }
        });
        panel.add(button);
        return panel;
    }


    @Override
    public void setContextObject(BookingCharge charge) {
        this.context = charge;
    }
}
