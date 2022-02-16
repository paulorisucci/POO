package com.mycompany.restrictPackage;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CreditCard extends GenericCard{

    private BigDecimal maximumLimit;
    private BigDecimal limit;

    public CreditCard(Account account, Long cardNumber, BigDecimal maximumLimit) {
        super(account, cardNumber);
        this.maximumLimit = new BigDecimal(String.valueOf(maximumLimit));
        this.limit = new BigDecimal(String.valueOf(maximumLimit));
        this.invoice = new Invoice(new ArrayList<>(), new BigDecimal("0"));
    }

    public void setMaximumLimit(BigDecimal maximumLimit) {
        this.maximumLimit = new BigDecimal(String.valueOf(maximumLimit));
    }

    public BigDecimal getMaximumLimit() {
        return maximumLimit;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal newLimit) {
        this.limit = new BigDecimal(String.valueOf(newLimit));;
    }

    public void debitLimit(BigDecimal value){
        if(this.limit.compareTo(value) < 0)
            throw new RuntimeException();

        this.limit = this.limit.subtract(value);
    }

    public void resetLimit() {
        this.limit = new BigDecimal(String.valueOf(this.maximumLimit));
    }

    @Override
    public Transaction doTransaction(BigDecimal money, String description){
        Transaction newTransaction = new Transaction(description, money);
        invoice.addTransaction(newTransaction);
        this.debitLimit(money);
        return newTransaction;
    }

    @Override
    public Invoice payInvoice() {
        if(this.account.getMoney().compareTo(this.invoice.getTotalPrice()) < 0)
            throw new RuntimeException("You don't have enough money");

        Invoice payedInvoice = new Invoice(this.invoice.getTransactions(), new BigDecimal(String.valueOf(this.invoice.getTotalPrice())));

        this.account.debitMoney(invoice.getTotalPrice());
        this.invoice.setTotalPrice(new BigDecimal("0"));
        this.invoice.removeAllTransactions();
        this.resetLimit();

        return payedInvoice;
    }

    @Override
    public String toString() {
        return String.format("Account: %s\n"      +
                             "Card number: %s\n"  +
                             "Invoice: %s\n"      +
                             "maximumLimit: %s\n" +
                             "limit: %s\n",
                this.account, this.cardNumber, this.invoice.getTotalPrice(), this.maximumLimit, this.limit);
    }
}