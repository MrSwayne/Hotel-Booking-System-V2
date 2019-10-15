package ie.ul.hbs2;

//import com.stripe.exception.StripeException;

import ie.ul.hbs2.payments.PaymentSystem;
import ie.ul.hbs2.payments.PaypalPayment;
import ie.ul.hbs2.payments.StripePayment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentSystem system = new PaypalPayment();
		system.processPayment(null);
		System.out.println("hello");
	}

}
