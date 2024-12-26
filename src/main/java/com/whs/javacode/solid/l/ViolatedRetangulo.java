package com.whs.javacode.solid.l;

public class ViolatedRetangulo {

	protected double largura;
	protected double altura;

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double calcularArea() {
		return largura * altura;
	}

}
