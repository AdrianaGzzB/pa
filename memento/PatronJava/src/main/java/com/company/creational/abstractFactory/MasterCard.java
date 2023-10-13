package com.company.creational.abstractFactory;

import java.security.cert.CRL;

public class MasterCard implements Card {
    public String getCardType(){
        return "MASTERCARD";
    };
    public String getCardNumber(){
        return "0000 1111 MAST CARD";
    }
}

