package com.company.behavioral.strategy;

public class CapitalStrategyTextFormatter implements StrategyTextFormatter {
    @Override
    public void format(String text) {
          System.out.println("Texto en mayusculas: " + text.toUpperCase());

    }
}
