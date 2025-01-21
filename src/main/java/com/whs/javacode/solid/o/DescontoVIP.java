package com.whs.javacode.solid.o;

public class DescontoVIP implements Desconto {
	public double aplicar(double valorCompra) {
		return valorCompra * 0.10;
	}
}
