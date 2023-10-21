package com.company.structural.facade;

public class Silver implements Credit{
    @Override
    public void showCredit() {
        System.out.println("La tarjeta Silver tiene un credito de $200.000");

    }
}
