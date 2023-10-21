package com.company.structural.decorator;

public class SecureDecorator extends CreditDecorator{
    public SecureDecorator(Credit decoratedCredit) {
        super(decoratedCredit);
    }
    public void showCredit(){
        decoratedCredit.showCredit();
        configSecure();
    }

    private void configSecure() {
        System.out.println("La tarjeta ha sido configurada con seguridad máxima");
    }
}
