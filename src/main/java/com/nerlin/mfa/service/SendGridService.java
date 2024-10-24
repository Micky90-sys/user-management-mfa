package com.nerlin.mfa.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridService {

    private final SendGrid sendGrid;

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    public SendGridService(@Value("${sendgrid.api.key}") String sendGridApiKey) {
        this.sendGrid = new SendGrid(sendGridApiKey);
    }

    public String sendEmail(String to, String subject, String body) {
        Email from = new Email("noreply@yourapp.com");  // Cambia con il tuo indirizzo email
        Email toEmail = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, toEmail, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            return "Email sent successfully. Status Code: " + response.getStatusCode();
        } catch (IOException ex) {
            return "Error in sending email: " + ex.getMessage();
        }
    }
}
