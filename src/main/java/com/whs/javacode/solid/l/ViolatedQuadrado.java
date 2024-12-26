package com.whs.javacode.solid.l;

public class ViolatedQuadrado extends ViolatedRetangulo {
	@Override
	public void setLargura(double largura) {
		this.largura = largura;
		this.altura = largura; // Em um quadrado, altura = largura
	}

	@Override
	public void setAltura(double altura) {
		this.altura = altura;
		this.largura = altura; // Em um quadrado, largura = altura
	}
}
