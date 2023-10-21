package com.company.behavioral.strategy;

public class LoverStrategyTestFormatter implements  StrategyTextFormatter{

    @Override
    public void format(String text) {
        System.out.println("Texto en minusculas: " + text.toLowerCase());
    }
}
