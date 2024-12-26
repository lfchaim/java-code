package com.whs.javacode.solid.o;

public class DescontoPlatinum implements Desconto {
	public double aplicar(double valorCompra) {
		return valorCompra * 0.15;
	}
}
