package com.company.structural.adapter;

public class BlackCreditCard implements Secure{
    @Override
    public void payWithSecureLevelA() {
        System.out.println("Tarjeta Black: Pagando con Seguridad ALTA nivel A");
    }

    @Override
    public void payWithSecureLevelZ() {

    }
}
