package com.whs.javacode.solid.d;

public class Notificacao { 
    private ServicoMensagem servicoMensagem; 
 
    public Notificacao(ServicoMensagem servicoMensagem) { 
        this.servicoMensagem = servicoMensagem; 
    } 
 
    public void enviar(String mensagem) { 
        servicoMensagem.enviarMensagem(mensagem); 
    } 
} 
