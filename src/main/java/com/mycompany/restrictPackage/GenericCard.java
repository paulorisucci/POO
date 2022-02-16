package com.mycompany.restrictPackage;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class GenericCard implements Card{

    protected Account account;
    protected Long cardNumber;
    protected Invoice invoice;

    public GenericCard(Account account, Long cardNumber){
        this.account = account;
        this.cardNumber = cardNumber;
        this.invoice = new Invoice(new ArrayList<>(), new BigDecimal("0"));
    }

    public Account getAccount() {
        return account;
    }

    public Long getCardNumber(){
        return this.cardNumber;
    }

    @Override
    public Transaction doTransaction(BigDecimal money, String description) {

        Transaction newTransaction = new Transaction(description, money);
        invoice.addTransaction(newTransaction);
        return newTransaction;
    }

    public Invoice payInvoice() {
        if(this.account.getMoney().compareTo(this.invoice.getTotalPrice()) < 0)
            throw new RuntimeException("You don't have enough money");

        Invoice payedInvoice = new Invoice(this.invoice.getTransactions(), new BigDecimal(String.valueOf(this.invoice.getTotalPrice())));

        this.account.debitMoney(invoice.getTotalPrice());
        this.invoice.setTotalPrice(new BigDecimal("0"));
        this.invoice.removeAllTransactions();

        return payedInvoice;
    }

    @Override
    public String toString() {
        return String.format(
                        "Account: %s\n"     +
                        "Card number: %s\n" +
                        "Invoice: %s\n",
                this.account, this.cardNumber, this.invoice.getTotalPrice());
    }
}
