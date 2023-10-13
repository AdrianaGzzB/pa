package com.company.creational.singlenton;

public class Card {
    private static Card INSTANCE;
    private String cardNumber;
    private Card(){

    }
    //el synchronized evita que si tenemos dos hilos que se entregue dos instancias a la vez.

    public synchronized static Card getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new Card();
        }
        return INSTANCE;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
