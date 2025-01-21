package com.whs.javacode.solid.i;

public class Freelancer implements Calculavel { 
    @Override 
    public void calcularSalario() { 
        System.out.println("Calculando pagamento por hora."); 
    } 
}