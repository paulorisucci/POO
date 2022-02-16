package com.mycompany.restrictPackage;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private Person owner;
    private LocalDate registrationDate;
    private LocalDate expirationDate;
    private BigDecimal money;
    private boolean active = false;

    public Account(Person person, LocalDate registrationDate, LocalDate expirationDate, BigDecimal money, boolean active) {
        this.owner = person;
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
        this.money = money;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive() {
        this.active = true;
    }

    public void setInactive() {
        this.active = false;
    }

    public void debitMoney(BigDecimal money){
        if(this.money.compareTo( money) < 0)
            throw new RuntimeException("there is not enought money");
        this.money = this.money.subtract(money);
    }

    public void creditMoney(BigDecimal money){
        this.money = this.money.add(money);
    }

    @Override
    public String toString() {
        return String.format(
                "Account owner: %s\n"     +
                "Account money: %s\n"     +
                "Active: %s\n"            +
                "Registration Date: %s\n" +
                "Expiration Date: %s\n",
                this.owner.getName(), this.money,
                this.active, this.registrationDate.toString(),
                this.expirationDate.toString()
        );
    }

}
