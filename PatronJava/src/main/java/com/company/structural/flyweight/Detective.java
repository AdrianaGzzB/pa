package com.company.structural.flyweight;

public class Detective implements Enemy{
    private String weapon;
    private final String LIFE;

    public Detective() {
        LIFE = "1000";
    }

    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
        System.out.println("El arma del detective es: " + weapon);
    }

    @Override
    public void lifePoint() {
        System.out.println("La vida de un teniente es :" + LIFE);
    }
}
