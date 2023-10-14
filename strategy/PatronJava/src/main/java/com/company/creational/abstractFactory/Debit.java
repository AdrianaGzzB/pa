package com.company.creational.abstractFactory;
//esta clase es un tipo de pago
public class Debit implements PaymentMethod{
    @Override
    public String doPayment() {
        return "Pago a Debito";
    }
}
