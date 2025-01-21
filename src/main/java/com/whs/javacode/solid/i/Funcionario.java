package com.whs.javacode.solid.i;

public class Funcionario implements Calculavel, Registravel, Beneficiavel { 
    @Override 
    public void calcularSalario() { 
        System.out.println("Calculando salário fixo."); 
    } 
 
    @Override 
    public void registrarPresenca() { 
        System.out.println("Presença registrada via ponto eletrônico."); 
    } 
 
    @Override 
    public void gerarBeneficios() { 
        System.out.println("Gerando benefícios (plano de saúde, vale-alimentação)."); 
    } 
} 
