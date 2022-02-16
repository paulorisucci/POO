package com.mycompany.restrictPackage;

import java.time.LocalDate;
import java.util.Date;

public class Person {

    private String name;
    private LocalDate birthDate;
    private Address address;
    private Character gender;
    private String cpf;
    private String idNumber;

    public Person(String name, LocalDate birthDate, Address address, Character gender, String cpf, String idNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
        this.cpf = cpf;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s\n"       +
                "Birth Date: %s\n" +
                "Gender: %c\n"     +
                "CPF: %s\n"        +
                "Id Number: %s\n",
                this.name, this.birthDate.toString(),
                this.gender, this.cpf, this.idNumber
        );
    }
}
