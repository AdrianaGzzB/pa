package com.company.behavioral.status;

public class Vibration implements MobileAlertState{
    @Override
    public void alert(MobileAlertStateContext context) {
        System.out.println("Vibrando.....Vibrando...");
    }
}
