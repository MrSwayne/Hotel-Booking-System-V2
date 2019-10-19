package ie.ul.hbs2;

//import com.stripe.exception.StripeException;


import ie.ul.hbs2.payments.PaymentDispatcher;
import ie.ul.hbs2.payments.PaymentMethod;
import ie.ul.hbs2.payments.PaypalPayment;
import ie.ul.hbs2.payments.StripePayment;

public class Main {

	public static void main(String[] args) {

		//Start the application
		HotelBookingSystem application = new HotelBookingSystem();

		//register concrete interceptors
		application.addPaymentMethod(new PaypalPayment());
		application.addPaymentMethod(new StripePayment());

		application.run();
	}
}
