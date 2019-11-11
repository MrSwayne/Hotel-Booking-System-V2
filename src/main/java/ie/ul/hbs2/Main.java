package ie.ul.hbs2;

//import com.stripe.exception.StripeException;


import ie.ul.hbs2.payments.interceptors.CardPayment;
import ie.ul.hbs2.payments.interceptors.PaypalPayment;
import ie.ul.hbs2.payments.interceptors.StripePayment;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		//Start the application
		HotelBookingSystem application = new HotelBookingSystem();
		//register concrete interceptors
		application.addPaymentMethod(new PaypalPayment());
		application.addPaymentMethod(new StripePayment());
		application.addPaymentMethod(new CardPayment());

		File file = new File("/../rewards/");
		System.out.println();
		application.run();
	}
}
