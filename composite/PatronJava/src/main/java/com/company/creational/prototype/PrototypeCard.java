package com.company.creational.prototype;

public interface PrototypeCard extends Cloneable{
    //metodo tipo tarjeta
    void getCard();
    //creamos un prototipo car del metodo clon el cual va lanzar una exception cuando
    //la clase no implementa la interfaz y quiere hacer una copia del objeto a travez del metodo clone
    PrototypeCard clone() throws CloneNotSupportedException;
}
