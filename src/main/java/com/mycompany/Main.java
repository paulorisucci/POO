package com.mycompany;

import com.mycompany.restrictPackage.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate joaoBirthDate = LocalDate.of(2000, 11, 4);
        LocalDate joaoRegistrationDate = LocalDate.of(2020, 9, 1);
        LocalDate joaoExpirationDate = LocalDate.of(2025, 9, 1);;

        Address joaoPessoa = new Address("Brasil", "Paraíba", "João Pessoa", "58035821", 30);


        Person joao = new Person("João da Silva", joaoBirthDate, joaoPessoa, 'M', "12345678912", "1234567");
        Account joaoAccount = new Account(joao, joaoRegistrationDate, joaoExpirationDate, new BigDecimal("0"), true);
        CreditCard joaosCreditCard = new CreditCard(joaoAccount, 1234567891011121L, new BigDecimal("2000"));
        joaosCreditCard.setLimit(joaosCreditCard.getMaximumLimit());

        joaoAccount.creditMoney(new BigDecimal("3000.0"));

        joaosCreditCard.doTransaction(new BigDecimal("1000.0"), "Feira");
        joaosCreditCard.doTransaction(new BigDecimal("200.0"), "Farmácia");

        joaosCreditCard.payInvoice();

        System.out.println(joao);
        System.out.println(joaoAccount);
        System.out.println(joaosCreditCard);
    }
}
