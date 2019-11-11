package ie.ul.hbs2.payments.interceptors;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import ie.ul.hbs2.payments.BookingCharge;
import ie.ul.hbs2.payments.IPaymentCallback;
import ie.ul.hbs2.payments.IPaymentMethod;

import javax.swing.*;

public class StripePayment implements IPaymentMethod {

	private static final String END_POINT = "https://api.stripe.com";
	private static String API_KEY;

	private BookingCharge context;

	public StripePayment() {
		this.API_KEY = "sk_test_meYhvHhybHNsxm333qeyl0GT004lhPmsV5";
	}

	@Override
	public boolean processPayment()  {
		Stripe.apiKey = this.API_KEY;
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", context.amount);
		chargeParams.put("currency", "eur");
		chargeParams.put("description", "Charge for jenny.rosen@example.com");
		chargeParams.put("source", "tok_visa");
		// ^ obtained with Stripe.js

		
		RequestOptions options = RequestOptions
		  .builder()
		  .setIdempotencyKey(context.ID)
		  .build();

		try {
			Charge charge = Charge.create(chargeParams, options);
		} catch(StripeException e) {
			//TODO
		}
		return true;
	}



	@Override
	public ImageIcon getIcon() throws IOException {
	//	Image img = ImageIO.read(getClass().getResource("res/Stripe.png"));
		ImageIcon icon = new ImageIcon("res/Stripe.png");
		return icon;
	}

	@Override
	public JPanel getContentPanel(IPaymentCallback callback) {

		JPanel panel = new JPanel();

		JLabel emailL = new JLabel("Stripe Email");
	//	JTextField

		return null;
	}

	@Override
	public JPanel getReceiptPanel() {
		return null;
	}

	@Override
	public void setContextObject(BookingCharge charge) {
		this.context = charge;
	}
}
