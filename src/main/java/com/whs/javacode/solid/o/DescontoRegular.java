package com.whs.javacode.solid.o;

//Implementações específicas 
public class DescontoRegular implements Desconto {
	public double aplicar(double valorCompra) {
		return valorCompra * 0.05;
	}
}
