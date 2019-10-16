package ie.ul.hbs2.payments;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
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
import com.paypal.api.payments.Links;

public class PaypalPayment extends PaymentMethod {
    String CLIENT_ID;
    String SECRET_CLIENT_ID;
    public PaypalPayment() {
        this.CLIENT_ID = "Ad0eT8cs3sGB-mORwb4QpazaLNVI3TnClTNVflp_U0HPeAMSMBIhAVFPC0dj5CFWeqNF4iEZF4nbMV_1";
        this.SECRET_CLIENT_ID = "EK1nFHIllpZ2b1Hm22sTITu8nrEM2OmRPJ6MsBMvBJFExUNtKQj0GOo7Bm0cbhDFuCpsltNFsIOoaix3";

    }
    @Override
    public boolean processPayment(BookingCharge bookingCharge) {
        APIContext context = new APIContext(this.CLIENT_ID, this.SECRET_CLIENT_ID, "sandbox");

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:3000/cancel");
        redirectUrls.setReturnUrl("http://localhost:3000/process");

        Details details = new Details();

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal("5000");

        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Receipt from Shambles Hotel Group");

        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(transactions);

        try {
            Payment createdPayment = payment.create(context);

            Iterator links = createdPayment.getLinks().iterator();
            while (links.hasNext()) {
                Links link = (Links) links.next();
                if (link.getRel().equalsIgnoreCase("approval_url")) {
                    // Redirect the customer to link.getHref()
                    System.out.println(link.getHref());

                }
            }
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }

        payment.setId("PAYID-LWS2KOY1NM13603X9286800W");
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId("YT9HXWPCYMP6J");
        try {
            Payment createdPayment = payment.execute(context, paymentExecution);
            System.out.println(createdPayment);
            String orderId = createdPayment.getTransactions().get(0)
                    .getRelatedResources().get(0).getOrder().getId();
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }

        return true;
    }
}
