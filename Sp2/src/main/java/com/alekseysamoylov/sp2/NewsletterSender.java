package com.alekseysamoylov.sp2;

/**
 * Created by alekseysamoylov on 2/29/16.
 */
public interface NewsletterSender {
    void setSmtpServer (String smtpServer);
    String getSmtpServer();
    void setFormAddress(String fromAddress);
    String getFromAddress();
    void send();
}
