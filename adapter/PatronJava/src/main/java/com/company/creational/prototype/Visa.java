package com.company.creational.prototype;

public class Visa implements PrototypeCard {
    //el metodo prototipo utiliza 10 0 20 atributos con objetos complejos
    //para este ejercicio lo vamos a hacer simple,
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getCard() {
        System.out.println("Esto es una tarjeta Visa");
    }

    @Override
    public PrototypeCard clone() throws CloneNotSupportedException {
        System.out.println("Clonando tarjeta Visa...");
        return (Visa) super.clone();
    }
}
