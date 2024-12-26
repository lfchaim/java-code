package com.whs.javacode.solid.d;

public class SmsService implements ServicoMensagem { 
    @Override 
    public void enviarMensagem(String mensagem) { 
        System.out.println("Enviando SMS: " + mensagem); 
    } 
} 
