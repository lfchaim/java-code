package com.whs.javacode.solid.l;

public class ViolatedTesteLSP { 
    public static void main(String[] args) { 
        ViolatedRetangulo retangulo = new ViolatedQuadrado(); // Substituição 
        retangulo.setLargura(5); 
        retangulo.setAltura(10); 
 
        System.out.println("Área esperada: 50"); 
        System.out.println("Área calculada: " + retangulo.calcularArea()); 
    } 
} 
 