package com.dayshare.utils.email;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.dayshare.emails.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private AmazonSimpleEmailService sesClient;

    public String sendEmail(Email email) {
        String recipient = "kylelinhardt@gmail.com";
        String sender = "Day Share <admin@dayshare.co>";
        String subject = email.getSubject();
        String body = email.getMessageBody();
        String status;

        try {
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination().withToAddresses(recipient))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withText(new Content()
                                            .withCharset("UTF-8").withData(body)))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(subject)))
                    .withSource(sender);
            sesClient.sendEmail(request);
            status = "Great Success";

        } catch (Exception ex) {
            System.out.println("Email not sent: " + ex.getMessage());
            status = "Dumbass";
        }

        return status;
    }
}
