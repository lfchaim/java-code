package com.whs.javacode.solid.o;

//Classe principal 
public class CalculadoraDesconto {
	
	public double calcular(Desconto desconto, double valorCompra) {
		return desconto.aplicar(valorCompra);
	}
	
}
