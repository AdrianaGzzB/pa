package com.company.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CuentaComposite implements CuentaComponent{
//aqui va toda la logica
    private List<CuentaComponent> childCuentas;

    public CuentaComposite() {
        this.childCuentas = new ArrayList<>();
    }

    @Override
    public void showAccountName() {
      for(CuentaComponent cuenta:childCuentas){
          cuenta.showAccountName();
      }
    }

    @Override
    public Double getAmount() {
        Double totalAmount = 0.0;
        for(CuentaComponent cuenta: childCuentas){
            totalAmount += cuenta.getAmount();
        }
        System.out.println("La cantidad de dinero es: " + totalAmount);
        return totalAmount;
    }
    //add
    public void addCuenta(CuentaComponent cuenta){
        childCuentas.add(cuenta);
    }
    //remove
    public void removeCuenta(CuentaComponent cuenta){
        childCuentas.remove(cuenta);
    }
}
