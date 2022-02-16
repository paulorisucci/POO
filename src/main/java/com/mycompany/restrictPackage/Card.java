package com.mycompany.restrictPackage;

import java.math.BigDecimal;

public interface Card {
    Long getCardNumber();
    Transaction doTransaction(BigDecimal money, String description);
}