package com.company.creational.abstractFactory;
//esta clase es un tipo de pago
public class Credit implements PaymentMethod{
    @Override
    public String doPayment() {
        return "Pago a credito";
    }
}
