package ie.ul.hbs2.controllers;

import ie.ul.hbs2.GUI.View;
import ie.ul.hbs2.payments.PaymentDispatcher;

public class PaymentController extends Controller {

    PaymentDispatcher dispatcher = null;

    public PaymentController() {

    }

    public void attachDispatcher(PaymentDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

}
