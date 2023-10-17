package com.company.behavioral.visitor;

public interface OfertaElement {
    void accept(CreditCardVisitor visitor);
}
