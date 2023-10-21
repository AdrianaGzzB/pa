package com.company.structural.decorator;

public class Black implements Credit{

    @Override
    public void showCredit() {
        System.out.println("El credito es de 1.000,000");
    }
}
