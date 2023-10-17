package com.company.structural.adapter;

public class Adapter implements Payment{
    Secure secureCreditCard;

    public Adapter(String type) {
        if(type.equals("black")){
            
        }
    }

    @Override
    public void pay(String type) {

    }
}
