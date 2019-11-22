package ie.ul.hbs2.payments.interceptors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.net.RequestOptions;
import ie.ul.hbs2.booking.Booking;
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
	public void processPayment(final IPaymentCallback callback)  {
		JFrame frame = new JFrame("Stripe Payment Screen");


		Stripe.apiKey = this.API_KEY;

		//params.put("customer", )

		List<Object> requestedCapabilities = new ArrayList<Object>();
		requestedCapabilities.add("card_payments");
		requestedCapabilities.add("transfers");

		//Map<String, Object> params = new HashMap<>();
		//params.put("type", "custom");
		//params.put("country", "IE");
		//params.put("email", "test@email.ie");
		//params.put("requested_capabilities", requestedCapabilities);
	//	params.put("description", "Customer test");
	//	params.put("name", context.getCustomerName());
	//	try {
		//	Account account = Account.create(params);
		//	System.out.println(account.getId());
		//	System.out.println(account.getEmail());
		//	Customer customer = Customer.create(params);
		//	System.out.println(customer.getId());
		//	System.out.println(customer.getName());
	//	} catch (StripeException e) {
	//		e.printStackTrace();
		//}
		Map<String, Object> params = new HashMap<>();
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", "" + context.getCharge());
		chargeParams.put("currency", "eur");
		chargeParams.put("description", "Charge for " + context.getCustomerName());
		chargeParams.put("source", "tok_visa");
		// ^ obtained with Stripe.js

		
		RequestOptions options = RequestOptions
		  .builder()
		  .setIdempotencyKey(context.ID)
		  .build();

		try {
			Charge charge = Charge.create(chargeParams, options);
			callback.workDone(true);
		} catch(StripeException e) {
			e.printStackTrace();
			callback.workDone(false);
		}
	}

	@Override
	public ImageIcon getIcon() throws IOException {
		ImageIcon icon = new ImageIcon("res/Stripe.png");
		return icon;
	}


	@Override
	public void setContextObject(BookingCharge charge) {
		this.context = charge;
	}
}
