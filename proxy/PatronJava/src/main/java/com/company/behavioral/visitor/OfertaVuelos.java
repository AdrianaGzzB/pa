package com.company.behavioral.visitor;

public class OfertaVuelos implements OfertaElement {
    @Override
    public void accept(CreditCardVisitor visitor) {
        visitor.ofertaVuelos(this);
    }
}
//de esta manera se pueden seguir agregando ofertas cada una con su codigo por separado