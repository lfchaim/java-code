package com.whs.javacode.solid.i;

public class ViolatedFreelancer implements ViolatedTrabalhador { 
    @Override 
    public void calcularSalario() { 
        System.out.println("Calculando pagamento por hora."); 
    } 
 
    @Override 
    public void registrarPresenca() { 
        // Este método não faz sentido para freelancers. 
        throw new UnsupportedOperationException("Freelancers não registram presença."); 
    } 
 
    @Override 
    public void gerarBeneficios() { 
        // Este método também não faz sentido. 
        throw new UnsupportedOperationException("Freelancers não recebem benefícios."); 
    } 
} 
