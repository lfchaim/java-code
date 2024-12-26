package com.whs.javacode.solid.d;

public class EmailService implements ServicoMensagem { 
    @Override 
    public void enviarMensagem(String mensagem) { 
        System.out.println("Enviando e-mail: " + mensagem); 
    } 
} 
