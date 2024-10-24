package com.sendgrid;

public class Mail {
    private Email from;
    private String subject;
    private Email to;
    private Content content;

    public Mail(Email from, String subject, Email to, Content content) {
        this.from = from;
        this.subject = subject;
        this.to = to;
        this.content = content;
    }

    public String build() {
        
        return "Mail{" +
               "from=" + from.getEmail() +
               ", subject='" + subject + '\'' +
               ", to=" + to.getEmail() +
               ", content=" + content.getValue() +
               '}';
    }
}
