package ie.ul.hbs2.payments;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

public class StripePayment extends PaymentSystem {

	private static final String END_POINT = "https://api.stripe.com";

	public StripePayment() {
		this.API_KEY = "sk_test_CApIbp79HFiF1ExApeMB4JV500G3IBszYN";
	}

	@Override
	public boolean processPayment(BookingCharge bookingCharge)  {
		Stripe.apiKey = this.API_KEY;
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", 2000);
		chargeParams.put("currency", "eur");
		chargeParams.put("description", "Charge for jenny.rosen@example.com");
		chargeParams.put("source", "tok_visa");
		// ^ obtained with Stripe.js

		
		RequestOptions options = RequestOptions
		  .builder()
		  .setIdempotencyKey("4Fkp8YhHYw0nlzOl")
		  .build();

		try {
			Charge charge = Charge.create(chargeParams, options);
		} catch(StripeException e) {
			//TODO
		}
		return true;
	}
}
