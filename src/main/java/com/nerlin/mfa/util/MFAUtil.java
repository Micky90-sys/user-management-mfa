package com.nerlin.mfa.util;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

@Component
public class MFAUtil {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    
    public String sendVerificationCode(String email) throws IOException {
        String code = generateVerificationCode(); // Genera un codice di verifica

        Email from = new Email("no-reply@yourdomain.com");
        Email to = new Email(email);
        String subject = "Your Verification Code";
        Content content = new Content("text/plain", "Your verification code is: " + code);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException ex) {
            throw ex;
        }

        return code; // Restituisce il codice per ulteriori verifiche
    }

    // Metodo per verificare il codice di autenticazione
    public boolean verifyCode(String inputCode, String actualCode) {
        return inputCode.equals(actualCode); // Verifica se il codice corrisponde
    }

    // Metodo per generare un codice di verifica
    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // Genera un codice di 6 cifre
        return String.valueOf(code);
    }
}
