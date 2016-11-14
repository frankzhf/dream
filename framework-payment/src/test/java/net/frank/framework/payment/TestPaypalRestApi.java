package net.frank.framework.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paypal.api.payments.Address;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentHistory;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;



public class TestPaypalRestApi {
	public static void main(String[] args)throws Exception{
		
		String clientID = "AUGCjcp78MDAX9OHvvf2GVeUfPzRl2uWyjFxJX3Kf3WDL6m9kt5qQ-9gLKXvg3fw_1U1wd2FnBAIWj9Z";
		String clientSecret = "EG084yjExtgRCkSyKuuivGqVDs8KOX-BU4yxyNvYvQ7AabGCeIOVcRFRN8wBOoB9nm8fjizEsU_mQN6P";
		String envrionment = "sandbox";
		
		APIContext context = new APIContext(clientID, clientSecret, envrionment);
		getAuthorizationID(context);
		
		//System.out.println(authorizationId);
		
	}
	
	private static  void getAuthorizationID(APIContext apiContext)
			throws PayPalRESTException {
		Address billingAddress = new Address();
		billingAddress.setCity("Johnstown");
		billingAddress.setCountryCode("US");
		billingAddress.setLine1("52 N Main ST");
		billingAddress.setPostalCode("43210");
		billingAddress.setState("OH");

		// ###CreditCard
		// A resource representing a credit card that can be
		// used to fund a payment.
		CreditCard creditCard = new CreditCard();
		creditCard.setBillingAddress(billingAddress);
		creditCard.setCvv2(012);
		creditCard.setExpireMonth(11);
		creditCard.setExpireYear(2018);
		creditCard.setFirstName("Joe");
		creditCard.setLastName("Shopper");
		creditCard.setNumber("4376867754384246");
		creditCard.setType("visa");

		// ###Details
		// Let's you specify details of a payment amount.
		Details details = new Details();
		details.setShipping("1");
		details.setSubtotal("5");
		details.setTax("1");

		// ###Amount
		// Let's you specify a payment amount.
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("7");
		amount.setDetails(details);

		// ###Transaction
		// A transaction defines the contract of a
		// payment - what is the payment for and who
		// is fulfilling it. Transaction is created with
		// a `Payee` and `Amount` types
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction
				.setDescription("This is the payment transaction description.");

		// The Payment creation API requires a list of
		// Transaction; add the created `Transaction`
		// to a List
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// ###FundingInstrument
		// A resource representing a Payeer's funding instrument.
		// Use a Payer ID (A unique identifier of the payer generated
		// and provided by the facilitator. This is required when
		// creating or using a tokenized funding instrument)
		// and the `CreditCardDetails`
		FundingInstrument fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(creditCard);

		// The Payment creation API requires a list of
		// FundingInstrument; add the created `FundingInstrument`
		// to a List
		List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
		fundingInstrumentList.add(fundingInstrument);

		// ###Payer
		// A resource representing a Payer that funds a payment
		// Use the List of `FundingInstrument` and the Payment Method
		// as 'credit_card'
		Payer payer = new Payer();
		payer.setFundingInstruments(fundingInstrumentList);
		payer.setPaymentMethod("credit_card");

		// ###Payment
		// A Payment Resource; create one using
		// the above types and intent as 'sale'
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		Payment createdPayment = null;
		try {
			// ### Api Context
			// Pass in a `ApiContext` object to authenticate
			// the call and to send a unique request id
			// (that ensures idempotency). The SDK generates
			// a request id if you do not pass one explicitly.
			//APIContext apiContext = new APIContext(clientID, clientSecret, mode);

			// Create a payment by posting to the APIService
			// using a valid AccessToken
			// The return object contains the status;
			createdPayment = payment.create(apiContext);

			System.out.println("Created payment with id = " + createdPayment.getId()
					+ " and status = " + createdPayment.getState());
			
			Map<String, String> containerMap = new HashMap<String, String>();
			containerMap.put("count", "10");
	

			// ### Api Context
			// Pass in a `ApiContext` object to authenticate
			// the call and to send a unique request id
			// (that ensures idempotency). The SDK generates
			// a request id if you do not pass one explicitly.

			// ###Retrieve
			// Retrieve the PaymentHistory object by calling the
			// static `get` method
			// on the Payment class, and pass the
			// APIContext and a ContainerMap object that contains
			// query parameters for paginations and filtering.
			// Refer the API documentation
			// for valid values for keys
			PaymentHistory paymentHistory = Payment.list(apiContext,
					containerMap);
			System.out.println("Payment History = " + paymentHistory.toString());
			
			
		} catch (PayPalRESTException e) {
			
		}
	}
}
