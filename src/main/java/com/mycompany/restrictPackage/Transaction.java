package com.mycompany.restrictPackage;

import java.math.BigDecimal;

public class Transaction {

    private static Long identifierCount = 0L;
    private Long identifier;
    private String description;
    private BigDecimal value;

    public Transaction(String description, BigDecimal money) {
        this.identifier = ++identifierCount;
        this.description = description;
        this.value = money;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format(
                "Identifier: %s\n"  +
                "Description: %s\n" +
                "Value: %s",
                this.identifier, this.description, this.value
        );
    }

}
