package com.whs.javacode.solid.o;

public class VilatedCalculadoraDesconto {

	public double calcular(String tipoCliente, double valorCompra) {
		if (tipoCliente.equals("Regular")) {
			return valorCompra * 0.05; // 5% de desconto
		} else if (tipoCliente.equals("VIP")) {
			return valorCompra * 0.10; // 10% de desconto
		} else {
			return 0; // Sem desconto
		}
	}

}
