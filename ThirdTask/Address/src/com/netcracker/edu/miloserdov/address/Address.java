package com.netcracker.edu.miloserdov.address;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Class of addresses, contains information about town, street and house number.
 * Contains methods to work with address data.
 */

public class Address {

    private final Person person;

    private String country = "None";
    private String region = "None";
    private String town = "None";
    private String street = "None";
    private String houseNum = "None";
    private String corpus = "None";
    private String flat = "None";

    /**
     * Constructor binds Person with Address.
     * Address only can be used in relation to Person.
     * @param person
     */

    public Address(Person person) {
        this.person = person;
    }

    public void setAddressOnlyComma(String input){
        this.clearAddress();
        String[] strArr = input.split(",");
        try {
            country = strArr[0].trim();
            region = strArr[1].trim();
            town = strArr[2].trim();
            street = strArr[3].trim();
            houseNum = strArr[4].trim();
            corpus = strArr[5].trim();
            flat = strArr[6].trim();
        }catch (ArrayIndexOutOfBoundsException e){ }
    }

    public void setAddressAnyOfSymbols(String input){
        this.clearAddress();
        StringTokenizer tokenizer = new StringTokenizer(input, ",.;");
            try{
                country = tokenizer.nextToken().trim();
                region = tokenizer.nextToken().trim();
                town = tokenizer.nextToken().trim();
                street = tokenizer.nextToken().trim();
                houseNum = tokenizer.nextToken().trim();
                corpus = tokenizer.nextToken().trim();
                flat = tokenizer.nextToken().trim();
            }catch(NoSuchElementException e){}
    }

    public void setAddress(String town, String street, String houseNum) {
        this.town = town;
        this.street = street;
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return this.street;
    }

    public void clearAddress(){
        country = "None";
        region = "None";
        town = "None";
        street = "None";
        houseNum = "None";
        corpus = "None";
        flat = "None";
    }


    public String getAddress() {
        return "Country: " + country +
                " | Region: " + region +
                " | Town: " + town +
                " | Street: " + street +
                " | House Number: " + houseNum +
                " | Corpus: " + corpus +
                " | Flat: " + flat;
    }

    /**
     * Returns Person if his address is matched with input address.
     * @param town
     * @param street
     * @param houseNum
     * @return
     */

    public Person matchByAddress(String town, String street, String houseNum) {
        if (this.town.equalsIgnoreCase(town) && this.street.equalsIgnoreCase(street)
                && this.houseNum.equalsIgnoreCase(houseNum)) {
            return this.person;
        } else {
            return null;
        }
    }

}