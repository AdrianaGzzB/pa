package com.company.behavioral.visitor;

public class ClassicCreditCardVisitor implements CreditCardVisitor{
    @Override
    public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
        //en esta parte va la logica de tu descuento
        System.out.println("Descuento del 3% en Gasolina con tu tarjeta Clasica ");
    }

    @Override
    public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
        //En esta parte va la ligica de tu descuento
        System.out.println("Descuento del 5% en tu Vuelo con tu tarjeta Clasica");
    }
}
