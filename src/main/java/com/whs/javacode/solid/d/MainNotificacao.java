package com.whs.javacode.solid.d;

public class MainNotificacao { 
    public static void main(String[] args) { 
        // Usando e-mail 
        ServicoMensagem emailService = new EmailService(); 
        Notificacao notificacaoEmail = new Notificacao(emailService); 
        notificacaoEmail.enviar("Olá via E-mail!"); 
 
        // Usando SMS 
        ServicoMensagem smsService = new SmsService(); 
        Notificacao notificacaoSms = new Notificacao(smsService); 
        notificacaoSms.enviar("Olá via SMS!"); 
    } 
} 
 