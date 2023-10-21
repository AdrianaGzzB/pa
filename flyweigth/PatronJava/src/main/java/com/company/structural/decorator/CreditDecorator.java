package com.company.structural.decorator;

public class CreditDecorator implements Credit{
    protected Credit decoratedCredit;
    public CreditDecorator(Credit decoratedCredit){
        this.decoratedCredit = decoratedCredit;
    }
    @Override
    public void showCredit() {
         decoratedCredit.showCredit();
    }
}
