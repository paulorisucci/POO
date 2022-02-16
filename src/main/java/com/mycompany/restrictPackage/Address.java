package com.mycompany.restrictPackage;

public class Address {

    private String country;
    private String state;
    private String city;
    private String cep;
    private Integer number;
    private String complement;

    public Address(String country, String state, String city, String cep, Integer number, String complement) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.cep = cep;
        this.number = number;
        this.complement = complement;
    }

    public Address(String country, String state, String city, String cep, Integer number) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.cep = cep;
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return String.format(
                "Country: %s\n" +
                "State: %s\n"   +
                "City: %s\n"    +
                "CEP: %s\n"     +
                "Number: %s",
                this.country, this.state, this.city,
                this.cep, this.number
        );
    }
}