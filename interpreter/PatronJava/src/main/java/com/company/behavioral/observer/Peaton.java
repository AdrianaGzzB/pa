package com.company.behavioral.observer;

public class Peaton implements Observer{
    @Override
    public void update(Semaforo semaforo) {
        if(semaforo.status.equals("ROJO_COCHE")){
            System.out.println("Semaforo Verde para peaton: -> Peaton puede pasar");
        } else {
            System.out.println("Semaforo Rojo para peaton: -> Peaton NO puede pasar");
        }
    }
}
