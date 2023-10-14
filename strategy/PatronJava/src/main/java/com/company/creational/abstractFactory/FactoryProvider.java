package com.company.creational.abstractFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String chooseFactory){
        if ("Card".equals(chooseFactory)){
            return new CardFactory();
        } else if ("PaymentMethod".equals(chooseFactory)){
            return new PaymentMethodFactory();
        }
        return null;
    }
}
