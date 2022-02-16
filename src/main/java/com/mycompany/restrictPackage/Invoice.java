package com.mycompany.restrictPackage;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Invoice {

    private ArrayList<Transaction> transactions;
    private BigDecimal totalPrice;

    public Invoice(ArrayList<Transaction> transactions, BigDecimal totalPrice) {
        this.transactions = transactions;
        this.totalPrice = totalPrice;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        this.setTotalPrice(this.totalPrice.add(transaction.getValue()));
    }

    public void removeAllTransactions(){
        this.transactions = new ArrayList<>();
    }

    public Transaction getATransaction(Long identifier) throws RuntimeException{
        Transaction requiredTransaction = this.transactions
                .stream()
                .filter(transaction1 -> transaction1.getIdentifier().equals(identifier))
                .findAny()
                .orElse(null);
        if(requiredTransaction == null){
            throw new RuntimeException("A Transaction with the given identifier doesn't exist.");
        }
        return requiredTransaction;
    }

    @Override
    public String toString() {
        return String.format(
                "Transactions: %s" +
                "Total Price: %s",
                this.transactions.size(),
                this.totalPrice
        );
    }
}
