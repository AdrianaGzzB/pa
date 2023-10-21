package com.company.creational.abstractFactory;

public class Visa implements Card{
    public String getCardType(){
        return "VISA";
    };
    public String getCardNumber(){
        return "0000 1111 0101 VISA";
    }
}
