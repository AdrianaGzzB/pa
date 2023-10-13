package com.company.behavioral.mediator;

public abstract class Colleage {
    protected Mediator mediator;
    public Colleage(Mediator mediator){
        this.mediator= mediator;
    }
    //metodo para enviar y metodo para recibir
    public abstract void send(String message);
    public abstract void  messageReceived(String message);
}
