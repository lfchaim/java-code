package com.whs.javacode.solid.d;

public class ViolatedNotificacao { 
    private ViolatedEmailService emailService; 
 
    public ViolatedNotificacao() { 
        this.emailService = new ViolatedEmailService(); 
    } 
 
    public void enviar(String mensagem) { 
        emailService.enviarEmail(mensagem); 
    } 
} 

 