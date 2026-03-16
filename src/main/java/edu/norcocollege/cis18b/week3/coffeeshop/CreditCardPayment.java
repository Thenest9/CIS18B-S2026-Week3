package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentMethod {
    private String last4;

    public CreditCardPayment(String last4) {
        if(last4 == null || last4.length() != 4) {
            throw new IllegalArgumentException("Last 4 digits must be exactly 4 characters");
        }
        this.last4 = last4;
    }
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        return new PaymentReceipt(orderId, amount, "Credit Card(****" + last4 + ")", java.time.Instant.now());
    }
}